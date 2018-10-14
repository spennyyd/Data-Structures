/*******************************
 * @author Spencer Davis
 * Assignment 1
 * Completed on 08-27-18
 * Worked on assignmetn for 2.5 hours
 * Windows 10
 * Visual studio code
 * Program takes numbers from a file, puts them into an array then asks the user if they want to find
 * the even numbers or the odd numbers. Then outputs the wanted numbers to a file with the users name
 * @throws ArrayIndexOutOfBoundsException   Will throw an ArrayIndexOutOfboundsException if the user doesn't give a path
 * @throws FileNotFoundException            Throws a FileNotFoundException if the user gives a path with an invalid file
********************************/

import java.util.Scanner;
import java.io.*;
import java.lang.NullPointerException;

public class Assign1{
	public static void main(String[] args){
	
	// Declartion of all variables
	Scanner fileInput = null;
	Scanner input = new Scanner(System.in);
	String fullName = null;
	int[] unsortedNum = new int[6000];
	int[] sortedNum = new int[6000];
	int amtSorted, usrChoice;
	int ttlNum = 0;
	File theOutput;
	PrintWriter output = null;
	
	

	/* Catching if the user gave a file that doesn't exist and if a user doesn't put an arguement */
	try{
		if(args.length != 1)
		{
			throw new ArrayIndexOutOfBoundsException();
		}

		fileInput = new Scanner(new File (args[0]));

		fullName = getFileName();

		theOutput = new File(fullName);
		output = new PrintWriter(theOutput);

	

	}
	catch(FileNotFoundException e1){
		System.out.println("Please enter a valid file that exists");
		System.exit(1);
	}
	catch(ArrayIndexOutOfBoundsException e2){
		System.out.println("You must enter a file directory");
		System.exit(1);
	}

	/* Loop that imports all the numbers into the unsortedNum array */
	int i = 0;
	while(fileInput.hasNext()){
		unsortedNum[i] = fileInput.nextInt();
		i += 1;
		ttlNum +=1;
	}

	/* List of output statments to get the user's name and choice of positive or negative numbers to be sorted */
	System.out.println("Would you like to find all the:");
	System.out.println("1) Positive Numbers");
	System.out.println("2) Negative Numbers");
	System.out.println("Please enter 1 or 2");
	usrChoice = input.nextInt();


	amtSorted = sort(unsortedNum, usrChoice, sortedNum, ttlNum);


	for(int j = 0; j < amtSorted - 1; j++){
		output.println(sortedNum[j]);
	}
	output.print(sortedNum[amtSorted - 1]);

	System.out.println("The program has completed. You can find the " + amtSorted + " numbers that were sorted in the file " + fullName);
	System.out.println("There were a total of " + ttlNum + " and there were " + amtSorted + " numbers sorted into the file.");

	input.close();
	fileInput.close();
	output.close();
	}// End of main


/**********
 * Sorts the numbers that were taken out of the file into an array of either positive or negative numbers based upon the user's input
 * @param sortMe[]       An integer array that has all the numbers that were orginally stored in the file
 * @param posOrNeg       The variale that stores the choice of the user for positive or negative numbers 
 * @param sortedMe[]     An integer array that stores the numbers that have been sorted based upon what the user wanted
 * @param totalNum       The total number of numbers that was in the original file
 * @return               The number of numbers that were sorted into a new array
***********/

public static int sort(int[] sortMe, int posOrNeg, int[] sortedMe, int totalNum){
	
	int j = 0; // Variable to store items in the sorted array
	int numSorted = 0;
	
	if(posOrNeg == 1){
		for(int i = 0; i < totalNum; i++){
			if(sortMe[i] > 0){
				sortedMe[j] = sortMe[i];
				j++;
				numSorted += 1;
			}
		}
	}
	else if(posOrNeg == 2){
		for(int i = 0; i < totalNum; i++){
			if(sortMe[i] < 0){
				sortedMe[j] = sortMe[i];
				j++;
				numSorted += 1;
			}
		}
	}

	return numSorted;
} // End of sort method  

/***************
 * Prompts user to input their first and last name, then combines them and adds .txt to the end so it can be used for the output file
 * @return Returns the full name of the file 
 **************/

public static String getFileName(){

	String firstName, lastName, fileName;
	Scanner methodInput = new Scanner(System.in);

	System.out.println("Please enter your first name:");
	firstName = methodInput.next();
	System.out.println("Please enter your last name:");
	lastName = methodInput.next();

	fileName = firstName + lastName + "Numbers.txt";

	return fileName;
}

}// end of Class Assign1