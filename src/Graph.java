import java.util.*;

public class Graph {

    private int V;
    private List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Print graph
    public void printGraph() {
        for (int i = 1; i < V; i++) {
            System.out.print(i + " -> ");
            for (int nbr : adj.get(i)) {
                System.out.print(nbr + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(7); // nodes 1 to 6

        // STEP 1: Build tree-like structure
        g.addEdge(1, 2); // node 2 to node 1
        g.addEdge(1, 3); // node 3 to node 1
        g.addEdge(3, 4); // node 4 to node 3
        g.addEdge(2, 5); // node 5 to node 2
        g.addEdge(1, 6); // node 6 to node 1

        // STEP 2: Add extra edges (make graph complex)
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(3, 6);

        System.out.println("Graph (Adjacency List):");
        g.printGraph();
    }
}