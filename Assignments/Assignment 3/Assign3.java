import java.util.*;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import java.io.*;

public class Assign3{
    public static void main(String[] filePath)throws FileNotFoundException{
        // Declaring Variables
        Scanner fInput = null;    // File input scanner. Null because it will be initialized in the try block to make sure a file is given.
        StopWatch watch = new StopWatch(); // Array of stopwatch objects
        long[] times = new long[4];
        int i = 0;                          // Generic counting variable
        long minutes = 0;
        double seconds = 0;
        
        // Declaring all the different data structures that will be tested
        BackwardArrayList bkwrdArray = new BackwardArrayList();  
        LinkedList<Integer> linkList = new LinkedList<Integer>();                 
        List<Integer> arrayList = new ArrayList<Integer>();
        int[] normalArray = new int[2500000];

        // Try catch to make sure that the user entered a file path when running the program
        try{
            fInput = new Scanner(new File(filePath[0]));

        }
        catch(FileNotFoundException e1){
            System.out.println("Please enter a path with a valid file");
            System.exit(1);
        }
        catch(ArrayIndexOutOfBoundsException e2){
            System.out.println("Please enter a path with a valid file");
            System.exit(1);
        }

        // Starting the watch and while loop to time the input of a LINKED LIST
        watch.start();
        while(fInput.hasNext()){
            linkList.add(fInput.nextInt());
        }
        watch.end();
        times[0] = watch.getElapsedTime(); // The 0 index of times is the linked list

        // OUTPUT
        // ----------------------------------------------------
        System.out.println("The following displays how long it took input for each data structure:");
        System.out.println("----------------------------------------------------------------------");
        // LINKED LIST
		seconds = (double)times[0] / 1000;
		minutes = (long)seconds / 60;
		seconds = seconds -  (minutes * 60);
        System.out.println("Linked List: "+ minutes + " minutes and " + seconds + " seconds.");

        // Closing and re-opening the scanner to reset the file
        fInput.close();
        fInput = new Scanner(new File(filePath[0]));

        // Starting the watch and while loop to time the input of an array list
        watch.start();
        while(fInput.hasNext()){
            arrayList.add(fInput.nextInt());
        }
        watch.end();
        times[1] = watch.getElapsedTime(); // The 1 index of times is the array list

        // OUTPUT
        // -----------------------------------------------------
        // ARRAY LIST
		seconds = (double)times[1] / 1000;
		minutes = (long)seconds / 60;
		seconds = seconds -  (minutes * 60);
        System.out.println("Array List: " + minutes + " minutes and " + seconds + " seconds.");

        // Closing and re-opening the scanner to reset the file
        fInput.close();
        fInput = new Scanner(new File(filePath[0]));

        // Startin the watch and while loop to time the input of a normal array
        watch.start();
        while(fInput.hasNext()){
            normalArray[i] = fInput.nextInt();
            i++;
        }
        watch.end();
        times[2] = watch.getElapsedTime(); // The 2 index of times is the normal array

        // OTUPUT
        // -----------------------------------------------------
        // NORMAL ARRAY
		seconds = (double)times[2] / 1000;
		minutes = (long)seconds / 60;
		seconds = seconds -  (minutes * 60);
        System.out.println("Normal Array: " + minutes + " minutes and " + seconds + " seconds.");

        // Closing and re-opening the scanner to reset the file
        fInput.close();
        fInput = new Scanner(new File(filePath[0]));

        // Starting the watch and while loop to time the input of a backward array list
        watch.start();
        while(fInput.hasNext()){
            bkwrdArray.addSomething(fInput.nextInt());
        }
        watch.end();
        times[3] = watch.getElapsedTime(); // The 3 indeox of times is the backward array list.

        // OUTPUT
        // -----------------------------------------------------
        // BACKWARD ARRAY LISTT
		seconds = (double)times[3] / 1000;
		minutes = (long)seconds / 60;
		seconds = seconds -  (minutes * 60);
        System.out.println("Backward Array List: " + minutes + " minutes and " + seconds + " seconds.");

    } // end of main method
}
