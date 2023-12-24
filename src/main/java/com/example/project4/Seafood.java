package com.example.project4;

import java.util.ArrayList;

/**
 * Pepperoni class serves as a child class to Pizza class, lets the user create their Seafood pizza
 * Can choose size, extraSauce, extraCheese
 * @author Palak Singh, Daniel Guan
 */
public class Seafood extends Pizza{

    /**
     * Constructor of Seafood pizza
     * Sets the sauce to alfredo
     * Sets the toppings to shrimp, squid, crab meat
     */
    public Seafood(){
        toppings = new ArrayList<>();
        this.sauce = Sauce.ALFREDO;
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEATS);
    }

//    public Seafood(Size size, boolean extraSauce, boolean extraCheese){
//        this.size = size;
//        this.sauce = Sauce.ALFREDO;
//        this.extraSauce = extraSauce;
//        this.extraCheese = extraCheese;
//        toppings.add(Topping.SHRIMP);
//        toppings.add(Topping.SQUID);
//        toppings.add(Topping.CRAB_MEATS);
//    }

    /**
     * Calculates the price of a seafood pizza
     * Takes into account the size, extraCheese, and extraSauce
     * @return double price of the pizza
     */
    @Override
    public double price() {
        double price = 17.99;
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
     * Getter method that will return the type of pizza: Seafood
     * @return String "Seafood"
     */
    public String getType(){
        return "Seafood";
    }
}
