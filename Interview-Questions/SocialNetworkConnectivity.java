
import java.util.List;

//Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships. Design an algorithm to determine the earliest time at which all members are connected. (Every member is a friend of a friend of a friend .... of a friend). Assume that log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlogn or better and use extra space proportional to n

//Say we have 4 people (0,1,2,3) and these firendships began
// [[1,2,1], [0,1,2], [2,3,3]]
// Here [1,2,1] means at time 1 person 1 and 2 became friends.

/*Solution 
 * Unionf Find Structure to keep track of groups of connected peoplr.
 * Every time 2 people become friends, we merge their groups
 * If we end up with 1 group, then everyone is connected
*/

class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return  parent[x];
    }

    boolean union(int a, int b){
        int rootA = find(a), rootB = find(b);
        if(rootA == rootB) return false;

        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        } else if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        count --;
        return true;
    }

    boolean isAllConnected(){
        return count == 1;
    }
}

class SocialNetworkConnectivity {
    public static int earliestConnection(int n, List<LogEntry> logs) {
        UnionFind uf = new UnionFind(n);
        for (LogEntry log : logs) {
            uf.union(log.person1, log.person2);
            if (uf.isAllConnected() == 1) {
                return log.timestamp;
            }
        }
        return -1; 
    }
}

class LogEntry {
    int timestamp;
    int person1;
    int person2;
    public LogEntry(int timestamp, int p1, int p2) {
        this.timestamp = timestamp;
        this.person1 = p1;
        this.person2 = p2;
    }
}