                                                                         
A **graph** is a non-linear data structure used to represent relationships between different objects.  
Each object is called a vertex (node)  
The connection between two nodes is called an edge  
<img width="1412" height="850" alt="dc0ea33e-e8f3-4886-a36a-7bd2ae2131b7" src="https://github.com/user-attachments/assets/e98100e7-f17c-443e-91af-e0a8a741a3e2" />



👉 In simple words:  
**Graph = Nodes + Connections**

Circles → Vertices (Nodes)  
Lines → Edges (Connections)  

## 🔁 Graph Traversal

### 🌳 Breadth-First Search (BFS)

```java
boolean[] visited = new boolean[V];
Queue<Integer> q = new LinkedList<>();

q.offer(start);
visited[start] = true;

while (!q.isEmpty()) {
    int node = q.poll();

    for (int nei : adj.get(node)) {
        if (!visited[nei]) {
            visited[nei] = true;
            q.offer(nei);
        }
    }
}
```

![BFS Traversal](https://upload.wikimedia.org/wikipedia/commons/4/46/Animated_BFS.gif)

👉 Explores nodes **level by level**  
👉 Uses **Queue (FIFO)**  
👉 Best for **shortest path (unweighted graph)**  

---

### 🌳 Depth-First Search (DFS)

```java
void dfs(int node, boolean[] visited) {
    visited[node] = true;

    for (int nei : adj.get(node)) {
        if (!visited[nei]) {
            dfs(nei, visited);
        }
    }
}
```

![DFS Traversal](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)

👉 Goes **deep first, then backtracks**  
👉 Uses **Stack / Recursion**  
👉 Useful for **cycle detection, path finding**  

## 🧱 Graph Building (Step-by-Step)

Below image shows how a graph is built step-by-step using edges.
<img width="1412" height="762" alt="547605e8-4ed5-4237-ad65-4dfb251d7d2d" src="https://github.com/user-attachments/assets/8c1f232d-e677-4ebb-aac9-1729e8d5d6cb" />



🔹 Step 1: Start with single node  
Only node 1 exists  
No connections  

Add node 2 → connect to 1  
Add node 3 → connect to 1  
Add node 4 → connect to 3  
Add node 5 → connect to 2  
Add node 6 → connect to 1  

💻 **Java Code for creating Graph**
```java
import java.util.*;

public class Graph {

    private int V;
    private List<List<Integer>> adj;

    // Constructor
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

    // Print graph (Adjacency List)
    public void printGraph() {
        for (int i = 1; i < V; i++) {
            System.out.print(i + " -> ");
            for (int nbr : adj.get(i)) {
                System.out.print(nbr + " ");
            }
            System.out.println();
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Graph g = new Graph(7); // nodes 1 to 6

        // STEP 1: Build tree-like structure
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 5);
        g.addEdge(1, 6);

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
```

---

## 👤 Example

A = Person  
B = Person  
Edge = Friendship  

---

## 🔗 Real-Life Examples of Graphs  

<img width="1024" src="https://github.com/user-attachments/assets/fc043294-d8c2-49ec-b4da-377e23782a85" />

<img width="1394" src="https://github.com/user-attachments/assets/5e510bd1-ae20-4255-9e59-6f597e6a0627" />

👉 Real-world graphs represent:
- Social networks  
- Maps & navigation  
- Computer networks  
- Flight routes  

---

## 📌 Types of Graphs  

### 1. Directed vs Undirected Graph

<img width="2048" height="1251" alt="4e25c5fd-0e92-46d0-80a3-f86d726a0a37" src="https://github.com/user-attachments/assets/233c44a9-f54d-48f1-b52d-a0637caafef9" />


🔹 **Undirected Graph**  
Edges have no direction → A — B  

🔹 **Directed Graph**  
Edges have direction → A → B  

---

### 2. Weighted vs Unweighted Graph

<img width="2047" height="1270" alt="ab55c158-f77e-4310-8609-43725aabfcea" src="https://github.com/user-attachments/assets/520a58cc-38f9-4d53-a939-94157bffe46b" />


🔹 Weighted → edges have cost (distance/time)  
🔹 Unweighted → all edges equal  

---

### 3. Cyclic vs Acyclic Graph

<img width="1248" src="https://github.com/user-attachments/assets/3fc1edcf-5238-4113-97f5-83e289ea9acf" />

🔹 Cyclic → contains loop  
🔹 Acyclic → no loop  

---

## 📊 Graph Representation (VERY IMPORTANT)

### 1. Adjacency Matrix  

<img width="1368" src="https://github.com/user-attachments/assets/50459396-82b9-4bc3-ac12-fe950ff5aeac" />

👉 2D array representation  
👉 `1` → edge exists  
👉 `0` → no edge  

---

### 2. Adjacency List (Most Used)  

<img width="1446" src="https://github.com/user-attachments/assets/abefd05a-1c8e-4efc-8dde-5f8b9a04ef5f" />

👉 Stores neighbors of each node  
👉 More **memory efficient** than matrix  


---

## ⚡ Quick Summary

- Graph = Nodes + Edges  
- BFS → Level-wise traversal  
- DFS → Depth-first traversal  
- Adjacency List → Most efficient representation  

---

## 🎯 Why Graphs Matter

Graphs are heavily used in:
- System design  
- Routing algorithms  
- Social media platforms  
- Real-time applications  

---

## 👨‍💻 Author

Neelu Sahai



