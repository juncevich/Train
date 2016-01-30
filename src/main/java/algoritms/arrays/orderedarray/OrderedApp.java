package algoritms.arrays.orderedarray;


import static algoritms.arrays.orderedarray.OrdArray.merge;

/**
 * Application class.
 */
public class OrderedApp {
    /**
     * Main method.
     *
     * @param args args.
     */
    public static void main(final String[] args) {
        int maxSize = 100;             // array size
        OrdArray arr;                  // reference to array
        arr = new OrdArray(maxSize);   // create the array

        arr.insert(77);                // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55;            // search for item
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }
        arr.display();                 // display items

        arr.delete(0);                // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                 // display items again
        arr.insertOrdered(30);
        arr.display();

        OrdArray firstArray = new OrdArray(90);
        OrdArray secondArray = new OrdArray(100);
        firstArray.insert(1);
        firstArray.insert(3);
        firstArray.insert(5);
        firstArray.insert(7);
        firstArray.insert(9);
        secondArray.insert(0);
        secondArray.insert(2);
        secondArray.insert(4);
        secondArray.insert(6);
        secondArray.insert(8);
        secondArray.insert(10);

        OrdArray resultArray = merge(firstArray, secondArray);
        resultArray.display();
        System.out.println();
    }
}