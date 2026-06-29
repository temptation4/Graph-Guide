package cycle;

import java.util.*;

public class UndirectedCycleDetection {

    // DFS function
    public static boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {

        // mark visited
        visited[node] = true;

        // traverse neighbors
        for (int nbr : adj.get(node)) {

            // if neighbor not visited
            if (!visited[nbr]) {

                if (dfs(nbr, node, adj, visited)) {

                    return true;
                }
            }

            /*
                visited neighbor
                not parent
                => cycle
            */
            else if (nbr != parent) {

                return true;
            }
        }

        return false;
    }

    public static boolean isCycle(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];

        // check all components
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, adj, visited)) {

                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        /*
            Graph:

            0 ----- 1
            |       |
            |       |
            2 ----- 3
        */

        // add edges both ways
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(2);
        adj.get(2).add(3);

        adj.get(2).add(0);
        adj.get(0).add(2);

        boolean ans = isCycle(V, adj);

        System.out.println("Cycle Exists = " + ans);
    }
}