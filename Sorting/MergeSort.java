package Sorting;
import java.util.Scanner;
public class MergeSort {
       //TC =>O(NlogN) SC =>O(N){stable sorting alogrithm}
        static void merge(int[] arr, int l, int mid, int r){
               int n1 = mid-l+1;
               int n2 = r-mid;
               int[] left = new int[n1];
               int[] right = new int[n2];
               int i=0, j=0;
               for(int k=l; k<=mid; k++){
                  left[i++] = arr[k];
               }
               for(int k=mid+1; k<=r; k++){
                  right[j++] = arr[k];
               }
               i = j = 0;
               int k = l;
               while (i < n1 && j < n2) {
                   if(left[i] <= right[j]){
                    arr[k] = left[i];
                    i+=1;
                   }
                   else{
                    arr[k] = right[j];
                    j+=1;
                   }
                   k+=1;
               }
               while(i < n1)arr[k++] = left[i++];
               while (j < n2)arr[k++] = right[j++]; 
        }

        static void mergeSort(int[] arr, int l, int r){
             if(l >= r)return;

                int mid = l+(r-l)/2;
                mergeSort(arr, l, mid);
                mergeSort(arr, mid+1, r);
                merge(arr, l, mid, r);
        }    
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = in.nextInt();
        mergeSort(arr, 0, n-1);
        for(int i=0; i<n; i++)System.out.print(arr[i]+" ");
    }
}
