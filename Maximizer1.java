/* Lecture 10
*  work with Comparable interface */

public class Maximizer1 {
    public static Comparable max(Comparable[] items) {
        int maxIndex = 0;
        for(int i = 0; i < items.length; i++) {
            int cmp = items[i].compareTo(items[maxIndex]);
            if (cmp > 0) {
                maxIndex = i;
            }
        }
        return items[maxIndex];
    }
}