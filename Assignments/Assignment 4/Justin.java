/**
 * @author Dr. Rouse, commented by Spencer Davis
 * Assignment 4
 * Completed on 09-26-18
 * Worked on assignment for 1 hour
 * Windows 10
 * Visual studio code
 */

public class Justin{
    public static void main(String[] args){
        // Creating a linked list that is for testing.
        LinkedList testList = new LinkedList();

        System.out.println();
        // Testing the is empty method.
        System.out.println("Testing if the list is empty:");
        System.out.println("The list is empty: " + testList.isEmpty());
        System.out.println("The size of the list is currently: " + testList.getSize());
        System.out.println();
        
        // Adding an element to the list to see if it is still empty
        testList.insertAtStart("Start");
        System.out.println("Testing if the list is empty after adding something:");
        System.out.println("The list is empty: " + testList.isEmpty());
        System.out.println("The size of the list is currently: " + testList.getSize());

        // Testing add something at end
        testList.insertAtEnd("End");
        System.out.println();
        System.out.println("Testing adding something to the end of the list");
        System.out.println("The size of the list is currently: " + testList.getSize());   // The list should be 2 long.

        // Testing add something at start with values in the list
        testList.insertAtStart("Start 2");
        System.out.println();
        System.out.println("Testing add something at start with values in the list");
        System.out.println("The size of the list is currently: " + testList.getSize());   // The list should be 3 long.

        // Testing the insert position
        testList.insertAtPos("Position", 2); // Inserting at the 2nd postion should insert it in the middle of the list.
        System.out.println();
        System.out.println("Testing the insert at postion method");
        System.out.println("The size of the list is currently: " + testList.getSize());   // The list should be 4 long.

        // Testing removing the start
        testList.deleteAtPos(1);
        System.out.println();
        System.out.println("After removing a node from beginning of the list: ");
        System.out.println("The size of the list is currently: " + testList.getSize());   // The list should be 3 long.

        // Testing removing the end
        testList.deleteAtPos(testList.getSize());
        System.out.println();
        System.out.println("After removing a node from the end of the list: ");          
        System.out.println("The size of the list is currently: " + testList.getSize());   // The list should be 2 long.

        // Testing removing at a position
        testList.insertAtStart("String"); // Need to add this so there aren't only end and start nodes in list
        testList.deleteAtPos(2); 
        System.out.println();
        System.out.println("After removing a node from position 2: ");
        System.out.println("The size of the list is currently: " + testList.getSize());   // The list should be 2 long.
    }

}