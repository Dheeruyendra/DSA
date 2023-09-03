package Graphs.BFS;
import java.util.*;
public class PrisonBreak {
    static int max_value = Integer.MAX_VALUE-1;
    static class Pair{
       int r, c;
       Pair(int row, int col){
         r = row;
         c = col;
       }
    }
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int m = in.nextInt();
       in.nextLine();
       
       char[][] grid = new char[n][m];
       int[][] dist =  new int[n][m];
       Deque<Pair> q = new LinkedList<>();
       int ai = 0;
       int aj = 0;
        
       for(int i=0; i<n; i++){
          String s = in.next();
          
          for(int j=0; j<m; j++){
             char c = s.charAt(j);
             dist[i][j] = max_value;
             grid[i][j] = c;
             
              if(c == 'A'){
                if(i == 0 || j == 0 || j == m-1 || i == n-1){
                  System.out.println("YES");
                  return;
                }
                ai = i;
                aj = j;
             }
             else if(c == 'M'){
                dist[i][j] = 0;
                q.add(new Pair(i, j));
             }
          }
       }   
       in.close();
       multiSourceBFS(grid, dist, q);
       q.add(new Pair(ai, aj));
       dist[ai][aj] = 0;
       
       if(singleSourceBFS(grid, dist, q)) System.out.println("YES");
       else System.out.println("NO");
  }
 static void multiSourceBFS(char[][] grid, int[][] dist, Deque<Pair>q){
         int row = grid.length, col = grid[0].length;
          while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0; i<4; i++){
               int nr = curr.r + dr[i];
               int nc = curr.c + dc[i];
               
               if(isValid(nr, nc, row, col) && grid[nr][nc] != '#'){
                  if(dist[curr.r][curr.c]+1 < dist[nr][nc]){
                     dist[nr][nc] = dist[curr.r][curr.c]+1;
                     
                     q.add(new Pair(nr, nc));
                  }
               }
            }
          }
}
 static boolean singleSourceBFS(char[][] grid, int[][] dist, Deque<Pair> q){
           int row = grid.length, col = grid[0].length;
           while(!q.isEmpty()){
             Pair curr = q.poll();
             for(int i=0; i<4; i++){
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                
                if(isValid(nr, nc, row, col) && grid[nr][nc] == '.'){
                     if(dist[curr.r][curr.c] +1 < dist[nr][nc]){
                       dist[nr][nc] = dist[curr.r][curr.c] + 1;
                       if(nr == 0 || nr == row-1 || nc == 0 || nc == col-1)return true;
                       q.add(new Pair(nr, nc));
                     }
                }
             }
           }
           return false;
}
static boolean isValid(int nr, int nc, int row, int col){
    if(nr < 0 || nr >= row || nc < 0 || nc >= col)return false;
        return true;
  }
}