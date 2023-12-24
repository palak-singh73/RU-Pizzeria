package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main Menu controller has four buttons, opens SpecialtyPizzasView, BuildYourOwnPizzaView, CurrentOrderView, or StoreOrdersView
 * @author Palak Singh, Daniel Guan
 */
public class MainMenuController {

    /**
     * Button click opens SpecialityPizzaView.fxml
     * @throws IOException
     */
    @FXML
    protected void onSpecialityPizzaButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("SpecialtyPizzasView.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Order Specialty Pizzas");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Button click opens BuildYourOwnPizzaView.fxml
     * @throws IOException
     */
    @FXML
    protected void onBuildYourOwnPizzaButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("BuildYourOwnPizzaView.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Build Your Own Pizza");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Button click opens CurrentOrderView.fxml
     * @throws IOException
     */
    @FXML
    protected void onCurrentOrderButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("CurrentOrderView.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Current Order");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Button click opens StoreOrdersView.fxml
     * @throws IOException
     */
    @FXML
    protected void onStoreOrdersButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("StoreOrdersView.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Store Order");
        stage.setScene(scene);
        stage.show();
    }
}