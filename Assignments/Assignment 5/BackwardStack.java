/**
 * @author Spencer Davis
 * Assignment 5
 * Worked on assignment for 3 hours
 * Windows 10
 * Visual studio code
 * A stack class that uses an array. The last index of the array will be filled first
 * and elements will be added on top going toward zero.
 */

public class BackwardStack{

    /** Integer array that will hold all the values of the stack */
    private int[] bckwrdArray = new int[20];
    int top = 19;

    /**
     * Pushes a value onto the stack.
     * @param val The integer that is going to be added to the stack.
     */
    public void thePush(int val){
        bckwrdArray[top] = val;
        top -= 1;

        if(top == 0){
            makeBigger();
        }

    }

    /**
     * Pops the top of the stack off and removes that value from the stack.
     * @return The value that is on top of the stack.
     */
    public int thePop(){
        int stackTop = bckwrdArray[top + 1];
        bckwrdArray[top + 1] = 0;
        top += 1;
        return stackTop;
    }

    /**
     * Returns a boolean based upon if the stack is empty.
     * @return True or False if stack is empty.
     */
    public boolean isEmpty(){
        if(top == bckwrdArray.length - 1){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Prints all of the contents of the stack.
     */
    public void printStack(){
        System.out.print("[");
        for(int i = top + 1; i < bckwrdArray.length - 1; i++){
            System.out.print(bckwrdArray[i] + ", ");
        }
        System.out.println(bckwrdArray[bckwrdArray.length - 1] + "]");
    }

    private void makeBigger(){
        int newLength = (int)(bckwrdArray.length * 1.5);
        int[] newArray = new int[newLength];
        int oldSize = bckwrdArray.length - 1;
        newLength -= 1;                         // Subtracting one for indexing purposes.
        int stopPt = newLength - oldSize - 1;   // Variable for where the loops is going to stop.

        // Loop for copying all the values in the old array to the bigger array
        for(int i = newLength ; i > stopPt; i--){
            newArray[i] = bckwrdArray[oldSize];
            oldSize -= 1;
        }
        // Points the bckwrdArray variable to reference the newArray array.
        bckwrdArray = newArray;
        top = stopPt + 2;
    }
       
}