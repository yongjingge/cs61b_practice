/* an Interface List61B */

public interface List61B<Item> {

	public void resize(int capacit);

	public Item getLast();

	public Item get(int index);

	public int size();

	public void removeLast();

	public void insert(Item x, int position);

	public void addFirst(Item x);

	public void addLast(Item x);

	public Item getFirst();

}