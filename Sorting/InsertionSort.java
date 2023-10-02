package Sorting;

import java.util.Scanner;

public class InsertionSort {

    static void insertionSort(int[] arr){
           int i = 1;
           int n = arr.length;
           while(i < n){
              int key = arr[i];
              int j = i-1;
              while(j >= 0 && arr[j] > key){
                    arr[j+1] = arr[j];
                    j--;
                }
               arr[j+1] = key; 
           }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = in.nextInt();
        insertionSort(arr);
        for(int i=0; i<n; i++)System.out.print(arr[i]+" ");
    }
}
