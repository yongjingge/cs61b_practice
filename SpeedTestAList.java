public class SpeedTestAList {
    public static void main(String[] args) {
        AList a = new AList();
        int i = 0;
        while(i < 10000000) {
            a.addLast(i);
            i++;
        }
    }
}