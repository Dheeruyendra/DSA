package HeapsAndMaps;
import java.util.*;
import java.io.*;

public class Hashmap_implementation {
class HashMap<K, V>{
	
		private class HMNode{
			K key;
            V value;
			HMNode(K key, V value){
				this.key = key;
				this.value = value;
			}
		}
		
		private int size; //n
		private LinkedList<HMNode>[] buckets;//array of linekd lists
		
		public HashMap(){
			initbucket(4);
			size = 0;
		}
		
		//initialize bucket
		private void initbucket(int N){
			buckets = new LinkedList[N];
			for(int bi =0; bi < N; bi++){
				buckets[bi] = new LinkedList<>();
			}
		}
		
		//add key-value in map
		public void put(K key, V value) throws Exception{
			 int bi = hashfxn(key);
			 int di = getIndexWithinBucket(key, bi);
			 //if present => update value
			 if(di != -1){
				HMNode node = buckets[bi].get(di);
				 node.value = value;
			 }
			 //not present => add key-value pair
			 else{
				HMNode node = new HMNode(key, value);
				buckets[bi].add(node);
				size+=1; 
			 }
			 double lambda = (size*1.0) / buckets.length;
			 if(lambda > 2.0){
				 rehash();
			 }
		}
		
		//helper methods
		private void rehash() throws Exception{
			LinkedList<HMNode>[] oba = buckets;
			
			initbucket(oba.length * 2);
			size = 0;
			
			for(int i=0; i<oba.length; i++){
				for(HMNode node : oba[i]){
					put(node.key, node.value);
				}
			}	
		}
		private int hashfxn(K key){
			int hc = key.hashCode();
			return Math.abs(hc) % buckets.length;
		}
		private getIndexWithinBucket(K Key, int bi){
			int di = 0;
			for(HMNode node : buckets[bi]){
				if(node.key.equals(key))return di;
				di+=1;
			}
			return -1;
		}
		
		//containsKey
		public boolean containsKey(K key){
			int bi = hashfxn(key);
			int di = getIndexWithinBucket(key, bi);
			
			if(di == -1)return false;
			else return true;
		}
		
		//get value
		public V get(K key){
			int bi = hashfxn(key);
			int di = getIndexWithinBucket(key, bi);
			
			if(di != -1){
			HMNode node = buckets[bi].get(di);
			return node.value;
			}
			else return null;
		}
		
		//remove value
		public V remove(K key) throws Exception{
			int bi = hashfxn(key);
			int di = getIndexWithinBucket(key, bi);
			
			if(di != -1){
				HMNode node = buckets[bi].remove(di);
				return node.value;
				size-=1;
			}
			else{
				return null;
			}
		}
		
		//size
		public int size(){
			return size;
		}
		
		//get keySet
		public ArrayList<K> keySet() throws Exception{
			ArrayList<K> keys  = new ArrayList<>();
			for(int i=0; i<buckets.length; i++){
				for(HMNode node : buckets[i]){
                  keys.add(node.key);
                }  
			}
			
			return keys;
		}
		
	} 
}
