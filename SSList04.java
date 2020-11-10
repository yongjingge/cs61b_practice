/*
 * SSList version 4.0 an singly linked list that can take a specified type of
 * parameter
 */

/* <Stuff> works as a placeholder */
public class SSList04<Stuff> {

    private StuffNode first;

    private int size;

    /* Constructor */
    public SSList04(Stuff x) {
        // StuffNode have a public Stuff item and a public StuffNode next
        first = new StuffNode(x, null);
        size = 1;
    }

    /* Nestec Class StuffNode */
    private class StuffNode {
        public Stuff item;
        public StuffNode next;

        public StuffNode(Stuff i, StuffNode n) {
            item = i;
            next = n;
        }

        public String toString() {
            return item + " " + next;
        }
    }

    public void addFirst(Stuff x) {
        first = new StuffNode(x, first);
        size += 1;
    }

    public void addLast(Stuff x) {
        StuffNode p = first;
        if (first == null) {
            first = new StuffNode(x, null);
            size += 1;
        }
        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
        size += 1;
    }

    // getFirst() will return a Stuff
    public Stuff getFirst() {
        return first.item;
    }

    public int size() {
        return size;
    }

    public String toString() {
        return first + " ";
    }
}