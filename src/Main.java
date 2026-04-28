import system.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartCampusSystem campus = new SmartCampusSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║          🔥 SMART CAMPUS MANAGEMENT SYSTEM 🔥             ║");
        System.out.println("║               University of Limpopo Simulator              ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        while (running) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("1. Student Login (Show Modules & Profile)");
            System.out.println("2. Display All Students");
            System.out.println("3. Join Help Desk Queue");
            System.out.println("4. Process Next Help Desk Request");
            System.out.println("5. Show Recent Logins (Stack)");
            System.out.println("6. Exit");
            System.out.print("Choose action (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID (e.g. 202402474): ");
                    String id = scanner.nextLine();
                    campus.login(id);
                    break;
                case 2:
                    campus.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter your Student ID to join Help Desk: ");
                    String helpId = scanner.nextLine();
                    campus.joinHelpDesk(helpId);
                    break;
                case 4:
                    campus.processHelpDesk();
                    break;
                case 5:
                    campus.showRecentLogins();
                    break;
                case 6:
                    running = false;
                    System.out.println("👋 Thank you for using Smart Campus System. Stay winning broski!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}