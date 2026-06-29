package ReorderRouter;
import java.util.*;

class Solution {
    public static int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(-u);

        }
        boolean vis[]=new boolean[n];
        int cnt=0;
        Queue<Integer> qu=new LinkedList<>();
        qu.add(0);
        vis[0]=true;
        while(!qu.isEmpty()){
            int curr=qu.poll();
            for(int it:adj.get(Math.abs(curr))){
                if(!vis[Math.abs(it)]){
                    qu.add(it);
                    vis[Math.abs(it)]=true;
                    if(it>0)
                        cnt++;
                }
            }
        }
        return cnt;
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
