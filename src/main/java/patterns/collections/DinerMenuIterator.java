package patterns.collections;

public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items){
        this.items = items;

    }
    public boolean hasNext() {
        return !(position >= items.length || items[position] == null);


    }

    public Object next() {
        MenuItem menuItem = items[position];
        position = position+1;
        return menuItem;
    }
}
