public class QuickUnion {
    // Initializing integer array
    private int[] id;

    public QuickUnion(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //Get the root of the element
    private int root(int i){
        while(i != id[i]) i = id[i];
        return i;
    }

    //Connected Function
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    // Union function
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
