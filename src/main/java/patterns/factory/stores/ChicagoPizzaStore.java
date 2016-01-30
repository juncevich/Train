package patterns.factory.stores;

import patterns.factory.Pizza;
import patterns.factory.factories.NYPizzaIngredientFactory;
import patterns.factory.factories.PizzaIngredientFactory;
import patterns.factory.styles.CheesePizza;

public class ChicagoPizzaStore extends PizzaStore {
    public Pizza createPizza(String item){
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if (item.equals("pepperoni")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Pepperoni Pizza");
        } else if (item.equals("clam")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        } else if (item.equals("veggie")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Veggie Pizza");
        }
        return pizza;
    }
}
