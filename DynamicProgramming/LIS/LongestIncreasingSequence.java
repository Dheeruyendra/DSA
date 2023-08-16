class Solution {
     
    
    // prev = prevIndex prev = -1 shows we haven't choosen any element yet.
     int topDownDFS(int[] nums, int i, int prev, int[][] dp){
             if(i == nums.length)return 0;
             if(dp[i][prev+1] != -1)return dp[i][prev+1];
 
             int notTake = topDownDFS(nums, i+1, prev, dp);
             int take = 0;
             if(prev == -1 || nums[i] > nums[prev]){
                 take = 1 + topDownDFS(nums, i+1, i, dp);
             }
             return dp[i][prev+1] = Math.max(take, notTake);
     }
       public int lengthOfLIS(int[] nums) {
           int n =nums.length;
           int[][] dp = new int[n][n+1];
           for(int i=0; i<n; i++)Arrays.fill(dp[i], -1);
 
           return topDownDFS(nums, 0, -1, dp);
     }
     //TC =>O(N^2) 
     int bottomUp(int[] nums){
            int n = nums.length;
            int[] dp = new int[n];
 
            for(int i=0; i<n; i++){
                dp[i] = 1;
                for(int j=i-1; j>=0; j--){
                    if(nums[j] < nums[i]){
                        dp[i]  = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            int max = 0;
            for(int i=0; i<n; i++)max = Math.max(max, dp[i]);
            return max;
     }
   
 }