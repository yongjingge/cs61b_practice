public interface DisjointSets {
    // connect two items p and q
    void connect(int p, int q);
    // check to see if two items are connected
    boolean isConnected(int p, int q);
}
