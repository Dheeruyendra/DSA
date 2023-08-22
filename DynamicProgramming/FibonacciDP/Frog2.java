package DynamicProgramming.FibonacciDP;

import java.util.*;
/*  Problem LinK: https://atcoder.jp/contests/dp/tasks/dp_b
 */
//TC =>O(N*k) SC =>O(N)
class Frog2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = in.nextInt();
		}
		
		int[] dp = new int[n];
		dp[0] = 0;
		for(int j=1; j<n; j++){
			int min = Integer.MAX_VALUE;
			int i = j-1;
			while(i >= 0  && j-i <= k){
				min = Math.min(Math.abs(arr[j] - arr[i]) + dp[i], min);
				i-=1;
			}
			dp[j] = min;
		}
		 System.out.println(dp[n-1]);
	}
}
