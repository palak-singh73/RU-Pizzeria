package com.example.project4;

import java.util.ArrayList;

/**
 * Supreme class serves as a child class to Pizza class, lets the user create their Supreme pizza
 * Can choose size, extraSauce, extraCheese
 * @author Palak Singh, Daniel Guan
 */
public class Supreme extends Pizza{

    /**
     * Constructor of Supreme pizza
     * Sets the sauce to tomato
     * Sets the toppings to sausage, pepperoni, ham, green pepper, onion, black olive, and mushroom
     */
    public Supreme(){
        toppings = new ArrayList<>();
        this.sauce = Sauce.TOMATO;
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
    }

    /**
     * Calculates the price of a supreme pizza
     * Takes into account the size, extraCheese, and extraSauce
     * @return double price of the pizza
     */
    @Override
    public double price() {
        double price = 15.99;
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
     * Getter method that will return the type of pizza: Supreme
     * @return String "Supreme"
     */
    public String getType(){
        return "Supreme";
    }
}
