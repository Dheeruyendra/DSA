package Graphs.DFS;

import java.util.Scanner;

public class GridDFS {

   static int[] dx = {-1, 1, 0, 0};
   static int[] dy = {0, 0, 1, -1,};
   //TC =>O(N*M) SC =>O(N*M)
   static void gridDFS(int[][] grid,boolean[][] visited, int i, int j){
              visited[i][j] = true;
               for(int k=0; k<4; k++){
                  int nx  = i + dx[ k ];
                  int  ny = j + dy[ k ];
                  if(isValid(nx, ny, grid) && !visited[nx][ny]){
                      gridDFS(grid, visited, nx, ny);
                  }
               }
   }
   static boolean isValid(int i, int j, int[][] grid){
       int n = grid.length;
       int m = grid[0].length;
       return i>=0 && i<n && j>=0 && j<m;
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
               boolean[][] visited = new boolean[n][m];
               gridDFS(grid, visited, 0, 0);

   }   
}
