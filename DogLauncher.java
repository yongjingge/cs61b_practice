public class DogLauncher {
    public static void main(String[] args) {
        Dog1[] dogs = {new Dog1("A", 3), new Dog1("B", 9), new Dog1("C", 10)};
        Dog1 res = (Dog1) Maximizer1.max(dogs);
        res.bark();

        Dog1 d1 = new Dog1("A", 3);
        Dog1 d2 = new Dog1("E", 3);
        Dog1.NameComparator nc = new Dog1.NameComparator();
        /* nc.compare function */
        if (nc.compare(d1, d2) > 0) {
            /* means d1 comes later than d2 in the alphabet */
            d1.bark();
        } else {
            d2.bark();
        }
    }
}
