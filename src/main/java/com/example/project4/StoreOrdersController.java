package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Store Orders controller can view the orders placed, cancel an order, and export the order to a txt file
 * @author Palak Singh, Daniel Guan
 */
public class StoreOrdersController {

    @FXML
    private ComboBox<String> soOrderNum;

    @FXML
    private TextField soOrderTotal;

    @FXML
    private ListView<String> soPizzaList;

    private ObservableList<String> pizzaObsList, orderNumList;

    /**
     * Populates the combobox of order number
     * Sets the listview, order number, and price to the first order
     */
    public void initialize() {
        if(!StoreOrders.getOrders().isEmpty()){
            ArrayList<String> pizzaStrings = new ArrayList<>();
            for(Pizza pie : StoreOrders.getOrders().get(0).getPizzas()){
                pizzaStrings.add(pie.toString());
            }
            pizzaObsList = FXCollections.observableArrayList(pizzaStrings);
            soPizzaList.setItems(pizzaObsList);

            ArrayList<String> orderNumArrayList = new ArrayList<>();
            for(Orders od : StoreOrders.getOrders()){
                orderNumArrayList.add(String.valueOf(od.getOrderNumber()));
            }
            orderNumList = FXCollections.observableArrayList(orderNumArrayList);
            soOrderNum.setItems(orderNumList);
            soOrderNum.getSelectionModel().selectFirst();
            DecimalFormat df = new DecimalFormat("0.00");
            soOrderTotal.setText(String.valueOf(df.format(StoreOrders.getOrders().get(0).getOrder_price())));
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DISCLAIMER");
            alert.setHeaderText("INFO");
            alert.setContentText("There are currently no orders placed.");
            alert.showAndWait();
        }
    }

    /**
     * Method for handling when a order number is chosen
     * The price display and listview of pizzas on the order changes accordingly
     */
    @FXML
    void orderNumSelected(){
        if(soOrderNum.getSelectionModel().getSelectedItem() != null){
            int orderToPullUp = Integer.parseInt(soOrderNum.getSelectionModel().getSelectedItem());
            for (int i = 0; i < StoreOrders.getOrders().size(); i++){
                if (StoreOrders.getOrders().get(i).getOrderNumber() == orderToPullUp){
                    ArrayList<String> pizzaStrings = new ArrayList<>();
                    for(Pizza pie : StoreOrders.getOrders().get(i).getPizzas()){
                        pizzaStrings.add(pie.toString());
                    }
                    pizzaObsList = FXCollections.observableArrayList(pizzaStrings);
                    soPizzaList.setItems(pizzaObsList);
                    DecimalFormat df = new DecimalFormat("0.00");
                    soOrderTotal.setText(String.valueOf(df.format(StoreOrders.getOrders().get(i).getOrder_price())));
                }
            }
        }
    }

    /**
     * Method handles cancelling an order, removes it from the orders arraylist and order number selection combobox
     */
    @FXML
    protected void onsoCancelOrderButtonClick() {
        if(!StoreOrders.getOrders().isEmpty()){
            int orderNumToDelete = Integer.parseInt(soOrderNum.getSelectionModel().getSelectedItem());
//        StoreOrders.remove_order(Integer.parseInt(soOrderNum.getSelectionModel().getSelectedItem())-1);
//        System.out.println(orderNumToDelete);
            for(int i = 0; i < StoreOrders.getOrders().size(); i++) {
                if (orderNumToDelete == StoreOrders.getOrders().get(i).getOrderNumber()) {
                    StoreOrders.remove_order(i);
                    soOrderNum.getItems().remove(i);
                    if (!soOrderNum.getItems().isEmpty()) {
                        if (i != 0) {
                            soOrderNum.getSelectionModel().select(i - 1);
                        } else {
                            soOrderNum.getSelectionModel().selectFirst();
                        }
                    }
                    break;
                }
            }
            soOrderTotal.clear();
            soPizzaList.getItems().clear();
            if(!soOrderNum.getItems().isEmpty()){
                orderNumSelected();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");
            alert.setContentText("There is no order to cancel.");
            alert.showAndWait();
        }
    }

    /**
     * Method to export the order to a txt file with a filename and destination user decides
     */
    @FXML
    void onsoExportStoreOrdersButtonClick() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Store Orders");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName("StoreOrders.txt");
        File file = fileChooser.showSaveDialog(stage);
        StoreOrders.export(file);
    }
}
