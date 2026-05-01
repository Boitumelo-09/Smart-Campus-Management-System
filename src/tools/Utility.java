package tools;

public class Utility {


    public void print(String message) {
        IO.println(message);
    }
   public void newLine(int times) {
       for (int i = 0; i < times; i++) {
           IO.println();
       }
   }
   public void heading(String heading) {
       IO.println(".".repeat(65));
       IO.println("    "+heading+" ");
       IO.println(".".repeat(65));
   }
   public void enterToContinue() {
       IO.readln("Press Enter to continue...");
   }
}
