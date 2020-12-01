/**
 * climb the tree (to find its boss) —> record that ‘boss’ information
 * when we find(int p), we go directly to the boss node of p
 */

public class WeightedQuickUnionDSWithPathCompression implements DisjointSets {
    private int[] parent;
    private int[] size;
    public WeightedQuickUnionDSWithPathCompression (int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i += 1) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    private int find (int p) {
        if (p == parent[p]) {
            return p;
        } else {
            parent[p] = find(parent[p]); // find its boss
            return parent[p];
        }
    }
    @Override
    public void connect (int p, int q) {
        int p_boss = find(p);
        int q_boss = find(q);
        if (p_boss == q_boss) return;
        if (size[p_boss] < size[q_boss]) {
            parent[p_boss] = q_boss;
            size[q_boss] += size[p_boss];
        } else {
            parent[q_boss] = p_boss;
            size[p_boss] += size[q_boss];
        }
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
