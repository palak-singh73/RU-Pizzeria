package com.example.project4;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Abstract Pizza class serves as a parent class and template for all the other pizza types
 * @author Palak Singh, Daniel Guan
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected boolean extraSauce;
    protected boolean extraCheese;

    /**
     * Abstract method that will get the price of the pizza
     * @return double price of pizza
     */
    public abstract double price();

    /**
     * Abstract method that will get the type of the pizza (Deluxe, Meatzza, Supreme, Seafood, Pepperoni, or Build Your Own)
     * @return String type of pizza
     */
    public abstract String getType();

    /**
     * Setter method to set the size of the pizza
     * @param size of pizza to be set to
     */
    public void setSize(String size){
        if(size.equalsIgnoreCase("small")){
            this.size = Size.SMALL;
        }else if(size.equalsIgnoreCase("medium")){
            this.size = Size.MEDIUM;
        }else if(size.equalsIgnoreCase("large")){
            this.size = Size.LARGE;
        }else{
            this.size = Size.SMALL;
        }
    }

    /**
     * Setter method to set whether user wants extra cheese on the pizza
     * @param extraCheese boolean to put extra cheese on pizza or not
     */
    public void setExtraCheese(boolean extraCheese){
        this.extraCheese = extraCheese;
    }

    /**
     * Setter method to set whether user wants extra sauce on the pizza
     * @param extraSauce boolean to put extra sauce on pizza or not
     */
    public void setExtraSauce(boolean extraSauce){
        this.extraSauce = extraSauce;
    }

    /**
     * Setter method to set what sauce user wants on the pizza (tomato or alfredo)
     * @param sauce to put on pizza
     */
    public void pickSauce(String sauce){
        if(sauce.equalsIgnoreCase("tomato")){
            this.sauce = Sauce.TOMATO;
        }else if (sauce.equalsIgnoreCase("alfredo")){
            this.sauce = Sauce.ALFREDO;
        }
    }

    /**
     * Setter method to set what toppings user wants on the pizza (sausage, pepperoni, etc.)
     * @param toppings Arraylist of toppings to put on pizza
     */
    public void addTopping(ArrayList<Topping> toppings){
        this.toppings = toppings;
    }

    /**
     * toString method to print the pizza as shown on orders list
     * @return String of pizza in form [type] (toppings) (sauce) (extraSauce) (extraCheese) $(price)
     */
    public String toString(){
        String singlePizza = "";
        singlePizza += "[" + this.getType() + "] ";
        for(Topping top : this.toppings){
            singlePizza += top.toString() + ", ";
        }
        singlePizza += size.toString().toLowerCase() + ", " + sauce.toString().toLowerCase() + ", ";
        if(extraSauce)
            singlePizza += "extra sauce, ";
        if(extraCheese)
            singlePizza += "extra cheese, ";
        DecimalFormat df = new DecimalFormat("0.00");
        singlePizza += "$" + df.format(this.price());
        return singlePizza;
    }
}