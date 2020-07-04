/* SSList version 2.0, 
demonstrating the fastSize method,
we put size as part of the attribute of SLList
*/

public class SSList02 {

	private IntNode first;

	/* we put size variable inside the instance */
	private int size; 

	/* Constructor */
	public SSList02(int x) {
		first = new IntNode(x, null);
		// when instantiated, the size will be 1
		size = 1;
	}

	/* an Empty list */
	public SSList02 () {
		first = null;
		size = 0;
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



	public void addFirst(int x) {
		first = new IntNode(x, first);
		size += 1;
	}


	public void addLast(int x) {
		IntNode p = first;
		/* because the exist of the empty list constructor
		we need to add a special case 
		*/
		if(first == null) {
			first = new IntNode(x, null);
			size += 1;
			return;
		}

		while(p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size += 1;
	}


	public int getFirst() {
		return first.item;
	}

	/* Return the size of the list in a faster way */
	public int size() {
		return size;
	}


	public static void main(String[] args) {
		SSList02 p = new SSList02(20);
		p.addLast(30);
		p.addLast(40);
		p.addFirst(10);
		System.out.println(p.size());
		System.out.println(p.getFirst());

		SSList02 l = new SSList02();
		System.out.println(l.size());
		l.addLast(10);
		System.out.println(l.size());
	}
}
