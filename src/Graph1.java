import java.util.*;

public class Graph1 {

    private int V;
    private List<List<Integer>> adj;

    public Graph1(int V) {
        this.V = V;
        adj = new ArrayList<>();

        // Initial empty graph
        /*
            0

            1

            2

            3

            (No edges yet)
        */

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // ========================
    // ADD EDGE WITH GRAPH BUILD
    // ========================
    public void addEdge(int u, int v) {

        adj.get(u).add(v);
        adj.get(v).add(u); // undirected

        /*
        =====================================
        GRAPH BUILDING STEP BY STEP
        =====================================

        👉 After addEdge(0,1)

            0 --- 1

            2

            3


        👉 After addEdge(1,2)

            0 --- 1 --- 2

            3


        👉 After addEdge(2,0)

            0 --- 1
             \   /
               2

            3

        (Cycle formed: 0 → 1 → 2 → 0)


        👉 After addEdge(1,3)

            0 --- 1 --- 3
             \   /
               2

        FINAL GRAPH
        =====================================
        */
    }

    // ========================
    // PRINT GRAPH
    // ========================
    public void printGraph() {
        /*
         Adjacency List representation:

         0 -> [1,2]
         1 -> [0,2,3]
         2 -> [1,0]
         3 -> [1]
        */

        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int nbr : adj.get(i)) {
                System.out.print(nbr + " ");
            }
            System.out.println();
        }
    }

    // ========================
    // BFS
    // ========================
    public void bfs() {
        boolean[] visited = new boolean[V];

        /*
         BFS VISUAL FLOW:

         Start from 0

         Step 1:
            Queue = [0]

         Step 2:
            Visit 0 → add (1,2)
            Queue = [1,2]

         Step 3:
            Visit 1 → add (3)
            Queue = [2,3]

         Step 4:
            Visit 2 → already visited nodes
            Queue = [3]

         Step 5:
            Visit 3 → done

         OUTPUT: 0 1 2 3
        */

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                visited[i] = true;
                q.offer(i);

                while (!q.isEmpty()) {
                    int node = q.poll();
                    System.out.print(node + " ");

                    for (int nbr : adj.get(node)) {
                        if (!visited[nbr]) {
                            visited[nbr] = true;
                            q.offer(nbr);
                        }
                    }
                }
            }
        }
    }

    // ========================
    // DFS
    // ========================
    public void dfs() {
        boolean[] visited = new boolean[V];

        /*
         DFS VISUAL FLOW:

         Start from 0

         Path:
            0 → 1 → 2 → back → 3

         OUTPUT: 0 1 2 3
        */

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited);
            }
        }
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

    // ========================
    // CYCLE DETECTION
    // ========================
    public boolean hasCycle() {
        boolean[] visited = new boolean[V];

        /*
         Cycle exists because:

            0 → 1 → 2 → 0

         This loop is detected using parent tracking
        */

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycle(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCycle(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                if (dfsCycle(nbr, visited, node)) {
                    return true;
                }
            } else if (nbr != parent) {
                return true;
            }
        }
        return false;
    }

    // ========================
    // MAIN
    // ========================
    public static void main(String[] args) {

        Graph1 g = new Graph1(4);

        // BUILD GRAPH
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // cycle
        g.addEdge(1, 3);

        System.out.println("Graph:");
        g.printGraph();

        System.out.println("\nBFS:");
        g.bfs();

        System.out.println("\nDFS:");
        g.dfs();

        System.out.println("\nCycle Present? " + g.hasCycle());
    }
}