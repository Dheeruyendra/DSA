package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
    //TC => O(V+E) SC => O(V)
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       int n = adj.size();
       int[] res = new int[n];
       int k = 0;
       
       Queue<Integer> q = new LinkedList<>();
       int[] indegree = new int[n];
       for(ArrayList<Integer> edges : adj){
            for(int node : edges){
                indegree[node]+=1;
            }
       }
       
       for(int i=0; i<n; i++){
           if(indegree[i] == 0)q.add(i);
       }
       
       while(!q.isEmpty()){
           int curr = q.poll();
           res[k++] = curr;
           
           for(int next : adj.get(curr)){
               indegree[next] -=1;
               if(indegree[next] == 0)q.add(next);
           }
       }
       return res;
    }
}
