/** DisjointSets implementation II
 * using an Array to record node (components of a set) information
 * assign each node (items of a component/set) a parent (instead of an int[] array)
 * the 'top' node is the boss of the set
 */

public class QuickUnionDS implements DisjointSets {
    private int[] parent;
    public QuickUnionDS (int N) {
        parent = new int[N];
        for (int i = 0; i < N; i += 1) {
            parent[i] = i;
        }
    }
    private int find (int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
    @Override
    public void connect (int p, int q) {
        int p_parent = find(p);
        int q_parent = find(q);
        parent[p_parent] = q_parent; // now parent node of p is parent of q.
    }
    @Override
    public boolean isConnected (int p, int q) {
        return find(p) == find(q);
    }
}
