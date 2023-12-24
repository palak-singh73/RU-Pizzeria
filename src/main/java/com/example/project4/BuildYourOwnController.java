package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Build Your Own controller lets the viewer create a custom pizza
 * Uses comboxbox, listview, radio buttons, and checkboxes to choose size, toppings, sauce, and extras on the pizza
 * @author Palak Singh, Daniel Guan
 */
public class BuildYourOwnController {

    private ObservableList<String> toppingsList;

    @FXML
    private ComboBox<String> size_menu;
    @FXML
    private RadioButton byoAlfredoButton;
    @FXML
    private RadioButton byoTomatoButton;
    @FXML
    private CheckBox byoExtraCheeseButton;
    @FXML
    private CheckBox byoExtraSauceButton;
    @FXML
    private TextField byoPrice;
    @FXML
    private ListView<String> byoSelectedToppings;
    @FXML
    private ListView<String> byoChooseToppings;

    /**
     * Used to populate the size combo-box and "choose you topping" listview
     */
    public void initialize() {
        ObservableList<String> sizeList = FXCollections.observableArrayList("Small", "Medium", "Large");
        size_menu.setItems(sizeList);
        ArrayList<String> toppingsArrayList = new ArrayList<>();
        for(Topping top : Topping.values()){
            toppingsArrayList.add(top.toString());
        }
        toppingsList = FXCollections.observableArrayList(toppingsArrayList);
        byoChooseToppings.setItems(toppingsList);
    }

