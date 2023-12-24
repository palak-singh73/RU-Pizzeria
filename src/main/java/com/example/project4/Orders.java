package com.example.project4;

import java.util.ArrayList;

/**
 * Orders class handles the pizza order the user makes
 * @author Palak Singh, Daniel Guan
 */
public class Orders {

    private ArrayList<Pizza> pizzas;
    private int orderNumber;
    private double order_price;

    private static ArrayList<Pizza> building_current_order = new ArrayList<>();
    private static double current_subtotal = 0;

    /**
     * Constructor for building a single order
     */
    public Orders(){
        pizzas = new ArrayList<>();
        for(Pizza pi : building_current_order){
            pizzas.add(pi);
        }
        orderNumber = StoreOrders.getnext_order_number();
        order_price = current_subtotal * 1.06625;
    }

    /**
     * Getter method for retrieving a single pizza in the order
     * @return Pizza pizza in order
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Getter method for order number
     * @return int order number
     */
    public int getOrderNumber(){
        return orderNumber;
    }

    /**
     * Getter method for price/cost of the order
     * @return double price/cost of order
     */
    public double getOrder_price() {
        return order_price;
    }

    /**
     * Getter method for next order number
     * @return int next order number
     */
    public static int getNextOrderNumber(){
        return StoreOrders.getnext_order_number();
    }

    /**
     * Method to reset the order listview of pizzas
     */
    public static void resetOrderList(){
        building_current_order.clear();
    }

    /**
     * Method to reset the order subtotal
     */
    public static void resetOrderSubtotal(){
        current_subtotal = 0;
    }

    /**
     * Method to add pizza to the order
     * Adds the pizza to the order arraylist and adds the price of pizza to the order subtotal price/cost
     * @param pizza to be added to order
     */
    public static void addPizzaToOrder(Pizza pizza){
        building_current_order.add(pizza);
        current_subtotal += pizza.price();
    }

    /**
     * Method to remove pizza from the order
     * Removes the pizza from the order arraylist and subtracts the price of the pizza from the order subtotal price/cost
     * @param pizza to be removed from order
     */
    public static void removePizzaFromOrder(String pizza){
        int removeIndex = -1;
        for(int i = 0; i < building_current_order.size(); i++){
            if(building_current_order.get(i).toString().equals(pizza)){
                current_subtotal -= building_current_order.get(i).price();
                removeIndex = i;
            }
        }
        if(removeIndex != -1)
            building_current_order.remove(removeIndex);
    }

    /**
     * Getter method for the arraylist of pizzas in the order
     * @return ArrayList of Pizzas in order
     */
    public static ArrayList<String> getPizzaArrayList(){
        ArrayList<String> pizzaStrings = new ArrayList<>();
        for(Pizza pie : building_current_order){
            pizzaStrings.add(pie.toString());
        }
        return pizzaStrings;
    }

    /**
     * Getter method for retrieving the subtotal cost of the order
     * @return double subtotal cost of order
     */
    public static double getTotal(){
        return current_subtotal;
    }
}
