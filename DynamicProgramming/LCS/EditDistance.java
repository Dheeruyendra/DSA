package DynamicProgramming.LCS;
class Solution {
/*     https://leetcode.com/problems/edit-distance/
   
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
            horse -> rorse (replace 'h' with 'r')
            rorse -> rose (remove 'r')
            rose -> ros (remove 'e')
 */   
     //TC =>O(N*M) SC =>O(N*M)
    int topDown(int i, String st1, String st2, int j){ // state
        //base case
        if(i == 0)return j;
        if(j == 0)return i;
        if(dp[i][j] != -1)return dp[i][j];

        //transition
        if(st1.charAt(i-1) == st2.charAt(j-1))return dp[i][j] = topDown(i-1, st1, st2, j-1);
        else{
            int insert = topDown(i, st1, st2, j-1) + 1;
            int delete = topDown(i-1, st1, st2, j) + 1;
            int replace = topDown(i-1, st1, st2, j-1) + 1;

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
    
    int bottomUp(String word1, String word2){
           int n1 = word1.length(), n2 = word2.length();
           // state
           dp = new int[n1+1][n2+1];

           //base case
           for(int i=0; i<=n1; i++)dp[i][0] = i;
           for(int j=0; j<=n2; j++)dp[0][j] = j;

           //transition
           for(int i=1; i<=n1; i++){
               for(int j=1; j<=n2; j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    else{
                       int insert = dp[i][j-1] + 1;
                       int delete = dp[i-1][j] + 1;
                       int replace = dp[i-1][j-1] + 1;

                       dp[i][j] = Math.min(insert, Math.min(delete, replace));
                    }
               }
           }

           return dp[n1][n2];
    }
    int[][] dp;
    public int minDistance(String word1, String word2) {
        return bottomUp(word1, word2);

/* Top-Down  
           for(int i=0; i<=n1; i++)Arrays.fill(dp[i], -1);
           return topDown(n1, word1, word2, n2);
*/  
    }
}
