package algoritms.arrays.higharray;

/**
 * Class, that wrap array and show high-level working with array.
 */
class HighArray {
    /**
     * ref to array a.
     */
    private final long[] a;
    /**
     * number of data items.
     */
    private int nElems;

    /**
     * constructor of class.
     *
     * @param max maximum size of array.
     */
    HighArray(final int max) {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    /**
     * find specified value.
     *
     * @param searchKey key, that we need find in array.
     * @return find status.
     */
    public final boolean find(final long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {          // for each element,
            if (a[j] == searchKey) {            // found item?
                break;                          // exit loop before end
            }
        }
        return j != nElems;
    }

    /**
     * put element into array.
     *
     * @param value inserted value.
     */
    public final void insert(final long value) {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    /**
     * delete specified value.
     *
     * @param value deleted value.
     *
     */
    public final void delete(final long value) {
        int j;
        for (j = 0; j < nElems; j++) {        // look for it
            if (value == a[j]) {
                break;
            }
        }
        if (j == nElems) {                  // can't find it
        } else {                          // found it
            System.arraycopy(a, j + 1, a, j, nElems - j);
            nElems--;                   // decrement size
        }
    }

    /**
     * displays array contents.
     */
    public final void display() {
        for (int j = 0; j < nElems; j++) {       // for each element,
            System.out.print(a[j] + " ");       // display it
        }
        System.out.println("");
    }

    /**
     * Get value in maximum key.
     *
     * @return value in maximum key
     * or "-1" if array is empty.
     */
    public final long getMax() {
        long returnValue;
        if (a.length == 0) {
            returnValue = -1;
        } else {
            returnValue = a[nElems - 1];
        }
        return returnValue;
    }

    /**
     * Delete max key value.
     */
    public final void removeMax() {
        delete(getMax());
    }

    /**
     * Remove dups in array.
     */
    public final void noDups() {
        for (long element : a
                ) {
            int repeatCount = 0;
            for (long anA : a) {
                if (element == anA) {
                    repeatCount++;
                    if (repeatCount == 2) {
                        System.out.println("Deleting dup: " + anA);
                        delete(element);
                    }

                }
            }
        }

    }
}
