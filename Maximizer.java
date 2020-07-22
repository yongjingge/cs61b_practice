/* Lecture 10 */

public class Maximizer {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("A", 3), new Dog("B", 9), new Dog("C", 10)};
        Dog maxDog = (Dog) max(dogs);
        maxDog.bark();
    }

    public static OurComparable max(OurComparable[] items) {
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
