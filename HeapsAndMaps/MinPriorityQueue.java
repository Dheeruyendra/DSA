import java.util.*;
class MinPriorityQueue {
	/*
	  TC => peek() => O(1)
	        add() =>O(logN)
			remove =>O(logN)
	*/
	
	static class PriorityQueue{
    ArrayList<Integer> data;
	public PriorityQueue(){
		data = new ArrayList<>();
	}
		//O(N) constructor to make heap
	public PriorityQueue(int[] arr){
		data = new ArrayList<>();
		for(int val : arr){
			data.add(val);
		}	
			
		for(int i = (data.size()/2)-1; i>=0; i--)heapifyDown(i);
		}
	 
	 //add
	 public void add(int val){
		 data.add(val);
		 heapifyUP(size()-1);
	 }
	 private void heapifyUP(int index){
		 if(index == 0)return;
		 
		 int pi = (index-1)/2;
		 if(data.get(pi) > data.get(index)){
			 swap(index, pi);
			 heapifyUP(pi);
		 }
	 }
	 
	 private void swap(int i, int j){
		 int ith = data.get(i);
		 int jth = data.get(j);
		 
		 data.set(i, jth);
		 data.set(j, ith);
	 }
	 
	 //remove
	 public int remove(){
		 if(size() == 0)return -1;
		 //swap root and last
		  swap(0, data.size()-1);
		  int val = data.remove(data.size()-1);
		 
		 heapifyDown(0);
		 return val;
	 }
	 
	 private void heapifyDown(int pi){
		   int mini = pi;
		   
		   //left child
		   int li = 2*pi+1;
		   if(li < data.size() && data.get(li) < data.get(mini)){
			   mini = li;
	   }
		
		   //right child
		   int ri = 2*pi+2;
		   if(ri < data.size() && data.get(ri) < data.get(mini)){
			   mini = ri;
		   }
		   
		   if(mini != pi){
			   swap(mini, pi);
			   heapifyDown(mini);
		   }   
		   
	 }
	 
	 //peek
	 public int peek(){
		 if(size() != 0)return data.get(0);
		 return -1;
	 }
	 //size
	 public int size(){
		 return data.size();
	 }
	
	}
	public static void main(String args[]) {
         PriorityQueue pq = new PriorityQueue();
		 pq.add(5);
		 pq.add(1);
		 System.out.println(pq.peek());
		 pq.remove();
		System.out.println(pq.peek());
	}
}