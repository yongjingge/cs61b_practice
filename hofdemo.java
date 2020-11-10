public class hofdemo {
    public static int do_twice(IntUnaryFunction f, int x) {
        /* 调用了IntUnaryFunction这一接口的apply method, argument1 should be
        * an object(IntUnaryFunction f */
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        /*
        IntUnaryFunction tenX = new TenX(); //interface -> instantiate the class
        System.out.println(do_twice(tenX, 2));
        */
        System.out.println(do_twice(new TenX(), 2));
    }
}
