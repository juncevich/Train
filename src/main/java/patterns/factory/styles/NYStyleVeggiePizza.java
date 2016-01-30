package patterns.factory.styles;

import patterns.factory.Pizza;

public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        String name = "NY Style Sause and Cheese Pizza";
        String dough = "Thin Crust Dought";
        String sause = "Marianna Sause";

        toppings.add("Grated Reggiano Cheese");
    }
}
