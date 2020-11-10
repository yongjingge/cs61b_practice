// SSList version 5.0 an singly linked list that can take parameter 
// and has sentinel node

public class SSList05<Stuff> {
	private StuffNode sentinel;
	private int size;

	// constructor
	public SSList05(Stuff x) {
		sentinel = new StuffNode(Stuff i, null);
		sentinel.next = new StuffNode(x, null);
		size += 1;
	}

	public SSList05() {
		sentinel = new StuffNode(Stuff i, null);
		size = 0;
	}

	// Nested Class StuffNode
	private class StuffNode {
		Stuff item;
		StuffNode next;

		StuffNode(Stuff item, StuffNode next) {
			this.item = item;
			this.next = next;
		}
	}

	public void addFirst(Stuff x) {
		sentinel = new StuffNode(x, sentinel.next);
		size += 1;
	}

	public void addLast(Stuff x) {
		StuffNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new StuffNode(x, null);
		size += 1;
	}

	public Stuff getFirst() {
		return sentinel.next.item;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		SSList05<Integer> sl = new SSList05<>();
		sl.addFirst(1);
		sl.addFirst(2);
		sl.addLast(3);
		System.out.println(sl.size());
		System.out.println(sl.getFirst());
	}
}