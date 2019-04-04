package PriorityQueue;

import java.util.ArrayList;

public class NielWarnProj09 {

    public static void main(String[] args) {
        PQueue<Double> newPQueue = new PQueue<>();
        newPQueue.insert(3.33);
        newPQueue.insert(24.56);
        newPQueue.insert(7.17);
        newPQueue.insert(57.39);
        newPQueue.insert(1.61);
        System.out.println("My newPQueue is empty: " + newPQueue.isEmpty());
        newPQueue.printQueue();
    }

}
