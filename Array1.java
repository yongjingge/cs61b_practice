/* 2D Arrays: Array of Array Addresses */

public class Array1 {
    public static void main(String[] args) {
        /* Array of Array Addresses */
        int[][] x = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] z = new int[3][];
        /*
         * this makes z[0] and x[0] pointing at the same address where {1, 2, 3} stays
         */
        z[0] = x[0];
        /*
         * this makes z[0][0] a negative one, and because x[0][0] is also pointing at
         * the same address, x[0][0] is now also negative
         */
        z[0][0] = -z[0][0];

        int[][] w = new int[3][3];
        /*
         * arraycopy will make int[][]w a new list, it will not point at the same
         * address as array x does
         */
        System.arraycopy(x[0], 0, w[0], 0, 3);
        w[0][0] = -w[0][0];

        System.out.println("x[0][0] is: " + x[0][0]);
        System.out.println("z[0][0] is: " + z[0][0]);
        System.out.println("w[0][0] is: " + w[0][0]);

        /* Array of Integers */
        int[] a = new int[] { 1, 2, 3 };
        int[] b = new int[3];
        b[0] = a[0];
        b[0] = -b[0];
        System.out.println("a[0]" + a[0]);
        System.out.println("b[0]" + b[0]);
    }
}