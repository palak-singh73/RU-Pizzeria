package com.example.project4;

/**
 * BuildYourOwn class serves as a child class to Pizza class, lets the user create their own custom pizza
 * Can choose sauce, toppings, size, extraSauce, extraCheese
 * @author Palak Singh, Daniel Guan
 */
public class BuildYourOwn extends Pizza{

    /**
     * Calculates the price of a BuildYourOwn pizza
     * Takes into account the toppings, size, extraCheese, and extraSauce
     * @return double price of the pizza
     */
    @Override
    public double price() {
        double price = 8.99;
        if(toppings.size() > 3) {
            price += (toppings.size() - 3) * (1.49);
        }
        if(size.equals(Size.MEDIUM)){
            price += 2;
        }else if(size.equals(Size.LARGE)){
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
     * Method that will return the type of pizza: Build Your Own
     * @return String "Build Your Own"
     */
    @Override
    public String getType(){
        return "Build Your Own";
    }
}
