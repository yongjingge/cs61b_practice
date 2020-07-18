/* SSList version 1.0
showing the use of Nested Class
*/

public class SSList {

	/* IntNode(int item, IntNode next); */
	/*
	 * a private declaration it cannot be accessed or used from a class outside the
	 * SSList class
	 */
	private IntNode first;

	/* constructor */
	/* In this structure, we don't need to specify the null element in the list */
	public SSList(int x) {
		first = new IntNode(x, null);
	}

	/*
	 * Nested Classes Users of class SLList will not have the chance to make an
	 * IntNode instance from the IntNode class
	 */
	private static class IntNode {
		/*
		 * in a private nested class like this, the access modifiers like public int or
		 * public IntNode are irrelevant
		 */
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}

		public String toString() {
			return item + " " + next;
		}
	}

	public String toString() {
		return first + " ";
	}

	/* Add x to the front of the list */
	public void addFirst(int x) {
		// if(first == null) {
		// first = new IntNode(x, null);
		// }
		first = new IntNode(x, first);
	}

	/* Add x to the end of the list */
	public void addLast(int x) {
		/*
		 * first declare the first element in the SSList list and it should be an
		 * IntNode
		 */
		IntNode p = first;
		// scan p to the end of the list
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
	}

	/* Return the front element of the list */
	public int getFirst() {
		/*
		 * MyNote: return the front element of the list means that we need to return the
		 * first integer. if we use 'return first', it will return an IntNode 'first',
		 * we should use 'return first.item', and it will return the correct integer.
		 */

		return first.item;
	}

	/* Return the size of the list */

	/* MyBit */
	public int getSize() {
		IntNode p = first;
		int count = 0;
		while (p != null) {
			p = p.next;
			count++;
		}
		return count;
	}

	/* From Lecture */
	/*
	 * Initialise a helper method that returns the size of the list that starts at
	 * IntNode p
	 */

	/* This works on the SLList */
	public int size() {
		return size(first);
	}

	/* This works on the IntNode: Recursion */
	private static int size(IntNode p) {
		if (p.next == null) {
			return 1;
		}
		return 1 + size(p.next);
	}

	public static void main(String[] args) {
		/* creates a list of one integer, namely 20 */
		SSList list = new SSList(20);
		System.out.println(list.toString());

		/* creates a list of one integer 22, and add 33 to the front the list */
		SSList list2 = new SSList(22);
		System.out.println(list2.toString());
		list2.addFirst(33);
		list2.addFirst(44);
		System.out.println(list2.toString());

		/* returns the first item of the list */
		System.out.println(list2.getFirst());

		/* add 11 to the end of the list */
		list2.addLast(11);
		System.out.println(list2.toString());
		System.out.println(list2.getSize());

		list2.addLast(10);
		System.out.println(list2.size());
		System.out.println(list2.toString());
	}

}