package patterns.factory.factories;

import patterns.factory.PepperoniPizza;
import patterns.factory.Pizza;
import patterns.factory.VeggiePizza;
import patterns.factory.styles.CheesePizza;
import patterns.factory.styles.ClamPizza;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        switch (type) {
            case "cheese":
                pizza = new CheesePizza(new ChicagoPizzaIngredientFactory());
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
            case "clam":
                pizza = new ClamPizza(new NYPizzaIngredientFactory());
                break;
            case "veggie":
                pizza = new VeggiePizza();
                break;
        }
        return pizza;
    }
}
