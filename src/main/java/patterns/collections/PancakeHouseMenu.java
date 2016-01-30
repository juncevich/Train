package patterns.collections;

import java.util.ArrayList;

public class PancakeHouseMenu {
    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();

        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toasts", true, 2.99);
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description,vegetarian,price);
        menuItems.add(menuItem);
    }


    public Iterator createIterator() {
        return null;
    }
}
