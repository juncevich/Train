package patterns.factory;

import patterns.factory.products.Cheese;
import patterns.factory.products.Clams;
import patterns.factory.products.Dough;
import patterns.factory.products.Sauce;

import java.util.ArrayList;

public abstract class Pizza {
    public String name;
    public Dough dough;
    public Sauce sause;
    public Veggies veggies[];
    public Cheese cheese;
    Pepperoni pepperoni;
    public Clams clams;
    protected final ArrayList toppings = new ArrayList();
    // Метод стал абстрактным.
    public void prepare(){

//        System.out.println("Preparing " + name);
//        System.out.println("Tossing dought ... ");
//        System.out.println("Adding sause ...");
//        System.out.println("Adding toppings: " );
//        for (int i=0; i<toppings.size(); i++){
//            System.out.println("   " + toppings.get(i));
//        }
    }

    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slises");
    }
    public void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String toString(){
        //Код вывода пиццы.
        return null;
    }
}
