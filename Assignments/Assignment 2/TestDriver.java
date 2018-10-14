public class TestDriver{
    public static void main(String[] args){

        // object for backwardarraylist
        BackwardArrayList testing = new BackwardArrayList();

        // Populating the list
        for(int i = 0; i < 19; i++){
            testing.addSomething(i);
        }
        // Testing the size after populating the array without a position given
        System.out.println("After populating the array, the current size of the list is: " + testing.theSize());
        
        // Adding a number to position 6
        testing.addSomething(6, 41);
        // Testing the size of the list
        System.out.println("After adding another element to the list the size is: " + testing.theSize());

        // Removing the element added with a specific position
        testing.removeSomething(6);
        // Testing the size of the list
        System.out.println("After removing an element from the list the size is: " + testing.theSize());
        
        // Trying to find a value in the list
        int indexRequested = testing.findSomething(6);
        System.out.println("The value 6 was found in the position: " + indexRequested);
        

    }
}