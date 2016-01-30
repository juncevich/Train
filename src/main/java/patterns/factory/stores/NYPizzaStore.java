package patterns.factory.stores;

import patterns.factory.Pizza;
import patterns.factory.factories.NYPizzaIngredientFactory;
import patterns.factory.factories.PizzaIngredientFactory;
import patterns.factory.styles.CheesePizza;

public class NYPizzaStore extends PizzaStore {
    public Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        } else if (item.equals("clam")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if (item.equals("veggie")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        }
        return pizza;
    }
}
