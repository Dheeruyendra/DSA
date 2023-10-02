package Sorting;
import java.util.Scanner;
public class QuickSort {
    //TC =>O(NlogN)||O(N^2) SC =>O(1){unstable sorting alogrithm}
    static void swap(int[] arr, int i, int j){
           int temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
    }
    static int partition(int[] arr, int l, int r){
           int pivot = arr[r];
           int left = l;
           for(int k=l; k<r; k++){
             if(arr[k] < pivot){
                swap(arr, k, left);
                left+=1;
             }
           }
           swap(arr, left, r);
           return left;
    }
    static void quickSort(int[] arr, int l, int r){
           if(l >= r)return;
           int index = partition(arr, l, r);
           quickSort(arr, l, index-1);
           quickSort(arr, index+1, r);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = in.nextInt();
        quickSort(arr, 0, n-1);
        for(int i=0; i<n; i++)System.out.print(arr[i]+" ");
    }
}
