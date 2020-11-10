public class SpeedTestSSList03 {
    public static void main(String[] args) {
        SSList03 list = new SSList03();
        for(int i = 0; i < 10000; i++) {
            list.addLast(i);
        }
    }
}