    /**
     * Message that would be displayed if there are more than 3 toppings are added to a small pizza
     * Tells the user that each topping with be an extra $1.49
     */
    private void moreThan3ToppingsMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("DISCLAIMER");
        alert.setHeaderText("INFO");
        alert.setContentText("You have added more than 3 toppings to the Pizza\nAfter 3 each topping will be an extra $1.49");
        alert.showAndWait();
    }

    /**
     * Error message if the user tries to add more than 7 toppings
     */
    private void moreThan7ToppingsError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        alert.setContentText("You can only add up to 7 toppings.");
        alert.showAndWait();
    }

    /**
     * Error Message if no size has been selected
     */
    private void noSizeChosenError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        alert.setContentText("Please choose a size for the pizza.");
        alert.showAndWait();
    }

    /**
     * Error Message if no sauce has been selected
     */
    private void noSauceChosenError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        alert.setContentText("Please choose a sauce for the pizza.");
        alert.showAndWait();
    }

    /**
     * Info Message that pizza has been added to order
     */
    private void pizzaAddedToOrderMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText("Order");
        alert.setContentText("Pizza added to the order.");
        alert.showAndWait();
    }

    /**
     * Info Message that pizza has been added to order
     */
    private void notEnoughToppingsError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText("Please add at least 3 toppings to the pizza.");
        alert.showAndWait();
    }

    /**
     * Method to add topping to the custom pizza
     * Moves the topping from available toppings to selected items, adjusts the price
     * Shows error if user tries adding more than 7 toppings
     */
    @FXML
    protected void onbyoAddToppingButtonClick() {
        int selectedAddID = byoChooseToppings.getSelectionModel().getSelectedIndex();
        if(byoSelectedToppings.getItems().size() < 7){
            if(selectedAddID < 0){
                selectedAddID = 0;
                byoSelectedToppings.getItems().add(byoChooseToppings.getItems().get(selectedAddID));
                if((byoSelectedToppings.getItems().size() == 4) && (size_menu.getSelectionModel().getSelectedIndex() > -1)){
                    moreThan3ToppingsMessage();
                }
            }else{
                byoSelectedToppings.getItems().add(byoChooseToppings.getSelectionModel().getSelectedItem());
                if((byoSelectedToppings.getItems().size() == 4) && (size_menu.getSelectionModel().getSelectedIndex() > -1)){
                    moreThan3ToppingsMessage();
                }
            }
            byoChooseToppings.getItems().remove(selectedAddID);
        }else{
            moreThan7ToppingsError();
        }
        if(size_menu.getSelectionModel().getSelectedIndex() > -1){
            pricing();
        }
    }

    /**
     * Method to remove topping from the custom pizza
     * Moves the topping from selected toppings to available items, adjusts the price
     */
    @FXML
    protected void onbyoRemoveToppingButtonClick() {
        try{
            int selectedRemoveID = byoSelectedToppings.getSelectionModel().getSelectedIndex();
            if(selectedRemoveID < 0){
                selectedRemoveID = 0;
                byoChooseToppings.getItems().add(byoSelectedToppings.getItems().get(selectedRemoveID));
            }else{
                byoChooseToppings.getItems().add(byoSelectedToppings.getSelectionModel().getSelectedItem());
            }
            byoSelectedToppings.getItems().remove(selectedRemoveID);
            if(size_menu.getSelectionModel().getSelectedIndex() > -1){
                pricing();
            }
        }catch (IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");
            alert.setContentText("No Topping to Remove");
            alert.showAndWait();
        }
    }

    /**
     * Calculates the price of the custom pizza, based on size, toppings, extra sauce, extra cheese
     */
    @FXML
    protected void pricing(){
        Pizza currentPie = PizzaMaker.createPizza("Build Your Own");
        if ((getSize() != null) && (getSauce() != null)){
            pizzaBuild(currentPie);
            DecimalFormat df = new DecimalFormat("0.00");
            String price = String.valueOf(df.format(currentPie.price()));
            byoPrice.setText(price);
        }
    }


    /**
     * Getter method for the size of the BuildYourOwn pizza
     * @return size String selected in the size_menu combobox
     */
    private String getSize(){
        if(size_menu.getSelectionModel().getSelectedIndex() > -1){
            return size_menu.getValue();
        }
        return null;
    }

    /**
     * Getter method for sauce chosen based on the two sauce radio buttons
     * @return String tomato or alfredo
     */
    private String getSauce(){
        if(byoTomatoButton.isSelected()){
            return "tomato";
        }else if(byoAlfredoButton.isSelected()){
            return "alfredo";
        }
        return null;
    }

    /**
     * Getter method for Toppings on pizza
     * @return ArrayList of Toppings on pizza
     */
    @FXML
    protected ArrayList<Topping> getToppings(){
        ObservableList<String> items = byoSelectedToppings.getItems();
        ArrayList<Topping> toppings = new ArrayList<>();
        for(int i = 0; i < items.size(); i++){
            for(Topping t : Topping.values()){
                if (t.toString().equalsIgnoreCase(items.get(i))){
                    toppings.add(t);
                }
            }
        }
        return toppings;
    }

    /**
     * Helper method to build the pizza: set size, sauce, toppings, extraCheese, and extraSauce
     * @param buildingPizza Pizza being built
     */
    @FXML
    private void pizzaBuild(Pizza buildingPizza){
        buildingPizza.setSize(getSize());
        buildingPizza.setExtraCheese(byoExtraCheeseButton.isSelected());
        buildingPizza.setExtraSauce(byoExtraSauceButton.isSelected());
        buildingPizza.pickSauce(getSauce());
        buildingPizza.addTopping(getToppings());
    }


    /**
     * Adds the built pizza to orders list
     */
    @FXML
    protected void onbyoAddToOrderButtonClick() {
        if(getSize() == null){
            noSizeChosenError();
        }else if(getSauce() == null){
            noSauceChosenError();
        }else if(byoSelectedToppings.getItems().size() < 3){
            notEnoughToppingsError();
        }else{
            Pizza tobeAddedPizza = PizzaMaker.createPizza("Build Your Own");
            pizzaBuild(tobeAddedPizza);
            Orders.addPizzaToOrder(tobeAddedPizza);
            pizzaAddedToOrderMessage();
            size_menu.getSelectionModel().clearSelection();
            size_menu.setValue(null);
            size_menu.setPromptText("Pick a Size");
            byoTomatoButton.setSelected(false);
            byoAlfredoButton.setSelected(false);
            byoExtraCheeseButton.setSelected(false);
            byoExtraSauceButton.setSelected(false);
            ArrayList<String> toppingsArrayList = new ArrayList<>();
            for(Topping top : Topping.values()){
                toppingsArrayList.add(top.toString());
            }
            toppingsList = FXCollections.observableArrayList(toppingsArrayList);
            byoChooseToppings.setItems(toppingsList);
            byoSelectedToppings.getItems().clear();
            byoPrice.clear();
        }
    }
}
