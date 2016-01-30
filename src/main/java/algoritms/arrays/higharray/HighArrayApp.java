package algoritms.arrays.higharray;

/**
 * App class.
 */
public class HighArrayApp {
    /**
     * main method.
     *
     * @param args .
     */
    public static void main(final String[] args) {
        int maxSize = 15;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(55);
        arr.insert(55);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        int searchKey = 35;           // search for item
        if (arr.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }
        arr.delete(0);               // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                // display items again

        System.out.println(arr.getMax());
        arr.removeMax();
        arr.display();
        arr.noDups();
        arr.display();
    }
}