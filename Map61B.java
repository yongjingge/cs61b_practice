import java.util.List;

public interface Map61B<K, V> {
	// returns true if this map contains a mapping for the specified key.
	boolean containsKey(K key);

	// returns the value to which the specified key is mapped. No defined behavior 
	// if the key doesn't exist (it's ok to crash)
	V get(K key);

	// returns the number of key-value mappings in this map
	int size();

	// associates the specified value to the specified key
	void put(K key, V value);

	// returns a list of the keys in this map
	List<K> keys();
}