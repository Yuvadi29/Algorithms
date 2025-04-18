/*Given a set of n integers S= {0,1,....n-1} and a sequence of requests of following form:
 * Rmove x from S
 * Find the successor of x: the smallest y in S such that y>= x
 * Design a data type so that all operations (except constructions) take logarithmic time or better in worst case.
 * 
 * Start with {0,1,2,3,4}
Remove 2 → {0,1,3,4}
Successor(2) → 3

Use Union-Find again!

When you remove a number x, link it to its next number x+1

To find the successor of x, just use find(x)
 */

class SuccessorWithDelete {
    private int[] parent;
    private int n;

    public SuccessorWithDelete(int n) {
        this.n = n;
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (x > n) return n;
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void remove(int x) {
        if (x < n)
            parent[x] = find(x + 1);  // point to next available
    }

    public int successor(int x) {
        int succ = find(x);
        return succ < n ? succ : -1;  // -1 if no successor
    }
}
