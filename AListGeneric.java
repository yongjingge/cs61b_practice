public class AListGeneric<Item> {
    private Item[] items;
    private int size;

    /* create an empty AList */
    public AListGeneric() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /* resize the list */
    public void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /* add to the back of the list */
    public void addLast(Item x) {
        if(size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    /* return the back of the list */
    public Item getLast() {
        return items[size - 1];
    }

    /* return the i-th item of the list */
    public Item get(int i) {
        return items[i];
    }

    /* return the number of items in the list */
    public int size() {
        return size;
    }

    /* delete the last item in the list
    * and return it */
    public Item deleteLast() {
        Item target = getLast();
        items[size - 1] = null;
        size -= 1;
        return target;
    }
}