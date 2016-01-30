package patterns.factory.styles;

import patterns.factory.Pizza;
import patterns.factory.factories.PizzaIngredientFactory;
public class ClamPizza extends Pizza {
    private final PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare(){
        System.out.println("Preparing "+ name);
        dough = ingredientFactory.createDough();
        sause = ingredientFactory.createSause();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClam();

    }

    public void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
