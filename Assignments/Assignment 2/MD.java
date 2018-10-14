/**
* Test Driver
*/
import java.util.Scanner;

public class MD{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        BackwardArrayList theList = new BackwardArrayList();
        int choice = 1;
        int addNum;
        int rmNum;
        int positionNum;
        int findNum;
        int foundNum;
        
        while(choice != 0){
            System.out.println("The size of the list: " + theList.theSize());
            System.out.println("pick a method:");
            System.out.println("1. addSomething");
            System.out.println("2. removeSomething");
            System.out.println("3. findSomething");
            System.out.println("0. exit");
            choice = input.nextInt();
            
            switch(choice){
                //addSomething
                case 1:{
                    System.out.println("What number would you like to add?");
                    addNum = input.nextInt();
                    System.out.println("What position? (type '0' no preference)");
                    positionNum = input.nextInt();
                    if (positionNum == 0){
                        theList.addSomething(addNum);
                    } else {
                        theList.addSomething(positionNum, addNum);
                    }
                    break;
                }
                //removeSomething
                case 2:{
                    System.out.println("What position of the list would you like to remove the number?");
                    rmNum = input.nextInt();
                    theList.removeSomething(rmNum);
                    break;
                }
                //findSomething
                case 3:{
                    System.out.println("What number are you looking for?");
                    findNum = input.nextInt();
                    foundNum = theList.findSomething(findNum);
                    if(foundNum == -1){
                        System.out.println("Number " + findNum + " was not found.");
                    }
                    else{
                        System.out.println("This number is found at posistion: " + foundNum);
                    }
                    break;
                }
            }
            System.out.println("\n");
            
        }
    }
}