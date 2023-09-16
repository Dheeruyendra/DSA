package Graphs.BFS;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class GridBFS {
      static class Pair{
        int x, y;
        Pair(int x, int y){
           this.x = x;
           this.y = y;
        }
      }
      static int[] dx = {-1, 1, 0, 0};
      static int[] dy = {0, 0, -1, 1};

      //TC =>O(N*M) SC =>O(N*M)
      static void gridBFS(int[ ][ ] grid, int i, int j){
          int  n  = grid.length;
          Queue<Pair> q = new LinkedList<>();
          Set<Pair> visited = new HashSet<>(); // or boolean 2d array 
          Pair src = new Pair(i, j);
          q.add(src);
          visited.add(src); 
         
         while(!q.isEmpty()){
             Pair curr = q.poll();
    
             for(int k=0; k<4; k++){
               int nx  = curr.x + dx[ k ];
              int  ny = curr.y + dy[ k ];
    
              Pair next = new Pair(nx, ny);
              if(!visited.contains( next)){
                 visited.add(next);
                 q.add(next);
               } 
            } 
         }      
    }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] grid = new int[n][m];
            for(int i=0; i<n; i++){
              for(int j=0; j<m; j++){
                grid[i][j] = in.nextInt();
              }
            }
            gridBFS(grid, 0, 0);
        }
}
    
