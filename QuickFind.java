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

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
    
        System.out.println("Initially: ");
        System.out.println("Connected (3, 4)? " + qf.connected(3, 4)); // false
    
        qf.union(3, 4);
        System.out.println("After union(3, 4):");
        System.out.println("Connected (3, 4)? " + qf.connected(3, 4)); // true
    
        qf.union(4, 9);
        System.out.println("After union(4, 9):");
        System.out.println("Connected (3, 9)? " + qf.connected(3, 9)); // true
    
    }

}

