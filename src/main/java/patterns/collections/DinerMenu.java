package patterns.collections;

public class DinerMenu {
    static final int MAX_ITEMS=6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }

    public DinerMenu() {
        menuItems = new  MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "Some decription", true, 2.99);
    }

    public void addItem(String name, String description, boolean vegetarian,double prise){
        MenuItem menuItem = new MenuItem(name, description,vegetarian,prise);
        if (numberOfItems >= MAX_ITEMS){
            System.err.println("Menu is full");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }
}
