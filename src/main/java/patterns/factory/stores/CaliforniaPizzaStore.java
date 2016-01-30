package patterns.factory.stores;

import patterns.factory.factories.NYPizzaIngredientFactory;
import patterns.factory.Pizza;
import patterns.factory.factories.PizzaIngredientFactory;
import patterns.factory.styles.CheesePizza;

public class CaliforniaPizzaStore extends PizzaStore {
    public Pizza createPizza(String item){
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("California Style Cheese Pizza");
        } else if (item.equals("pepperoni")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("California Style Pepperoni Pizza");
        } else if (item.equals("clam")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("California Style Clam Pizza");
        } else if (item.equals("veggie")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("California Style Veggie Pizza");
        }
        return pizza;
    }
}
