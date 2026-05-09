import java.util.*;

public class BFSExample {

    private int V;
    private List<List<Integer>> adj;

    public BFSExample(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Directed graph (as per image)
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    // BFS traversal
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        BFSExample g = new BFSExample(9);

        // Graph from image
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);

        g.addEdge(1, 4);
        g.addEdge(2, 4);

        g.addEdge(3, 6);

        g.addEdge(4, 5);
        g.addEdge(4, 7);

        g.addEdge(5, 8);
        g.addEdge(6, 8);

        System.out.println("BFS Traversal:");
        g.bfs(0);
    }
}