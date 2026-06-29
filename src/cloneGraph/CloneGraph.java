package cloneGraph;

import java.util.*;

public class CloneGraph {

    static class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    // Original Node -> Cloned Node
    private static Map<Node, Node> map = new HashMap<>();

    public static Node cloneGraph(Node node) {

        // Empty graph
        if (node == null) {
            return null;
        }

        // Already cloned
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create clone node
        Node clone = new Node(node.val);

        // Store mapping
        map.put(node, clone);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {

            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    // DFS print graph
    public static void printGraph(Node node, Set<Integer> visited) {

        if (node == null || visited.contains(node.val)) {

            return;
        }

        visited.add(node.val);

        System.out.print("Node " + node.val + " -> ");

        for (Node neighbor : node.neighbors) {

            System.out.print(neighbor.val + " ");
        }

        System.out.println();

        for (Node neighbor : node.neighbors) {

            printGraph(neighbor, visited);
        }
    }

    public static void main(String[] args) {

        /*
              1 ----- 2
              |       |
              |       |
              4 ----- 3
         */

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Create graph
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println("Original Graph:");

        printGraph(node1, new HashSet<>());

        Node clonedGraph = cloneGraph(node1);

        System.out.println("\nCloned Graph:");

        printGraph(clonedGraph, new HashSet<>());
    }
}
