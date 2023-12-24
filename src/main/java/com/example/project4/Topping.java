package com.example.project4;

/**
 * Enum class for Toppings (13 in total, of which 11 were given)
 * @author Daniel Guan, Palak Singh
 */
public enum Topping {

    SAUSAGE ("Sausage"),
    PEPPERONI ("Pepperoni"),
    BEEF ("Beef"),
    HAM ("Ham"),
    SHRIMP ("Shrimp"),
    SQUID ("Squid"),
    CRAB_MEATS ("Crab Meats"),
    GREEN_PEPPER ("Green Pepper"),
    ONION ("Onion"),
    BLACK_OLIVE ("Black Olive"),
    MUSHROOM ("Mushroom"),
    JALAPENO_PEPPER ("Jalapeno Pepper"),
    PINEAPPLE ("Pineapple");

    private final String printingName;

    /**
     * Constructor to initialize a new topping
     * @param printingName the name that would be displayed on the interface
     */
    Topping(String printingName) {
        this.printingName = printingName;
    }

    /**
     * toString method that would be used to print out the name of each topping
     * @return String name that would be used for display
     */
    @Override
    public String toString(){
        return printingName;
    }

}
