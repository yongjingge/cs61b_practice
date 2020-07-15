/*
* Array based list
* */

/*
* numbers:1 2 3 4 5
* index:  0 1 2 3 4
* items: [0 0 0 0 0]
* size: 5 */
public class AList {
    private int[] items;
    private int size;

    /* create an empty list */
    public AList() {
        items = new int[100]; // an array of fixed size of 100
        size = 0;
    }

    /* Invariants of AList class:
    * addLast: the next item we want to add, will go to position 'size';
    * size: the number of the items in the list should be 'size';
    * getLast: the item we want to return, is in position 'size-1'; */

    /* Resize */
    public void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /* Insert x into the back of the list */
    public void addLast(int x) {
        /* 1. have if statement inside this method, or
         * 2. have a separate void 'resize' and use it inside this addLast method
         */
        if(size == items.length) {
            resize(size * 2);
        }
//        if(size == items.length) {
//            int[] a = new int[size + 1];
//            System.arraycopy(items, 0, a, 0, size);
//            items = a; // items pointing at the new array 'a';
//        }
        items[size] = x;
        size += 1;
    }

    /* Return the item from the back of the list */
    public int getLast() {
        return items[size - 1];
    }

    /* Get the ith item in the list */
    public int get(int i) {
        return items[i];
    }

    /* Return the number of items in the list */
    public int size() {
        return size;
    }

    /* Delete the item from the back of the list
    * and return the deleted item */
    public int deleteLast() {
        int target = getLast();
//        int target = items[size - 1];
        size -= 1;
        return target;
    }
}