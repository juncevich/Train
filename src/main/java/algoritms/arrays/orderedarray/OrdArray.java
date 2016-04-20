package algoritms.arrays.orderedarray;

/**
 * Class, tat show ordered array.
 */
class OrdArray {
    /**
     * ref to array a.
     */
    private final long[] a;
    /**
     * number of data items.
     */
    private int nElems;

    /**
     * Class constructor.
     *
     * @param max size of array.
     */
    OrdArray(final int max) {
        a = new long[max];             // create array
        nElems = 0;
    }

    /**
     * Merge two arrays.
     *
     * @param firstArray  .
     * @param secondArray .
     * @return merged array, made from first and second array.
     */
    public static OrdArray merge(final OrdArray firstArray,
                                 final OrdArray secondArray) {
        OrdArray resultArray;
        OrdArray supportArray;
        if (firstArray.getElems() > secondArray.getElems()) {
            resultArray = firstArray;
            supportArray = secondArray;
        } else {
            resultArray = secondArray;
            supportArray = firstArray;
        }

        for (int i = 0; i < supportArray.getElems(); i++) {
            resultArray.insertOrdered(supportArray.getElement(i));
        }

        return resultArray;

    }

    /**
     * Array size.
     *
     * @return amount of array elements.
     */
    public int size() {
        return nElems;
    }

    /**
     * Find current value.
     *
     * @param searchKey current value.
     * @return founded value.
     */
    public int find(final long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;              // found it
            } else {
                if (lowerBound > upperBound) {
                    return nElems;             // can't find it
                } else {                         // divide range
                    if (a[curIn] < searchKey) {
                        lowerBound = curIn + 1; // it's in upper half
                    } else {
                        upperBound = curIn - 1; // it's in lower half
                    }
                }
            }
        }
    }

    /**
     * put element into array.
     *
     * @param value element.
     */
    public void insert(final long value) {
        int j;

        for (j = 0; j < nElems; j++) {       // find where it goes
            if (a[j] > value) {           // (linear search)
                break;
            }
        }
        System.arraycopy(a, j, a, j + 1, nElems - j);
        a[j] = value;                  // insert it
        nElems++;                      // increment size
    }

    /**
     * In this method used binary search.
     *
     * @param value value.
     */
    public void insertOrdered(final long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {

            curIn = (lowerBound + upperBound) / 2;

            if (a[curIn] < value) {
                lowerBound = curIn + 1; // it's in upper half
            } else {
                upperBound = curIn - 1; // it's in lower half
            }
            if (value < a[curIn + 1] & value > a[curIn]) {
                break;
            }
        }
        System.arraycopy(a, curIn, a, curIn + 1, nElems - curIn);

        a[curIn + 1] = value;
        nElems++;
    }

    /**
     * delete element from array.
     *
     * @param value element.
     * @return result of operation.
     */
    public void delete(final long value) {
        final int j = find(value);
        if (j == nElems) {                 // can't find it
        } else {                          // found it
            System.arraycopy(a, j + 1, a, j, nElems - j);
            nElems--;                   // decrement size
        }
    }

    /**
     * Get current element from array.
     *
     * @param value element index.
     * @return element.
     */
    private long getElement(final int value) {
        return a[value];
    }

    /**
     * Return size of array.
     * @return nElems.
     */
    private int getElems() {
        return nElems;
    }

    /**
     * Print array elements.
     */
    public void display() {            // displays array contents
        for (int j = 0; j < nElems; j++) {       // for each element,
            System.out.print(a[j] + " ");  // display it
        }
        System.out.println("");
    }

}
