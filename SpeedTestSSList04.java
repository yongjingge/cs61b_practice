public class SpeedTestSSList04 {
    public static void main(String[] args) {
        SSList04<Integer> list = new SSList04<>(1);
        for(int i = 0; i < 10000; i++) {
            list.addLast(i);
        }
    }
}