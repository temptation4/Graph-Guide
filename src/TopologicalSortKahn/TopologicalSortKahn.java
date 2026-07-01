package TopologicalSortKahn;

import java.util.*;

/*
Problem:
Topological Sort using Kahn's Algorithm (BFS)

Definition:
Topological sorting is a linear ordering of vertices such that
for every directed edge U → V, vertex U appears before V.

Note:
Topological Sort is possible only for Directed Acyclic Graphs (DAG).

Approach:
1. Calculate indegree of every vertex.
2. Insert all vertices having indegree 0 into a queue.
3. Remove a vertex from the queue.
4. Add it to the result.
5. Decrease indegree of its neighbours.
6. If any neighbour's indegree becomes 0, push it into the queue.
7. Continue until the queue becomes empty.

Time Complexity:
O(V + E)

Space Complexity:
O(V)
*/

public class TopologicalSortKahn {

    // Performs Topological Sort using Kahn's Algorithm (BFS)
    public static List<Integer> topologicalSort(int V,
                                                List<List<Integer>> adj) {

        // Stores the indegree of every vertex
        int[] indegree = new int[V];

        // Calculate indegree of each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        // Queue to store vertices having indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        // Process vertices in BFS order
        while (!queue.isEmpty()) {

            int node = queue.poll();
            topoOrder.add(node);

            // Reduce indegree of adjacent vertices
            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                // Add neighbour when indegree becomes 0
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return topoOrder;
    }

    public static void main(String[] args) {

        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed Acyclic Graph (DAG)
        //
        // 5 → 2 → 3 → 1
        // ↓         ↑
        // 0 → 4 ----|
        //

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> result = topologicalSort(V, adj);

        System.out.println("Topological Order:");
        System.out.println(result);
    }
}