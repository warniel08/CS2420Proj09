package PriorityQueue;

import java.util.ArrayList;

public class PQueue<T> {
    final int MAX_QUEUE = 30;
    private int size_ = 0;
    private ArrayList<T> items; // items array for pq
    
    // PQueue Constructor
    public PQueue() {
        items = new ArrayList<>(MAX_QUEUE);
    }
    
    // boolean method isEmpty() to return true or false if PQueue is empty
    public boolean isEmpty() {
        return size_ == 0;
    }
    
    // method to insert() a newItem into the pq throws exception if full
    public void insert(T item) throws PQueueException {
        if (size_ < MAX_QUEUE) {
            T curr = null;
            // if the item to insert is is equal to curr then throw exception
            if (item.equals(curr)) {
                throw new PQueueException("PriorityQueue Exception: " +
                        "Insertion failed, duplicate item");
            } else {
                // otherwise, if item doesn't equal curr add the item
                items.add(item);
                size_++;
//                curr = item;
            }
        } else {
            throw new PQueueException("PriorityQueue Exception: Queue full");
        }
    }
}
