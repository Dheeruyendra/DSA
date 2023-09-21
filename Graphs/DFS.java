package Graphs.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {

    static void dfs(int curr, boolean[]visited, ArrayList<ArrayList<Integer>> adjList){
                   visited[curr] = true;

                   for(int next : adjList.get(curr)){
                        if(!visited[next])
                            dfs(next, visited, adjList);
                   }
    }
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt(); 
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();  
            for(int i = 0; i < n; i++){
                adjList.add(new ArrayList<>());    
            }        
            for(int i = 0; i < m; i++){ 
                int u = sc.nextInt();
                int v = sc.nextInt();
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }       
            boolean[] visited = new boolean[n];
            dfs(0, visited, adjList);

    } 
}
