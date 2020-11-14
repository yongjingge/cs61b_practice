/* ArrayDeque implemented in a circular way */

public class AD<item> {
	private item[] items;
	private int size;
	private int nextFirst;
	private int nextLast;
	private static final int INIT_CAP = 8;
	private static final double MIN_RATIO = 0.25;

	/* create an empty deque */
	public AD() {
		items = (item[]) new Object[INIT_CAP];
		size = 0;
		nextFirst = 0;
		nextLast = 1;
	}

	/* minusOne index */
	private int minusOne(int index) {
		return (index - 1 + items.length) % items.length;
	}

	/* plusOne index */
	private int plusOne(int index) {
		return (index + 1) % items.length;
	}

	/* resize the arraydeque */
	private void resize(int capacity) {
		item[] newArr = (item[]) new Object[capacity];
		int curFirst = plusOne(nextFirst);
		for(int i = 0; i < size; i += 1) {
			newArr[i] = items[curFirst];
			curFirst = plusOne(curFirst);
		}
		items = newArr;
		nextFirst = capacity - 1;
		nextLast = size; // now size is the size of newArr
	}

	/* upsize the deque */
	private void upSize() {
		resize(size * 2);
	}

	/* downsize the deque */
	private void downSize() {
		resize(items.length / 2);
	}

	/* add to the front of the deque */
	public void addFirst(item x) {
		if(size == items.length) {
			upSize();
		}
		items[nextFirst] = x;
		nextFirst = minusOne(nextFirst);
		size += 1;
	}

	/* add to the back of the deque */
	public void addLast(item x) {
		if(size == items.length) {
			upSize();
		}
		items[nextLast] = x;
		nextLast = plusOne(nextLast);
		size += 1;
	}

	/* remove and return the first item of the deque */
	public item removeFirst() {
		if(size == 0) {
			return null;
		}
		int curFirst = plusOne(nextFirst);
		item removed = items[curFirst];
		items[curFirst] = null;
		nextFirst = plusOne(nextFirst);
		size -= 1;
		if(items.length >= 16 && size < items.length * MIN_RATIO) {
			downSize();
		}
		return removed;
	}

	/* remove and return the last item of the deque */
	public item removeLast() {
		if(size == 0) {
			return null;
		}
		int curLast = minusOne(nextLast);
		item removed = items[curLast];
		items[curLast] = null;
		nextLast = minusOne(nextLast);
		size -= 1;
		if(items.length >= 16 && size < items.length * MIN_RATIO) {
			downSize();
		}
		return removed;
	}

	/* get */
	public item get(int index) {
		if(index > size) {
			return null;
		}
		index = (plusOne(nextFirst) + index) % items.length;
		return items[index];
	}

	/* size */
	public int size() {
		return size;
	}

	/* isEmpty */
	public boolean isEmpty() {
		return size == 0;
	}


	public static void main(String[] args) {
		AD<Integer> a1 = new AD<>();
        a1.addFirst(0);
        // a1.removeFirst();
        a1.addFirst(2);
        // a1.removeFirst();
        a1.addLast(4);
        System.out.println(a1.removeFirst());
        a1.addFirst(6);
        a1.addLast(7);
        a1.addLast(8);
        System.out.println(a1.removeFirst());
        a1.addFirst(10);
        a1.addFirst(11);
        System.out.println(a1.get(2));
        a1.get(1);
        a1.addFirst(14);
        a1.addFirst(15);
        a1.addLast(16);
        // a1.printDeque();
        a1.get(2);
        a1.addFirst(18);
        a1.addFirst(19);
        System.out.println(a1.removeLast());
	}
}