package com.example.project4;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Testing the price() method from the BuildYourOwn class
 * @author Palak Singh, Daniel Guan
 */
public class BuildYourOwnTest {

    /**
     * Test SMALL pizza with 3 toppings
     */
    @org.junit.Test
    public void testSmall_3Topping(){
        Pizza pizza = PizzaMaker.createPizza("Build Your Own");
        pizza.setSize("small");
        ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVE, Topping.JALAPENO_PEPPER, Topping.GREEN_PEPPER));
        pizza.addTopping(toppings);
        assertEquals(8.99, pizza.price(), 0.001);
    }

    /**
     * Test SMALL pizza with 4 toppings
     */
    @org.junit.Test
    public void testSmall_4Topping(){
        Pizza pizza = PizzaMaker.createPizza("Build Your Own");
        pizza.setSize("small");
        ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVE, Topping.JALAPENO_PEPPER, Topping.GREEN_PEPPER, Topping.ONION));
        pizza.addTopping(toppings);
        assertEquals(10.48, pizza.price(), 0.001);
    }

    /**
     * Test MEDIUM pizza with 3 toppings
     */
    @org.junit.Test
    public void testMedium_3Topping(){
        Pizza pizza = PizzaMaker.createPizza("Build Your Own");
        pizza.setSize("medium");
        ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVE, Topping.JALAPENO_PEPPER, Topping.GREEN_PEPPER));
        pizza.addTopping(toppings);
        assertEquals(10.99, pizza.price(), 0.001);
    }


    /**
     * Test LARGE pizza with 3 toppings
     */
    @org.junit.Test
    public void testLarge_3Topping(){
        Pizza pizza = PizzaMaker.createPizza("Build Your Own");
        pizza.setSize("large");
        ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.JALAPENO_PEPPER, Topping.GREEN_PEPPER, Topping.ONION));
        pizza.addTopping(toppings);
        assertEquals(12.99, pizza.price(), 0.001);
    }


    /**
     * Test SMALL pizza with EXTRA CHEESE
     */
    @org.junit.Test
    public void testSmall_ExtraCheese(){
        Pizza pizza = PizzaMaker.createPizza("Build Your Own");
        pizza.setSize("small");
        ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVE, Topping.JALAPENO_PEPPER, Topping.GREEN_PEPPER));
        pizza.addTopping(toppings);
        pizza.setExtraCheese(true);
        assertEquals(9.99, pizza.price(), 0.001);
    }


    /**
     * Test SMALL pizza with EXTRA SAUCE
     */
    @org.junit.Test
    public void testSmall_ExtraSauce(){
        Pizza pizza = PizzaMaker.createPizza("Build Your Own");
        pizza.setSize("small");
        ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVE, Topping.JALAPENO_PEPPER, Topping.GREEN_PEPPER));
        pizza.addTopping(toppings);
        pizza.setExtraSauce(true);
        assertEquals(9.99, pizza.price(), 0.001);
    }

}