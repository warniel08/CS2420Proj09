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
        int curr = items.indexOf(item);
        // if the item to insert is is equal to curr then throw exception
        if (item.equals(items.get(curr))) {
            throw new PQueueException("PriorityQueue Exception: " +
                    "Insertion failed, duplicate item");
        } else {
            // use binarySearch to find index where to add item
            int index = binarySearch(items, 0, size_-1, item);
            items.add(index, item);
            size_++;
        }
    }
    
    public int binarySearch(ArrayList<T> items, int first, int last, T item) {
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
