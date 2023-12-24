package com.example.project4;

import java.util.ArrayList;

/**
 * Pepperoni class serves as a child class to Pizza class, lets the user create their Pepperoni pizza
 * Can choose size, extraSauce, extraCheese
 * @author Palak Singh, Daniel Guan
 */
public class Pepperoni extends Pizza{

    /**
     * Constructor of Pepperoni pizza
     * Sets the sauce to tomato
     * Sets the toppings to pepperoni
     */
    public Pepperoni(){
        toppings = new ArrayList<>();
        this.sauce = Sauce.TOMATO;
        toppings.add(Topping.PEPPERONI);
    }

    /**
     * Calculates the price of a pepperoni pizza
     * Takes into account the size, extraCheese, and extraSauce
     * @return double price of the pizza
     */
    @Override
    public double price() {
        double price = 10.99;
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
     * Getter method that will return the type of pizza: Pepperoni
     * @return String "Pepperoni"
     */
    public String getType(){
        return "Pepperoni";
    }
}
