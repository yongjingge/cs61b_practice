/* Lecture 2 IntList */

public class IntList {
	public int first;
	public IntList rest;

	// constructor
	public IntList(int first, IntList rest) {
		this.first = first;
		this.rest = rest;
	}

	// the way to print an object
	public String toString() {
		return ("IntList is: " + first + rest);
	}

	// Return the size of the list using Recursion, it should be a non-static method invoked by an instance
	public int getSize() {
		if(rest == null) {
			return 1;
		} else {
			return 1 + this.rest.getSize();
		}
	}

	// Return the size of the list using an Iterative method!
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while(p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	// Return the i-th item in the list using an Iterative method!
	public int getItem(int i) {
		IntList p = this;
		if(i == 0) {
			return p.first; // if looking for the 0th item, we will return the first of the intlist
		}
		for(int j = 0; j < i; j++) { // when j = i, the for loop ends, we move to the i-th element of the intlist
			p = p.rest; // after this, the rest would be elements after i
		}
		return p.first;
	}

	// Return the i-th item in the list using Recursion
	public int get(int i) {
		if(i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	public static void main(String[] args) {
		// using the constructor
		IntList L = new IntList(5, null);
		L = new IntList(10, L);
		L = new IntList(11, L);

		// not using the constructor
		// IntList L = new IntList();
		// L.first = 5;
		// L.rest = null;
		// L.rest = new IntList();
		// L.rest.first = 10;
		// L.rest.rest = new IntList();
		// L.rest.rest.first = 11;

		System.out.println(L.toString());
		System.out.println("The size of this intlist is: " + L.getSize() + " using recursion!");
		System.out.println("The size of this intlist is: " + L.iterativeSize() + " using an iterative method!");
		System.out.println("The i-th element of this intlist is: " + L.get(2));
		System.out.println("The i-th element of this intlist is: " + L.getItem(2));
	}
}