package Graphs.BFS;
import java.util.*;
public class BFS {
       //TC =>O(V+E) SC => O(V)
        static void bfs(ArrayList<ArrayList<Integer>> adjList, int src){
                     int  n = adjList.size();
                     Queue<Integer> q = new LinkedList<>();
                     boolean[ ] visited = new boolean[ n];
                    int[ ] dist = new int[n];
                    int[ ] path = new int[n];
                     
                    q.add(src);
                    visited[src] =  true;
                    dist[src] = 0;
                    path[src] = -1;
    
                    while(!q.isEmpty()){
                     int curr = q.poll();
    
                     for(int next : adjList.get(curr)){
                         if(!visited[next]){
                            visited[next] = true;
                            dist[next] = dist[curr]+1;
                            path[next] = curr;
                            q.add(next); 
                           }
                     }
                   }         
    }
    
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            for(int i=0; i<=n; i++)adjList.add(new ArrayList<>());
    
            for(int i=0; i<m; i++){
              int  u = in.nextInt();
              int  v = in.nextInt();
              adjList.get(u).add(v);
              adjList.get(v).add(u);
             }
            bfs(adjList, 1);
        }
}
