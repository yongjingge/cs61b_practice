/* Extra Exercise for IntList */
/* MyNote:
** wrongly put 'class IntList {}' into the 'public class IntListExtraEx {}'
** and causes a static context using non-static variables mistake! 
*/

/*
IntListExtraEx 
*/
public class IntListExtraEx {

	/* Main function */
	public static void main(String[] args) {
		IntList ilist = new IntList(5, null);
		ilist = new IntList(10, ilist);
		ilist = new IntList(15, ilist);

		//iterativeSize
		System.out.println(ilist.iterativeSize());
		//recursiveGet
		System.out.println(ilist.recursiveGet(2));
		// print out ilist
		System.out.println(ilist.toString());
		//incrList
		System.out.println(IntList.incrementList(ilist, 3).toString());
		//dincrList
		System.out.println(IntList.dincrementList(ilist, 5).toString());
	}
}



/*
IntList
*/
class IntList {
	public int first;
	public IntList rest;

	/* constructor */
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}


	/*
	Return the size of the list
	using Recursion and it is
	a non-static method
	*/
	public int recursiveSize() {
		// base case: assume the rest is null
		// cannot use 'this == null', will cause NullPointer error
		if(rest == null) {
			return 1;
		}
		return 1 + this.rest.recursiveSize();
	}


	/*
	Return the size of the list
	using an Iterative way
	and it is a non-static method
	*/
	public int iterativeSize() {
		// 'this' cannot be reassigned, p is used as a pointer
		IntList p = this;
		int size = 0;
		while(p != null) {
			size += 1;
			p = p.rest;
		}
		return size;
	}


	/*
	Return the i-th item in the list
	using Recursion and it is
	a non-static method
	*/
	public int recursiveGet(int index) {
		if(index == 0) {
			return first;
		}
		return this.rest.recursiveGet(index - 1);
	}


	/*
	Return the i-th item in the list
	using an Iterative way
	and it is a non-static method
	*/
	public int iterativeGet(int index) {
		IntList p = this;
		if(index == 0) {
			return p.first;
		}
		for(int i = 0; i < index; i++) {
			p = p.rest;
		}
		return p.first;
	}


	/*
	Extra Exercise
	*/

	/*
	Return an IntList identical to L, 
	but with each element incremented by x.
	L is not allowed to change.

	Recursion
	it is a static method invoked by the Class.
	*/
	public static IntList incrementList(IntList L, int x) {
		if(L == null) {
			return null;
		}
		IntList res = new IntList(L.first + x, incrementList(L.rest, x));
		return res;
	}


	/*
	Return an IntList identical to L, 
	but with each element incremented by x.
	Not allowed to use the 'new' keyword.
	
	Using an Iterative way
	it is a static method invoked by the Class.
	*/
	public static IntList dincrementList(IntList L, int x) {
		IntList p = L;
		while(p != null) {
			p.first += x;
			p = p.rest;
		}
		return L;
	}


	public String toString() {
		return first + " " + rest + " ";
	}

}
