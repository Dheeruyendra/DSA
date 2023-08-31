//package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
          
         Set<Integer> unique = new HashSet<>();
         for(int num : numbers)unique.add(num);
         System.out.println(unique.size());
     }
}
