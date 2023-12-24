package com.example.project4;

/**
 * Helps create an instance of Pizza
 * ONLY class that can new an instance of Pizza subclasses
 * @author Palak Singh, Daniel Guan
 */
public class PizzaMaker {
    /**
     * Creates a pizza object based on the given pizza type
     * @param pizzaType String that contains the type of pizza to create
     * @return Pizza object of the specified type, or null if the type is not recognized
     */
    public static Pizza createPizza(String pizzaType) {
        Pizza newPizza = null;
        if(pizzaType.equalsIgnoreCase("Deluxe")){
            newPizza = new Deluxe();
        }else if (pizzaType.equalsIgnoreCase("Supreme")){
            newPizza = new Supreme();
        }else if (pizzaType.equalsIgnoreCase("Meatzza")){
            newPizza = new Meatzza();
        }else if (pizzaType.equalsIgnoreCase("Pepperoni")){
            newPizza = new Pepperoni();
        }else if (pizzaType.equalsIgnoreCase("Seafood")){
            newPizza = new Seafood();
        }else if (pizzaType.equalsIgnoreCase("Build Your Own")){
            newPizza = new BuildYourOwn();
        }
        return newPizza;
    }
}
