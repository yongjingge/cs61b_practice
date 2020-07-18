/* class implements interface */

public class ArList<Item> implements List61B<Item> {
	private Item[] items;
	private int size;

	public ArList() {
		size = 0;
		items = (Item[]) new Object[100];
	}

	@Override
	public void resize(int capacity) {
		Item[] a = (Item[]) new Object[capacity];
		System.arraycopy(items, 0, a, 0, size);
		items = a;
	}

	@Override
	public void addLast(Item x) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[size] = x;
		size += 1;
	}

	@Override
	public Item getLast() {
		int last = size - 1;
		return items[last];
	}

	@Override
	public Item get(int index) {
		return items[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void removeLast() {
		items[size - 1] = null;
		size -= 1;
	}

	@Override
	public void insert(Item x, int position) {
		Item[] newArr = (Item[]) new Object[items.length + 1];
		System.arraycopy(items, 0, newArr, 0, position);
		newArr[position] = x;
		System.arraycopy(items, position, newArr, position + 1, items.length - position);
		items = newArr;
	}

	@Override
	public void addFirst(Item x) {
		insert(x, 0);
	}

	@Override
	public Item getFirst() {
		return get(0);
	}
}