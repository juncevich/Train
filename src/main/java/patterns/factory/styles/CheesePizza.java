package patterns.factory.styles;

import patterns.factory.Pizza;
import patterns.factory.factories.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sause = ingredientFactory.createSause();
        cheese = ingredientFactory.createCheese();

    }

    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
