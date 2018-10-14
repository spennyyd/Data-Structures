public class StopWatch{

   private long startTime;
   private long endTime;

   // No arg constructor
   StopWatch(){

   }
   // Method that sets the start time to the current time
   public void start(){
      startTime = System.currentTimeMillis();
   }
   // Method that sets the end time to the current time
   public void end(){
      endTime = System.currentTimeMillis();
   }
   // Method that returns the total elapsed time in milliseconds
   public long getElapsedTime(){
      return endTime - startTime;
   }
}// End of StopWatch class