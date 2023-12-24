package com.example.project4;

import java.util.ArrayList;

/**
 * Deluxe class serves as a child class to Pizza class, lets the user create their Deluxe pizza
 * Can choose size, extraSauce, extraCheese
 * @author Palak Singh, Daniel Guan
 */
public class Deluxe extends Pizza{

    /**
     * Constructor of Deluxe pizza
     * Sets the sauce to tomato
     * Sets the toppings to sausage, pepperoni, green pepper, onion, and mushroom
     */
    public Deluxe(){
        toppings = new ArrayList<>();
        this.sauce = Sauce.TOMATO;
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
    }

    /**
     * Calculates the price of a deluxe pizza
     * Takes into account the size, extraCheese, and extraSauce
     * @return double price of the pizza
     */
    @Override
    public double price() {
        double price = 14.99;
        if(size.equals(Size.MEDIUM)){
            price += 2;
        }if(size.equals(Size.LARGE)){
            price += 4;
        }
        if(extraSauce){
            price += 1;
        }
        if(extraCheese){
            price += 1;
        }
        return price;
    }

    /**
     * Getter method that will return the type of pizza: Deluxe
     * @return String "Deluxe"
     */
    @Override
    public String getType(){
        return "Deluxe";
    }
}
