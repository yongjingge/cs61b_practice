public class SSList04Launcher {
    public static void main(String[] args) {
        SSList04<String> list = new SSList04<String>("bone");
        list.addLast("thugs");
        list.addFirst("head");
        System.out.println(list.toString());

        SSList04<Integer> list2 = new SSList04<Integer>(22);
        list2.addFirst(11);
        list2.addLast(33);
        System.out.println(list2.toString());
    }
}