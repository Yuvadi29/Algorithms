/*Add a method find() to the union-find data type so that find(i) returns the largest element in connected component containing i. The operations union(), connected(), find() should all take logarithmic time or better.
 * 
 * If 1, 2, 6, and 9 are all connected, then find(2) should return 9 (the biggest in the group).
 * 
 */


class UnionFindWithMax {
    private int[] parent, rank, max;

    public UnionFindWithMax(int n) {
        parent = new int[n];
        rank = new int[n];
        max = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            max[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
            max[rootX] = Math.max(max[rootX], max[rootY]);
        } else {
            parent[rootX] = rootY;
            max[rootY] = Math.max(max[rootX], max[rootY]);
            if (rank[rootX] == rank[rootY]) rank[rootY]++;
        }
    }

    public int findMax(int x) {
        return max[find(x)];
    }
}
