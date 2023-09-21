package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalSortDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {   int n = adj.size();
        boolean[] visited = new boolean[n];
        List<Integer> res = new ArrayList<>();   
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i, visited, res, adj);
            }
        }
        Collections.reverse(res);
        int[] ans = new int[n];
        for(int i=0; i<n; i++)ans[i] = res.get(i);
        return ans;
    }
    
    static void dfs(int curr, boolean[]visited, List<Integer>res, ArrayList<ArrayList<Integer>> adj)
    {
                 visited[curr] = true;
                 for(int next : adj.get(curr)){
                     if(!visited[next]){
                         dfs(next, visited, res, adj);
                     }
                 }
                 res.add(curr);
    }
}
