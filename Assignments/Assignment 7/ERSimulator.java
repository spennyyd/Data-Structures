/**
*  @author Ancel Carson
*  Assignment 6
*  4/10/18
*  Total Time Worked: 2:00
*  Windows 10
*  Atom and Command Line
*  Brief Program Description expected input, output, and process
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.InputMismatchException;
public class ERSimulator{
   public static void main(String[] args){
      int randomTimeDelay = 0, userChoice = 0, totalPatients = 0, priority = 0, totalWait = 0;
      int[] inRoomTime = null, wait = new int[4], close = new int[4], nums = new int[4];
      boolean check = true, morePatients = true, patientAdded = false;
      long clockTime = 0;
      Patient[] room = null;
      Scanner theInput = new Scanner(System.in);
      StopWatch openHours = new StopWatch();
      Queue<Patient> rating1 = new LinkedList<Patient>();
      Queue<Patient> rating2 = new LinkedList<Patient>();
      Queue<Patient> rating3 = new LinkedList<Patient>();
      Queue<Patient> rating4 = new LinkedList<Patient>();

      // DO FROM HERE
      System.out.println("How many rooms will be avaliable during this simulation?");
      try{
         userChoice = theInput.nextInt();
         if (userChoice <= 0 || userChoice > 10){
            throw new InputMismatchException();
         }
      }
      catch(InputMismatchException e1){
         System.out.println("Input must be an integer value less than 10.");
         System.exit(1);
      }
      room = new Patient[userChoice];
      inRoomTime = new int[userChoice];
      openHours.start();

      while(check){
         clockTime = (openHours.currentElapsedTime() / 1000);
         if (morePatients){
            if (clockTime >= randomTimeDelay){
               Patient newPatient = new Patient();
               switch(newPatient.rating){
                  case 1: rating1.add(newPatient); break;
                  case 2: rating2.add(newPatient); break;
                  case 3: rating3.add(newPatient); break;
                  case 4: rating4.add(newPatient); break;
               }
               randomTimeDelay = getRandomTime() + (int)(openHours.currentElapsedTime() / 1000);
            }
         }
         totalWait = rating1.size() + rating2.size() + rating3.size() + rating4.size();
         // STOP HERE!



         for(int i = 0; i < userChoice; i++){
            if(clockTime >= inRoomTime[i]){
               if(rating4.size() > 0){
                  room[i] = rating4.poll();
                  patientAdded = true;
               }
               else if(rating1.size() > 0 || rating2.size() > 0 || rating3.size() > 0){
                  priority = getPriority(rating1.peek(), rating2.peek(), rating3.peek());
                  switch(priority){
                     case 1:
                        room[i] = rating1.poll();
                        break;
                     case 2:
                        room[i] = rating2.poll();
                        break;
                     case 3:
                        room[i] = rating3.poll();
                        break;
                  }
                  patientAdded = true;
               }
               if(room[i] != null){
                  if(patientAdded){
                     inRoomTime[i] = room[i].inRoom() + (int)(openHours.currentElapsedTime() / 1000);
                     totalPatients++;
                     wait[priority - 1] = wait[priority - 1] + room[i].totalWait();
                     nums[priority - 1]++;
                     patientAdded = false;
                  }
               }
            }
         }

         if(clockTime >= 600){
            if(morePatients){
               close[0] = rating1.size();
               close[1] = rating2.size();
               close[2] = rating3.size();
               close[3] = rating4.size();
            }
            morePatients = false;
         }

         if(morePatients == false && totalWait == 0){
            check = false;
            openHours.stop();
         }
      }
      System.out.println("After 10 hours:");
      System.out.printf("\t%d patients of rating 1 were left.\n", close[0]);
      System.out.printf("\t%d patients of rating 2 were left.\n", close[1]);
      System.out.printf("\t%d patients of rating 3 were left.\n", close[2]);
      System.out.printf("\t%d patients of rating 4 were left.\n\n", close[3]);
      System.out.printf("Average wait time for rating 1: %d minutes\n", wait[0] / nums[0]);
      System.out.printf("Average wait time for rating 2: %d minutes\n", wait[1] / nums[1]);
      System.out.printf("Average wait time for rating 3: %d minutes\n", wait[2] / nums[2]);
      System.out.printf("Average wait time for rating 4: %d minutes\n", wait[3] / nums[3]);
      System.out.printf("It took %.2f hours ", (float)openHours.getElapsedTime() / 60000);
      System.out.printf("to room all %d patients\n", totalPatients);
   }

   // DO THIS
   static int getRandomTime(){
      return (int)(Math.random() * 5) + 5;
   }
   // END HERE

   static int getPriority(Patient pat1, Patient pat2, Patient pat3){
      int priority = 3;
      float priority1 = 0, priority2 = 0, priority3 = 0;
      if(pat1 != null){
         priority1 = pat1.getPriority();
      }
      if(pat2 != null){
         priority2 = pat2.getPriority();
      }
      if(pat3 != null){
         priority3 = pat3.getPriority();
      }
      if(priority2 > priority3){
         priority = 2;
         if(priority1 > priority2){
            priority = 1;
         }
      }
      if(priority1 > priority3){
         priority = 1;
         if(priority2 > priority1){
            priority = 2;
         }
      }
      return priority;
   }
}