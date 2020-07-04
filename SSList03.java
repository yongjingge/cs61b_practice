/* SSList version 3.0
demonstrating the use of Sentinel Node 
to avoid the NullPointer error
*/

public class SSList03 {

	/* the first item would be at sentinel.next */
	private IntNode sentinel;

	private int size;

	/* an Empty one */
	public SSList03() {
		sentinel = new IntNode(-1, null);
		size = 0;
	}

	/* Constructor */
	public SSList03(int x) {
		sentinel = new IntNode(-1, null);
		// first would be at sentinel.next
		sentinel.next = new IntNode(x, null);
		size += 1;
	}



	/* Nested Class IntNode */
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}


	/* Add x to the front of the list */
	/* Attention: sentinel should never be reassigned! */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}


	/* Return the front item of the list */
	public int getFirst() {
		return sentinel.next.item;
	}


	/* Add x to the end of the list */
	public void addLast(int x) {
		IntNode p = sentinel;
		while(p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size += 1;
	}


	/* Return the size of the list */
	public int size() {
		return size;
	}


	public static void main(String[] args) {
		SSList03 p = new SSList03();
		System.out.println(p.size());
		p.addFirst(1);
		p.addLast(2);
		System.out.println(p.size());
		System.out.println(p.getFirst());
	}

}


/* Targeting Fundamental problem
the empty SSList has a null first, 
we cannot access first.next!
Solution1: a special case;
Solution2: make all SSLists the same,even the empty one!
		   create a node that is always there, the sentinel node,
		   the empty SSList will point to the sentinel node rather than the null node;
*/