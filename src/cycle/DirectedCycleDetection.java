package cycle;

import java.util.*;

/*
Problem:
Detect Cycle in a Directed Graph

Approach:
- Use Depth First Search (DFS).
- Maintain two boolean arrays:
  1. visited[]     -> Tracks all visited nodes.
  2. pathVisited[] -> Tracks nodes in the current DFS recursion path.
- If a node is encountered that is already present in the current recursion path,
  a back edge exists, which means the graph contains a cycle.

Time Complexity:
O(V + E)

Space Complexity:
O(V)
*/

public class DirectedCycleDetection {

    // DFS function
    public static boolean dfs(
            int node,
            List<List<Integer>> adj,
            boolean[] visited,
            boolean[] pathVisited) {

        // mark visited
        visited[node] = true;

        // mark current path
        pathVisited[node] = true;

        // traverse neighbors
        for (int nbr : adj.get(node)) {

            // if not visited
            if (!visited[nbr]) {

                if (dfs(
                        nbr,
                        adj,
                        visited,
                        pathVisited)) {

                    return true;
                }
            }

            /*
                if already in current path
                cycle exists
            */
            else if (pathVisited[nbr]) {

                return true;
            }
        }

        /*
            remove from current path
            while backtracking
        */
        pathVisited[node] = false;

        return false;
    }

    public static boolean isCycle(
            int V,
            List<List<Integer>> adj) {

        boolean[] visited =
                new boolean[V];

        boolean[] pathVisited =
                new boolean[V];

        // check every node
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(
                        i,
                        adj,
                        visited,
                        pathVisited)) {

                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        List<List<Integer>> adj =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        /*
            Graph:

            0 → 1
            1 → 2
            2 → 0
            2 → 3
        */

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        boolean ans =
                isCycle(V, adj);

        System.out.println(
                "Cycle Exists = " + ans
        );
    }
}