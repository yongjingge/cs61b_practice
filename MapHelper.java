import java.util.List;
import org.junit.Test;

public class MapHelper {
	// get method: return item in map if it exists.
	public static <K, V> V get(Map61B<K, V> map, K key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}

	@Test
	public void testGet() {
		Map61B<String, Integer> m1 = new ArrayMap<String, Integer>();
		m1.put("dog", 2);
		m1.put("cat", 3);
		m1.put("fish", 4);

		Integer expected = 3;
		// MapHelper.get indicates that 'get' should be a STATIC method
		Integer actual = MapHelper.get(m1, "cat");
		assertEquals(expected, actual);
	}

	// maxKey: return max of all keys, works only if x and y have comparable data.
	public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
		List<K> keylist = map.keys();
		K max = keylist.get(0);
		for (K k : keylist) {
			if (k.compareTo(max)> 0) {
				max = k;
			}
		}
		return max;
	}

	@Test
	public void testMaxKey() {
		Map61B<String, Integer> m2 = new ArrayMap<String, Integer>();
		m2.put("dog", 2);
		m2.put("cat", 3);
		m2.put("fish", 4);
		String expected = "fish";
		String actual = MapHelper.maxKey(m2);
		assertEquals(expected, actual);
	}
}