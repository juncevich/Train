package patterns.factory.stores;

import patterns.factory.Pizza;
import patterns.factory.factories.NYPizzaIngredientFactory;
import patterns.factory.factories.PizzaIngredientFactory;
import patterns.factory.styles.CheesePizza;

public class ChicagoPizzaStore extends PizzaStore {
    public Pizza createPizza(String item){
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        switch (item) {
            case "cheese":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Chicago Style Cheese Pizza");
                break;
            case "pepperoni":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Chicago Style Pepperoni Pizza");
                break;
            case "clam":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Chicago Style Clam Pizza");
                break;
            case "veggie":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Chicago Style Veggie Pizza");
                break;
        }
        return pizza;
    }
}
