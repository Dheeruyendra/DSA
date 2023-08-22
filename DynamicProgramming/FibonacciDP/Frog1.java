package DynamicProgramming.FibonacciDP;

import java.util.Scanner;
/*  Problem Link: https://atcoder.jp/contests/dp/tasks/dp_a
 */
//TC + SC =>O(N) 
class Frog1{
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] jumps = new int[n];
        for(int is=0; i<n; i++){
            jumps[i] = in.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(jumps[1]-jumps[0]);

        for(int i=2; i<n; i++){
            dp[i] = Math.min(Math.abs(jumps[i]-jumps[i-1])+dp[i-1], Math.abs(jumps[i]-jumps[i-2])+dp[i-2]);
        }

        System.out.println(dp[n-1]);
    }
}
