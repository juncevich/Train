package patterns.factory.factories;

import patterns.factory.Pepperoni;
import patterns.factory.SlicedPepperoni;
import patterns.factory.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSause() {
        return new PlumTomatSause();
    }

    @Override
    public Cheese createCheese() {
        return new MozarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(), new Spinash(), new Eggplant()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
