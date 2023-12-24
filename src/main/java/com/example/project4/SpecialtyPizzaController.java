package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;

/**
 * Specialty Pizza controller lets the viewer choose a specialty pizza to order
 * @author Palak Singh, Daniel Guan
 */
public class SpecialtyPizzaController {

    private Pizza currentPie;
    private ObservableList<String> specialtyTypes;
    @FXML
    private ComboBox<String> specialtyMenu;
    @FXML
    private ListView<String> spToppingsList;
    @FXML
    private ImageView spImageView;
    @FXML
    private TextField spSauceDisplay;
    @FXML
    private RadioButton spSmallButton, spMediumButton, spLargeButton;
    @FXML
    private CheckBox spExtraCheeseCheckbox, spExtraSauceCheckbox;
    @FXML
    private TextField spPriceDisplay;

    /**
     * Sets the specialty combobox to the choices Deluxe, Supreme, Meatzza, Seafood, Pepperoni
     */
    public void initialize() {
        specialtyTypes = FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        specialtyMenu.setItems(specialtyTypes);
    }

    /**
     * Method to handle when specialty is chosen
     * The image and price change accordingly
     */
    @FXML
    protected void specialtyChosen(){
        if(specialtyMenu.getSelectionModel().getSelectedItem() != null){
            currentPie = PizzaMaker.createPizza(specialtyMenu.getSelectionModel().getSelectedItem());
            changeImage();
            spSauceDisplay.setText(currentPie.sauce.name());
            spToppingsList.getItems().clear();
            for(int i = 0; i < currentPie.toppings.size(); i++){
                spToppingsList.getItems().add(currentPie.toppings.get(i).toString());
            }
            pricing();
        }
    }

    /**
     * Getter method for the type of specialty pizza selected
     * @return String specialty pizza type
     */
    private String getSpecialty(){
        if(specialtyMenu.getSelectionModel().getSelectedIndex() > -1){
            return specialtyMenu.getValue();
        }
        return null;
    }

    /**
     * Method to change image based on specialty pizza selected
     */
    private void changeImage(){
        Image newImage = null;
        if(specialtyMenu.getSelectionModel().getSelectedItem().equalsIgnoreCase("Deluxe")){
            newImage = new Image("file:src/main/resources/com/example/project4/Deluxe.png");
        }else if(specialtyMenu.getSelectionModel().getSelectedItem().equalsIgnoreCase("Supreme")){
            newImage = new Image("file:src/main/resources/com/example/project4/Supreme.png");
        }else if(specialtyMenu.getSelectionModel().getSelectedItem().equalsIgnoreCase("Meatzza")){
            newImage = new Image("file:src/main/resources/com/example/project4/Meatzza.png");
        }else if(specialtyMenu.getSelectionModel().getSelectedItem().equalsIgnoreCase("Seafood")){
            newImage = new Image("file:src/main/resources/com/example/project4/Seafood.png");
        }if(specialtyMenu.getSelectionModel().getSelectedItem().equalsIgnoreCase("Pepperoni")){
            newImage = new Image("file:src/main/resources/com/example/project4/Pepperoni.png");
        }
        spImageView.setImage(newImage);
    }

    /**
     * Error message displays when trying to order a pizza without selecting a size
     */
    private void noSizeChosenError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        alert.setContentText("Please choose a size for the pizza.");
        alert.showAndWait();
    }

    /**
     * Error message displays when trying to order a pizza without selecting a specialty pizza type
     */
    private void noSpecialtyChosenError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        alert.setContentText("Please choose a specialty pizza.");
        alert.showAndWait();
    }

    /**
     * Method to add a pizza to the order
     * Displays an added-to-order popup message and resets the selections
     */
    private void pizzaAddedToOrder(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText("Order");
        alert.setContentText("Pizza added to the order.");
        alert.showAndWait();
        specialtyMenu.getSelectionModel().clearSelection();
        specialtyMenu.setValue(null);
        specialtyMenu.setPromptText("Pick a Specialty");
        spSmallButton.setSelected(false);
        spMediumButton.setSelected(false);
        spLargeButton.setSelected(false);
        spSauceDisplay.clear();
        spToppingsList.getItems().clear();
        spExtraCheeseCheckbox.setSelected(false);
        spExtraSauceCheckbox.setSelected(false);
        spImageView.setImage(new Image("file:src/main/resources/com/example/project4/DefaultPizza.jpg"));
        spPriceDisplay.clear();
    }

    /**
     * Getter method for the size of the pizza
     * @return String size: small, medium, or large
     */
    private String getSize(){
        String size = null;
        if(spSmallButton.isSelected()){
            size = "small";
        }else if (spMediumButton.isSelected()){
            size = "medium";
        }else if(spLargeButton.isSelected()){
            size = "large";
        }
        return size;
    }

    /**
     * Method to display the price of the pizza based on user selection
     */
    @FXML
    protected void pricing(){
        if (getSize() != null && currentPie != null){
            currentPie.setSize(getSize());
            currentPie.setExtraCheese(spExtraCheeseCheckbox.isSelected());
            currentPie.setExtraSauce(spExtraSauceCheckbox.isSelected());
            DecimalFormat df = new DecimalFormat("0.00");
            String price = String.valueOf(df.format(currentPie.price()));
            spPriceDisplay.setText(price);
        }
    }

    /**
     * Method to add pizza to the order
     */
    @FXML
    protected void onspAddToOrderButtonClick() {
        if(getSpecialty() == null){
            noSpecialtyChosenError();
        }else if(getSize() == null){
            noSizeChosenError();
        }else{
            Orders.addPizzaToOrder(currentPie);
            pizzaAddedToOrder();
        }
    }

}