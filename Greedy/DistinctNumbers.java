package Greedy;
//Problem Link: https://cses.fi/problemset/task/1621

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctNumbers {
         public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String arr = br.readLine();

        int  size = Integer.parseInt(n);
        String[] nums = arr.split("\\s+");
 
        int[] numbers = new int[size];
        for(int i=0; i<size; i++){
            numbers[i] = Integer.parseInt(nums[i]);
         }
         
         int res1 = usingSet(numbers);  //Result: Accepted
        // int res2 = usingSorting(numbers); Result: TLE 
         System.out.println(res1);

     }
     //TC =>O(N) SC =>O(N)
     static int usingSet(int[] nums){
         Set<Integer> unique = new HashSet<>();
         for(int num : nums)unique.add(num);
         return unique.size();
     }
    //TC =>O(NlogN) SC =>(1) 
    //TLE on CSES Judge
     static int usingSorting(int[] nums){
        Arrays.sort(nums);
        int count = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i] != nums[i-1])count+=1;
        }
        return count;
     }
}
