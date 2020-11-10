public class IterationDemo {
	public static void main(String[] args) {
		ArrayMap<String, Integer> map = new ArrayMap<>();
		map.put("cat", 1);
		map.put("fish", 2);
		
		// ArrayMap.KeyIterator mapi = map.new KeyIterator();
		// while (mapi.hasNext()) {
		// 	System.out.println(mapi.next());
		// }

		for (String s : map) {
			System.out.println(s);
		}
	}
}