package HeapsAndMaps;
 import java.lang.Object;
import java.util.*;
import java.io.*;

public class Hashmap_implementation {
   
    class MyHashMap {
        class HMNode{
            int key, val;
            HMNode(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
        LinkedList<HMNode>[] buckets;
        int size;
        public MyHashMap() {
               initbuckets(4);
               size = 0;
        }
    
        private void initbuckets(int n){
            buckets = new LinkedList[n];
            for(int i=0; i<n; i++)buckets[i] = new LinkedList<>();
        }
    
     
        public void put(int key, int value) {
            int bi = hashfxn(key); //bucket index
            int di = getIndexWithinBucket(key, bi); //index within bucket
    
            if(di != -1){
               HMNode node = buckets[bi].get(di);
               node.val = value;
            }
            else{
              HMNode node = new HMNode(key, value);
              buckets[bi].add(node);
              size+=1;
            }
    
            double lambda = (size * 1.0)/buckets.length;
            if(lambda > 2.0)rehash();
        }
        
        public int get(int key) {
                int bi = hashfxn(key);
                int di = getIndexWithinBucket(key, bi);
                if(di != -1){
                    HMNode node = buckets[bi].get(di);
                    return node.val;  
                }   
                return -1;
        }
        
        public void remove(int key){
               int bi = hashfxn(key);
               int di = getIndexWithinBucket(key, bi);
               if(di != -1){
                  buckets[bi].remove(di);
                  size-=1;
               }
        }
        
         public boolean containsKey(int key){
                int bi = hashfxn(key);
                int di = getIndexWithinBucket(key, bi);
    
                if(di != -1)return true;
                else return false;
         }
         
         public ArrayList<Integer> keySet(){
                ArrayList<Integer> list = new ArrayList<>();
    
                for(int i=0; i<buckets.length; i++){
                    for(HMNode node : buckets[i]){
                        list.add(node.val);
                    }
                }  
                return list;
         }
    
    
    //helper methods
        private void rehash(){
            LinkedList<HMNode>[] oba = buckets;
            initbuckets(oba.length * 2);
            size = 0;
    
            for(int i=0; i<oba.length; i++){
                for(HMNode node : oba[i]){
                    put(node.key, node.val);
                }
            }
        }
    
        private int getIndexWithinBucket(int key, int bi){
               int index = 0;
               for(HMNode node : buckets[bi]){
                   if(node.key == key)return index;
                   index+=1;
               }
               return -1;               
        }
    
        private int hashfxn(int key){
            Integer temp = new Integer(key);
            int hc = temp.hashCode();
    
             return Math.abs(hc) % buckets.length;
        }
       
    }
}
