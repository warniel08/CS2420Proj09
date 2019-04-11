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
 
package NielWarnProj09;

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
    // if the array is empty it returns an error exception
    public T delete() {
        T curr = null;
        final String ANSI_RED = "\u001B[31m";  // color red to be used to highlight exception in console
        final String ANSI_RESET = "\u001B[0m";
        
        try {
            curr = items.get(items.size() - 1);
            items.remove(curr);
        } catch (Exception e) {
            System.out.println("\nError! Priority Queue is empty\n" + ANSI_RED + e + ANSI_RESET);
        }
        return curr;
    }
    
    // method to print the values of pqueue to 
    // be available option to the user if they select to print
    public void printQueue() {
        if (items.size() <= 0) {
            System.out.println("The priority queue is empty");
        } else {
            for (T item: items) {
                System.out.println(item);
            }
        }
    }
    
    // method to return the size of the queue, to be
    // available option to the user if they want to see the size
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
            // if value is less than or equal mid value, it returns the index 
            // this is used if there are duplicates it enters the value before
            // older duplicate value which keeps priority straight
            } else if (item.compareTo(items.get(mid)) <= 0) { 
                index = binarySearch(items, first, mid-1, item);
            } else {
                index = binarySearch(items, mid+1, last, item);
            }
        }
        return index;
    }
}
