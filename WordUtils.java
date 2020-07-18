public class WordUtils {
	/* return the longest word */
	public static String longest(List61B<String> list) {
		int maxIndex = 0;
		for(int i = 0; i < list.size(); i++) {
			String longestString = list.get(maxIndex);
			String cur = list.get(i);
			if (cur.length() > longestString.length()) {
				maxIndex = i;
			}
		}
		return list.get(maxIndex);
	}

	public static void main(String[] args) {
		ArList<String> alist = new ArList<>();
		alist.addLast("first");
		alist.addLast("second");
		alist.addLast("thirdone");
		System.out.println(longest(alist));
	}
}