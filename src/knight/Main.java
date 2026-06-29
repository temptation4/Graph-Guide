package knight;

import java.util.*;

public class Main {

    // Helper class to store:
    // x = row, y = column, steps = number of moves taken so far
    static class Cell {
        int x, y, steps;

        Cell(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    // Function to find minimum steps for knight to reach target
    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {

        // All 8 possible moves of a knight (L-shape moves)
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        // Visited array to avoid visiting same cell again
        boolean[][] visited = new boolean[N + 1][N + 1];

        // Queue for BFS traversal
        Queue<Cell> queue = new LinkedList<>();

        // Add starting position into queue with 0 steps
        queue.offer(new Cell(KnightPos[0], KnightPos[1], 0));

        // Mark starting position as visited
        visited[KnightPos[0]][KnightPos[1]] = true;

        // BFS loop (runs until queue becomes empty)
        while (!queue.isEmpty()) {


            // Remove front element from queue
            Cell curr = queue.poll();

            // If current position is target, return steps
            if (curr.x == TargetPos[0] && curr.y == TargetPos[1]) {
                return curr.steps;
            }

            // Try all 8 possible knight moves
            for (int i = 0; i < 8; i++) {

                // Calculate new position
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];

                // Check if new position is inside board
                // and not visited before
                if (isSafe(newX, newY, N) && !visited[newX][newY]) {

                    // Mark new position as visited
                    visited[newX][newY] = true;

                    // Add new position to queue with steps + 1
                    queue.offer(new Cell(newX, newY, curr.steps + 1));
                }
            }
        }

        // If target cannot be reached (rare case)
        return -1;
    }

    // Function to check if position is inside chessboard
    private static boolean isSafe(int x, int y, int N) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    // MAIN METHOD (entry point of program)
    public static void main(String[] args) {

        int N = 8; // Chessboard size (8x8)

        // Starting position of knight
        int[] knightPos = {1, 1};

        // Target position
        int[] targetPos = {4, 5};

        // Call function
        int result = minStepToReachTarget(knightPos, targetPos, N);

        // Print result
        System.out.println("Minimum steps = " + result);
    }
}
