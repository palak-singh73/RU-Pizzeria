package com.example.project4;

import java.util.ArrayList;

/**
 * Meatzza class serves as a child class to Pizza class, lets the user create their Meatzza pizza
 * Can choose size, extraSauce, extraCheese
 * @author Palak Singh, Daniel Guan
 */
public class Meatzza extends Pizza{

    /**
     * Constructor of Meatzza pizza
     * Sets the sauce to tomato
     * Sets the toppings to sausage, pepperoni, beef, and ham
     */
    public Meatzza(){
        toppings = new ArrayList<>();
        this.sauce = Sauce.TOMATO;
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);
    }

    /**
     * Calculates the price of a meatzza pizza
     * Takes into account the size, extraCheese, and extraSauce
     * @return double price of the pizza
     */
    @Override
    public double price() {
        double price = 16.99;
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
     * Getter method that will return the type of pizza: Meatzza
     * @return String "Meatzza"
     */
    public String getType(){
        return "Meatzza";
    }
}
