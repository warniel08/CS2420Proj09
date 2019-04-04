package PriorityQueue;

import java.util.ArrayList;

public class PQueue<T extends Comparable<? super T>> {
    private int size_ = 0;
    private ArrayList<T> items; // items array for pq
    
    // PQueue Constructor
    public PQueue() {
        items = new ArrayList<>();
    }
    
    // boolean method isEmpty() to return true or false if PQueue is empty
    public boolean isEmpty() {
        return size_ == 0;
    }
    
    // method to insert() a newItem into the pq throws exception if full
    public void insert(T item) throws PQueueException {
        int curr;
        System.out.println("Items is empty: " + items.isEmpty()); 
        
        // if the item to insert is equal to curr then throw exception
        if (items.isEmpty()) {
            curr = 0;
            items.add(item);
            curr = items.indexOf(item);
            System.out.println("curr in items.Empty() = " + curr);
            size_++;
        } else {
//            if (item.equals(items.get(0))) {
//                throw new PQueueException("PriorityQueue Exception: " +
//                        "Insertion failed, duplicate item");
//            } else {
                if (items.size() > 1) {
                    // use binarySearch to find index where to add item
                    int index;
                    index = binarySearch(items, 0, size_ - 1, item);
                    items.add(index, item);
                    size_++;
                    curr = index;
                } else {
                    if (items.get(0).compareTo(item) < 0) {
                        items.add(item);
                        size_++;
                    } else {
                        items.add(0, item);
                        size_++;
                    }
                }
//            }
        }
    }
    
    // binarySearch function to find index of where to place item in the ArrayList
    private int binarySearch(ArrayList<T> items, int first, int last, T item) {
        int index;
        if (first > last) {
            index = -1;
        } else {
            int mid = (first + last) / 2;
            if (item == items.get(mid)) {
                index = mid;
            } else if (item.compareTo(items.get(mid)) < 0) {
                index = binarySearch(items, first, mid-1, item);
            } else {
                index = binarySearch(items, mid+1, last, item);
            }
        }
        return index;
    }
}
