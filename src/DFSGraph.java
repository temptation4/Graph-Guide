import java.util.*;

public class DFSGraph {

    private int V;
    private List<List<Integer>> adj;

    public DFSGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Undirected graph
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // DFS
    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        dfsUtil(start, visited);
    }

    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                dfsUtil(nbr, visited);
            }
        }
    }

    public static void main(String[] args) {

        DFSGraph g = new DFSGraph(11);

        // Left side
        g.addEdge(0, 1);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);

        // Right side
        g.addEdge(0, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 9);
        g.addEdge(3, 10);

        System.out.println("DFS Traversal:");
        g.dfs(0);
    }
}