import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayMap<K, V> implements Map61B<K, V>, Iterable<K> {
	private K[] keys;
	private V[] values;
	int size;

	public ArrayMap() {
		keys = (K[]) new Object[100];
		values = (V[]) new Object[100];
		size = 0;
	}

	// this is the method that overrides Iterable<K>
	public Iterator<K> iterator () {
		// return new KeyIterator();
		List<K> keyslist = keys();
		return keyslist.iterator();
	}

	// public class KeyIterator implements Iterator<K> {
	// 	private int pos;
	// 	public KeyIterator() {
	// 		pos = 0;
	// 	}

	// 	public boolean hasNext() {
	// 		return pos != size;
	// 	}

	// 	public K next() {
	// 		K returnValue = keys[pos];
	// 		pos += 1;
	// 		return returnValue;
	// 	}
	// }

	private int keyIndex(K key) {
		for (int i = 0; i < size; i += 1) {
			if (keys[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}

	public boolean containsKey(K key) {
		int index = keyIndex(key);
		return index > -1;
	}

	public void put(K key, V value) {
		int index = keyIndex(key);
		if (index == -1) {
			keys[size] = key;
			values[size] = value;
			size += 1;
			return;
		}
		values[index] = value;
	}

	public V get(K key) {
		int index = keyIndex(key);
		return values[index];
	}

	public int size() {
		return size;
	}

	public List<K> keys() {
		List<K> keylist = new ArrayList<>();
		for (int i = 0; i < size; i += 1) {
			keylist.add(keys[i]);
		}
		return keylist;
	}

	public static void main(String[] args) {
		ArrayMap<String, Integer> m = new ArrayMap<>();
		m.put("fish", 7);
		m.put("cat", 3);
		m.put("house", 10);
		System.out.println(m.get("cat"));
	}
}