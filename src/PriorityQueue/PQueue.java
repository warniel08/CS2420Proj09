/*
 *  Warner Nielsen
 *  4/4/19
 *  CS2420
 *  Proj08
 *  Garth Sorenson
 */

/*
 *  PriorityQueue class contains methods to insert and remove
 *  elements into/out of a sorted array, and it has an isEmpty()
 *  method to return boolean value.
 */
 
package PriorityQueue;

import java.util.ArrayList;

public class PQueue<T extends Comparable<T>> {
    private ArrayList<T> items; // items array for pq
    
    // PQueue Constructor
    public PQueue() {
        items = new ArrayList<>();
    }
    
    // boolean method isEmpty() to return true or false if PQueue is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    // method to insert() a newItem into the pq
    public void insert(T item) {        
        if (!items.isEmpty()) {
            int index;
            // use binarySearch to find index where to add item
            index = binarySearch(items, 0, items.size() - 1, item);
            items.add(index, item);
        } else {
            items.add(item);
        }
    }
    
    // delete method() returns item of type T and removes it from arrayList
    public T delete() {
        T curr = items.get(items.size() - 1);
//        if (curr != null) {
            try {
                items.remove(items.size() - 1);
                return curr;
            } catch (Exception e) {
                System.out.println("Error! No items to remove: " + e);
                return curr;
            }
//        }
//        return curr;
    }
    
    // method to print the values of pqueue to 
    // help with testing if the insert is working correctly
    public void printQueue() {
        if (items.size() <= 0) {
            System.out.println("The priority queue is empty");
        } else {
            for (T item: items) {
                System.out.println(item);
            }
        }
    }
    
    // method to return the size of the queue, used for testing
    public int sizeOfQ(){
        return items.size();
    }
    
    // binarySearch function to find index of where to place item in the ArrayList
    private int binarySearch(ArrayList<T> items, int first, int last, T item) {
        int index;
        if (first > last) {
            return first;
        } else {
            int mid = (first + last) / 2;
            if (item == items.get(mid)) {
                return mid;
            } else if (item.compareTo(items.get(mid)) <= 0) {
                index = binarySearch(items, first, mid-1, item);
                System.out.println("index: " + index);
            } else {
                index = binarySearch(items, mid+1, last, item);
            }
        }
        return index;
    }
}
