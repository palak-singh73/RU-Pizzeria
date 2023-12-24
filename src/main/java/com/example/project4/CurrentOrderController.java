package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

/**
 * Current Order controller can view the subtotal, taxes, and total of the order, remove pizzas on the order list, and place order
 * @author Palak Singh, Daniel Guan
 */
public class CurrentOrderController {

    @FXML
    private TextField orderNumber;

    @FXML
    private TextField orderTotal;

    @FXML
    private ListView<String> pizzaOrderList;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField subtotal;

    /**
     * Sets up the listview to show the list of pizzas on the order
     */
    public void initialize() {
        ObservableList<String> pizzasList = FXCollections.observableArrayList(Orders.getPizzaArrayList());
        pizzaOrderList.setItems(pizzasList);
        setCosts();
        orderNumber.setText(String.valueOf(Orders.getNextOrderNumber()));
    }

    /**
     * Displays the subtotal, sales tax amount, and order total amount on the text fields
     */
    private void setCosts(){
        DecimalFormat df = new DecimalFormat("0.00");
        subtotal.setText(String.valueOf(df.format(Orders.getTotal())));
        salesTax.setText(String.valueOf(df.format((Orders.getTotal() * 0.06625))));
        orderTotal.setText(String.valueOf(df.format((Orders.getTotal() * 1.06625))));
    }

    /**
     * Removes a pizza on the listview of pizzas and adjusts the total costs.
     */
    @FXML
    void onRemovePizzaButtonClick() {
        if(pizzaOrderList.getSelectionModel().getSelectedIndex() > -1){
            Orders.removePizzaFromOrder(pizzaOrderList.getSelectionModel().getSelectedItem());
            pizzaOrderList.getItems().remove(pizzaOrderList.getSelectionModel().getSelectedIndex());
            setCosts();
        }
    }

    /**
     * Places the pizza order
     */
    @FXML
    void onPlaceOrderButtonClick() {
        if(!pizzaOrderList.getItems().isEmpty()){
            Orders order = new Orders();
            StoreOrders.add_order(order);
            Orders.resetOrderList();
            Orders.resetOrderSubtotal();
            subtotal.clear();
            salesTax.clear();
            orderTotal.clear();
            pizzaOrderList.getItems().clear();
            StoreOrders.incrementnext_order_number();
            orderNumber.setText(String.valueOf(Orders.getNextOrderNumber()));
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");
            alert.setContentText("Cannot add an Empty Order.");
            alert.showAndWait();
        }
    }
}
