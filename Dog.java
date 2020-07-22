/* Lecture 10 */
/* Dog (class) implements OurComparable (a self-defined interface)
*  to instantiate the method 'compareTo' */

public class Dog implements OurComparable {
    private String name;
    private int size;
    /* constructor */
    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }
    public void bark() {
        System.out.println(name + " says: bark!");
    }
    public int compareTo(Object o) {
        Dog theDog = (Dog) o;
        if (this.size > theDog.size) {
            return 1;
        } else if (this.size == theDog.size) {
            return 0;
        }
        return -1;
    }
}
