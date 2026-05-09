📘 Graph, BFS & DFS
📌 Overview
This repository explains core concepts of:


Graph Data Structure


Breadth-First Search (BFS)


Depth-First Search (DFS)



🧠 What is a Graph?
A Graph is a data structure used to represent relationships between different objects.


Vertex (Node) → Represents an entity


Edge → Connection between nodes


👉 Graph = Nodes + Connections

🌍 Real-Life Examples


Social Networks (friends, followers)


Google Maps (shortest path between locations)


Computer Networks (routers and connections)


Flight routes (cities connected by flights)



🔹 Types of Graphs
1. Directed vs Undirected


Undirected Graph → Connection works both ways (A — B)


Directed Graph → One-way connection (A → B)



2. Weighted vs Unweighted


Weighted Graph → Edges have cost (distance, time)


Unweighted Graph → All edges are equal



📊 Graph Representation
Adjacency List (Most Common)


Each node stores a list of its neighbors


Efficient for most problems


Space complexity: O(V + E)



🔁 Breadth-First Search (BFS)
🌊 Concept


Traverses graph level by level


Visits all neighbors before going deeper


Uses a Queue (FIFO)



🎯 Use Cases


Finding shortest path in unweighted graphs


Level-order traversal


Minimum steps problems



⚙️ Complexity


Time: O(V + E)


Space: O(V)



🌳 Depth-First Search (DFS)
🌿 Concept


Goes deep first, then backtracks


Explores one path completely before moving to another


Uses recursion or stack



🎯 Use Cases


Path finding


Cycle detection


Connected components



⚙️ Complexity


Time: O(V + E)


Space: O(V)



⚔️ BFS vs DFS
FeatureBFSDFSTraversalLevel-wiseDepth-wiseData StructureQueueStack/RecursionBest ForShortest pathDeep explorationBehaviorExpands like a waveGoes deep then backtracks

🎯 Key Concepts


Always track visited nodes to avoid infinite loops


BFS guarantees shortest path in unweighted graphs


DFS is useful for exploring all possible paths



🚀 Summary
👉
Graphs are powerful for modeling relationships, and BFS & DFS are the main techniques to traverse them efficiently.

⭐ Author
Neelu Sahai


