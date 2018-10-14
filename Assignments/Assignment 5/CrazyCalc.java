/**
 * @author Spencer Davis
 * Assignment 5
 * Worked on assignment for 3 hours
 * Windows 10
 * Visual studio code
 * Program creates a backward stack then allows the user to do different operations 
 * on the contents of the stack.
 */

import java.util.Scanner;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;
public class CrazyCalc{
    public static void main(String[] args){
        char usrChoice;
        Scanner input = new Scanner(System.in);
        BackwardStack stack = new BackwardStack();
        int val1 = 0;
        int val2 = 0;
        int answer;

        // Printin the menu for user's input.
        menu();
        usrChoice = input.next().toLowerCase().charAt(0);

        while(usrChoice != 'x'){
            switch(usrChoice){

                // This is for if the the user wants to add a number to the stack.
                case '#':
                    System.out.println("Please enter a number to be added to the stack:");
                    stack.thePush(input.nextInt());
                    break;

                // This is for if the user wants to know what the contents of the entire stack are.
                case '?':
                    if(stack.isEmpty()){
                        System.out.println("The contents of the stack are:");
                        System.out.println("[]");
                    }
                    else{
                    System.out.println("The contents of the stack are:");
                    stack.printStack();
                    }
                    break;

                // This case is for if the user wants to add the top two numbers of the stack.
                // The answer is pushed onto the stack.
                case '+':

                    // Checking if the stack is empty, then getting the minimum number of required parts to complete the operation.
                    if(stack.isEmpty()){
                        System.out.println("Please enter a number to be added to the stack:");
                        stack.thePush(input.nextInt());
                        System.out.println("Please enter a number to be added to the stack:");
                        stack.thePush(input.nextInt());
                    }
                    // Checking if the stack has more than 1 value in it.
                    if(stack.isEmpty() == false){
                        // Variable to store th+e top value of the stack temporarly.
                        int temp = stack.thePop();
                        // Checking if the stack is empty after popping one value off.
                        if(stack.isEmpty()){
                            System.out.println("Please enter a number to be added to the stack:");
                            stack.thePush(temp);
                            stack.thePush(input.nextInt());
                        }
                        else{
                        stack.thePush(temp);
                        }
                    }
                    
                    val1 = stack.thePop();
                    val2 = stack.thePop();
                    
                    answer = val1 + val2;
                    stack.thePush(answer);
            
                    System.out.println(val1 + " + "+ val2 + " = " + answer);
                    break;

                // This case is for if the user wants to subtract the top two numbers of the stack.
                // The answer is pushed onto the stack.
                case '-':
                if(stack.isEmpty()){
                    System.out.println("Please enter a number to be added to the stack:");
                    stack.thePush(input.nextInt());
                    System.out.println("Please enter a number to be added to the stack:");
                    stack.thePush(input.nextInt());
                }
                // Checking if the stack has more than 1 value in it.
                if(stack.isEmpty() == false){
                    // Variable to store th+e top value of the stack temporarly.
                    int temp = stack.thePop();
                    // Checking if the stack is empty after popping one value off.
                    if(stack.isEmpty()){
                        System.out.println("Please enter a number to be added to the stack:");
                        stack.thePush(temp);
                        stack.thePush(input.nextInt());
                    }
                    else{
                    stack.thePush(temp);
                    }
                }                    

                val1 = stack.thePop();
                val2 = stack.thePop();
                answer = val1 - val2;
                stack.thePush(answer);

                System.out.println(val1 + " - " + val2 + " = " + answer);
                break;

                // This case is for if the user wants to multiply the top two numbers of the stack.
                // The answer is pushed onto the stack.
                case '*':
                    // Checking if the stack is empty so the operation can proceed.
                    if(stack.isEmpty()){
                        System.out.println("Please enter a number to be added to the stack:");
                        stack.thePush(input.nextInt());
                        System.out.println("Please enter a number to be added to the stack:");
                        stack.thePush(input.nextInt());
                    }
                    // Checking if the stack has more than 1 value in it.
                    if(stack.isEmpty() == false){
                        // Variable to store th+e top value of the stack temporarly.
                        int temp = stack.thePop();
                        // Checking if the stack is empty after popping one value off.
                        if(stack.isEmpty()){
                            System.out.println("Please enter a number to be added to the stack:");
                            stack.thePush(temp);
                            stack.thePush(input.nextInt());
                        }
                        else{
                        stack.thePush(temp);
                        }
                    }

                    val1 = stack.thePop();
                    val2 = stack.thePop();
                    answer = val1 * val2;
                    stack.thePush(answer);

                    System.out.println(val1 + " * " + val2 + " = " + answer);
                    break;

                // This case is for if the user wants to divide the top two numbers of the stack.
                // The answer is pushed onto the stack.
                case '/':
                    // Checking if the stack is empty so the operation can proceed.
                    if(stack.isEmpty()){
                        System.out.println("Please enter a number to be added to the stack:");
                        stack.thePush(input.nextInt());
                        System.out.println("Please enter a number to be added to the stack:");
                        stack.thePush(input.nextInt());
                    }
                    // Checking if the stack has more than 1 value in it.
                    if(stack.isEmpty() == false){
                        // Variable to store th+e top value of the stack temporarly.
                        int temp = stack.thePop();
                        // Checking if the stack is empty after popping one value off.
                        if(stack.isEmpty()){
                            System.out.println("Please enter a number to be added to the stack:");
                            stack.thePush(temp);
                            stack.thePush(input.nextInt());
                        }
                        else{
                        stack.thePush(temp);
                        }
                    }

                    val1 = stack.thePop();
                    val2 = stack.thePop();
                    if(val2 == 0){
                        System.out.println("You cannot divide by zero. Please choose a different operation");
                        break;
                    }
                    answer = val1 / val2;
                    stack.thePush(answer);

                    System.out.println(val1 + " / " + val2 + " = " + answer);
                    break;
            }
            menu();
            usrChoice = input.next().toLowerCase().charAt(0);

        }
        System.out.println("Thanks for using the Crazy Calculator!");
        input.close();
    } // End of main

    /**
     * Displays a menu for the user
     */
    public static void menu(){
        System.out.println();
        System.out.println("Choose one option:");
        System.out.println("#: Enter a number.");
        System.out.println("?: Print the stack.");
        System.out.println("+: Add the top two numbers of the stack");
        System.out.println("-: Subtract the top two numbers of the stack");
        System.out.println("*: Multiply the top two numbers of the stack");
        System.out.println("/: Divide the two top numbers of the stack");
        System.out.println("X: Exit");
    }

 
}
