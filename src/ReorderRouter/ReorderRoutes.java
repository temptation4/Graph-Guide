package ReorderRouter;

import java.util.*;

/*
    LeetCode 1466
    Reorder Routes to Make All Paths Lead to the City Zero

    -----------------------------------------------------

    PROBLEM:

    We have:
    - n cities
    - directed roads

    Example:
        0 -> 1
        1 -> 3
        2 -> 3
        4 -> 0
        4 -> 5

    Goal:
    Every city should be able to reach city 0.

    If road direction is wrong,
    we reverse that road.

    We need MINIMUM reversals.

    -----------------------------------------------------

    IDEA:

    Start DFS from city 0.

    If edge direction goes AWAY from 0,
    then it needs reversal.

    -----------------------------------------------------

    TRICK:

    Original edge:
        u -> v

    Store:
        (v,1)  => original direction
                  may need reversal

        (u,0)  => reverse direction
                  already correct

    -----------------------------------------------------
*/

public class ReorderRoutes {

    // store total reversals needed
    static int changes = 0;

    /*
        Function:
        Find minimum reversals
    */
    public static int minReorder(
            int n,
            int[][] connections) {

        /*
            Adjacency List

            Each node stores:
            [neighbor, needsReorder]

            Example:
            [1,1]
            means:
            go to city 1
            and this edge needs reversal
        */
        List<List<int[]>> adj =
                new ArrayList<>();

        // create empty list for every city
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        /*
            Build Graph

            Example edge:
                0 -> 1

            Store:
                0 : (1,1)
                1 : (0,0)

            Why?

            (1,1)
            means:
            original edge direction
            wrong for reaching 0

            (0,0)
            means:
            reverse direction already good
        */

        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            // original edge
            // this direction may need reversal
            adj.get(u).add(
                    new int[]{v, 1});

            // reverse edge
            // already correct direction
            adj.get(v).add(
                    new int[]{u, 0});
        }

        // visited array
        // avoids infinite loops
        boolean[] visited =
                new boolean[n];

        /*
            Start DFS from city 0

            We try to bring
            all paths toward 0
        */
        dfs(0, adj, visited);

        return changes;
    }

    /*
        DFS Traversal
    */
    public static void dfs(
            int node,
            List<List<int[]>> adj,
            boolean[] visited) {

        // mark current city visited
        visited[node] = true;

        /*
            Explore neighbors
        */
        for (int[] nbr : adj.get(node)) {

            // neighbor city
            int nextNode = nbr[0];

            /*
                1 => edge needs reversal
                0 => already correct
            */
            int needsReorder = nbr[1];

            // avoid revisiting
            if (!visited[nextNode]) {

                /*
                    If edge direction is wrong,
                    increase reversal count
                */
                changes += needsReorder;

                // continue DFS
                dfs(nextNode, adj, visited);
            }
        }
    }

    public static void main(String[] args) {

        int n = 6;

        /*
            connections[i] = {u,v}

            means:
            u -> v
        */

        int[][] connections = {

                {0,1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
        };

        int ans =
                minReorder(
                        n,
                        connections
                );

        System.out.println(
                "Minimum Reorders = "
                        + ans
        );
    }
}
