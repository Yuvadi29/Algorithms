public class QuickFind {
    // Initializing integer array
    private int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // Function to check if 2 nodes are connected
    public boolean connected(int p, int q) {
        // Return those whose values are the same
        return id[p] == id[q];
    }

    // Function to connect the components
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}

