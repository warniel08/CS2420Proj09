/*
 *  Warner Nielsen
 *  4/4/19
 *  CS2420
 *  Proj08
 *  Garth Sorenson
 */

/*
 *  Main driver for PQueue class. This driver is menu driven
 *  to give the user repeated chances to add items, remove
 *  items, check if ArrayList is empty, return the size
 *  of the Array List and print the items in the Array List.
 */
package PriorityQueue;

import java.util.Scanner;


public class NielWarnProj09 {

    public static void main(String[] args) {
        // welcome message and explanation of program
        System.out.println("Welcome to the PriorityQueue program.");
        System.out.println("\nThe menu gives you options to add an item,\n"
                + "remove an item, check if the list is empty,\n"
                + "print the size of the list, and print the\n"
                + "contents of the list.");
        
        // setup variables to be used in menu
        int userMenuChoice; // user's menu choice
        Double userVal;
        boolean again = true; // when user wants to run program again while is true
        PQueue<Double> newPQueue = new PQueue<>(); // creation of new priority queue
        Scanner userInput = new Scanner(System.in); // user input
        
        // display menu choices to run each part of the PQueue
        do {
            System.out.println("\nPriority Queue Menu: ");
            System.out.println("\t1 - Insert an item");
            System.out.println("\t2 - Remove an item");
            System.out.println("\t3 - Check if it is Empty");
            System.out.println("\t4 - Print Items in Queue");
            System.out.println("\t5 - Print Size of Queue");
            System.out.println("\t6 - Quit");
            
            System.out.print("Enter a choice: ");
            userMenuChoice = userInput.nextInt();
            
            // switch statement for menu choices
            switch (userMenuChoice) {
                case 1:
                    System.out.print("Please enter a number with a decimal value: ");
                    userVal = userInput.nextDouble();
                    newPQueue.insert(userVal);
                    System.out.println("\nUser value " + userVal + " inserted into priority queue");
                    break;
                case 2:
                    userVal = newPQueue.delete();
                    if (userVal != null) {
                        System.out.println("\nUser value " + userVal + " removed from priority queue");
                    } 
                    break;
                case 3:
                    System.out.println("\nThe priority queue is empty: " + newPQueue.isEmpty());
                    break;
                case 4:
                    System.out.println("\nHere are the values of your priority queue: ");
                    newPQueue.printQueue();
                    break;
                case 5:
                    System.out.println("\nThe size of your priority queue is: " + newPQueue.sizeOfQ());
                    break;
                case 6:
                    again = false;
                    break;
                default:
                    System.out.println("\nInvalid choice, please try again...");   
            }
        } while(again);
    }

}
