public class Testing{
    public static void main(String[] args){
        BackwardStack testStack = new BackwardStack();
        
        for(int i = 0; i < 22; i++){
            testStack.thePush(i + 1);
        }
        testStack.printStack();
        System.out.println("the top of the stack: " +testStack.thePop());
    }
}