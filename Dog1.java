/* Lecture 10 */
/* Dog1 (class) implements OurComparable (a system built-in interface)
 *  to instantiate the method 'compareTo'
 *
 * NameComparator <- a nested class of the Dog1 class,
 * and this nested class should implements Comparator interface
 * */

import java.util.Comparator;

public class Dog1 implements Comparable<Dog1> {
    private String name;
    private int size;
    /* constructor */
    public Dog1(String name, int size) {
        this.name = name;
        this.size = size;
    }
    public void bark() {
        System.out.println(name + " says: bark!");
    }
    public int compareTo(Dog1 theDog) {
        if (this.size > theDog.size) {
            return 1;
        } else if (this.size == theDog.size) {
            return 0;
        }
        return -1;
    }

    /* no need to instantiate a Dog1 class to make the NameComparator class, so it can be STATIC */
    public static class NameComparator implements Comparator<Dog1> {
        public int compare(Dog1 a, Dog1 b) {
            /* refers to the compareTo method of String
            *  returns positive number if a.name comes later than b.name in the alphabet,
            *  returns negative number otherwise */
            return a.name.compareTo(b.name);
        }
    }
}