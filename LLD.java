/** 
* LinkedListDeque
* implemented in a circular way
* 环状双向链表：注意删除/添加时，需要完成两侧指针prev和next的修改！
*/

public class LLD<item> {
	private ListNode sentinel;
	private int size;

	/* Nested Class: ListNode */
	private class ListNode {
		private item i;
		private ListNode prev;
		private ListNode next;
		public ListNode(item i, ListNode prev, ListNode next) {
			this.i = i;
			this.prev = prev;
			this.next = next;
		}
	}

	/* LLD constructor: empty */
	public LLD() {
		sentinel = new ListNode(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
		size = 0;
	}

	/* addFirst */
	public void addFirst(item x) {
		size += 1;
		sentinel.next = new ListNode(x, sentinel, sentinel.next);
		sentinel.next.next.prev = sentinel.next;
	}

	/* removeFirst */
	public item removeFirst() {
		if(isEmpty()) {
			return null;
		}
		item first = sentinel.next.i;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size -= 1;
		return first;
	}

	/* addLast */
	public void addLast(item x) {
		size += 1;
		sentinel.prev = new ListNode(x, sentinel.prev, sentinel);
		sentinel.prev.prev.next = sentinel.prev;
	}

	/* removeLast */
	public item removeLast() {
		if(isEmpty()) {
			return null;
		}
		item last = sentinel.prev.i;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size -= 1;
		return last;
	}

	/* isEmpty */
	public boolean isEmpty() {
		return size == 0;
	}

	/* size */
	public int size() {
		return size;
	}

	/* get: iteration */
	public item get(int index) {
		if(isEmpty()) {
			return null;
		}
		ListNode p = sentinel;
		for (int j = 0; j < index; j += 1) {
			p = p.next;
		}
		return p.next.i;
	}

	/* get: recursion */
	public item getRecur(int index) {
		return helper(sentinel.next, index);
	}

	private item helper(ListNode cur, int index) {
		if(index == 0) {
			return cur.i;
		} else {
			return helper(cur.next, index - 1);
		}
	}

	public static void main(String[] args) {
	
		LLD<Integer> ls = new LLD<>();
		ls.addFirst(0);
		ls.addFirst(1);
		ls.addFirst(2);
		ls.isEmpty();
		ls.addFirst(4);
		ls.addFirst(5);
		ls.addFirst(6);
		System.out.println(ls.removeLast());
		System.out.println(ls.removeLast());
		System.out.println(ls.get(3));

		LLD<Integer> ls2 = new LLD<>();
		ls2.addLast(0);
		ls2.addLast(1);
		ls2.addLast(3);
		System.out.println(ls2.isEmpty());
		ls2.removeLast();
		System.out.println(ls2.removeLast());

		LLD<Integer> ls3 = new LLD<>();
		ls3.addFirst(100);
		System.out.println(ls3.removeLast());
	}
}