public class WeightedQuickUnion implements DisjointSets {
    private int[] parent;
    private int[] size; // number of elements in subtree rooted at i
    public WeightedQuickUnion (int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i += 1) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
    @Override
    public void connect (int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        // make smaller root point to larger one
        if (size[rootp] > size[rootq]) {
            parent[rootp] = rootq;
            size[rootq] += size[rootp];
        } else {
            parent[rootq] = rootp;
            size[rootp] += size[rootq];
        }
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
