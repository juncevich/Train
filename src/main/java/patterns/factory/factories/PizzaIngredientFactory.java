package patterns.factory.factories;

import patterns.factory.Pepperoni;
import patterns.factory.Veggies;
import patterns.factory.products.Cheese;
import patterns.factory.products.Clams;
import patterns.factory.products.Dough;
import patterns.factory.products.Sauce;

public interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSause();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClam();

}
