package patterns.factory.styles;

import patterns.factory.Pizza;

public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        String name = "Chicago Style Deep Dish Cheese Pizza";
        String dough = "Extra Thick Crust Dought";
        String sause = "Plum Tomato Sause";

        toppings.add("Shredded Mozzarella Cheese");
    }
    public void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
