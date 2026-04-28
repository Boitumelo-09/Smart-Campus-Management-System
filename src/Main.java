import models.Student;
import dataStructures.*;
import java.util.Scanner;

public class Main {
    private static final CustomHashTable hashTable = new CustomHashTable();
    private static final CustomLinkedList linkedList = new CustomLinkedList();
    private static final CustomBST bst = new CustomBST();
    private static CustomQueue helpDesk = new CustomQueue();
    private static CustomStack activityStack = new CustomStack();

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "admin123";

    public static void main(String[] args) {

        loadStudents();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        IO.println("\n"+"-".repeat(65));
        IO.println("    SMART CAMPUS MANAGEMENT SYSTEM ");
        IO.println("    Built By Group 1");



        while (running) {
            IO.println("\n1. Blackboard Login");
            IO.println("2. Admin Login");
            IO.println("3. Exit");
            System.out.print(">> ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> studentLogin(sc);
                case 2 -> adminLogin(sc);
                case 3 -> {
                    IO.println("Thank you for using the system. Goodbye !");
                    running = false;
                }
                default -> IO.println("Invalid option.");
            }
        }
        sc.close();
    }

    private static void loadStudents() {
        Student[] data = {
                new Student("Mkhondo Boitumelo", "202402475", "2286", "Block A - Room 2286"),
                new Student("Mashego Beanca", "202401789", "0038", "Block B - Room 0038"),
                new Student("Selowa Refentse", "240101280", "2025", "Block C - Room 2025"),
                new Student("Raedani Thikhedzo", "202402331", "0691", "Block D - Room 0691"),
                new Student("Maphanga Thabang", "240101213", "1738", "Block A - Room 1738"),
                new Student("Tema Kagiso", "202303501", "5134", "Block E - Room 5134"),
                new Student("Tsengiwe Thembinkosi", "250102831", "6743", "Block B - Room 6743"),
                new Student("Diale Lutricia", "240101158", "1049", "Block C - Room 1049"),
                new Student("Maphidzhe Mutondwa", "240001504", "7017", "Block D - Room 7017"),
                new Student("Chauke Austin", "202100201", "1712", "Block A - Room 1712"),
                new Student("Disoloane Shaun", "202203196", "1234", "Block E - Room 1234"),
                new Student("Kgoale Blessing", "202400323", "1628", "Block B - Room 1628"),
                new Student("Ramatsetse Kagiso", "202101092", "1669", "Block C - Room 1669"),
                new Student("Kgantsho Gallant", "202001320", "3847", "Block D - Room 3847"),
                new Student("Mihle Giwu", "202403013", "5463", "Block A - Room 5463"),
                new Student("Matshivha Tshinakaho", "240101211", "8577", "Block E - Room 8577"),
                new Student("Lebese Lerato", "202400056", "9479", "Block B - Room 9479"),
                new Student("Choshi Tetelo kwena", "240001082", "0000", "Block C - Room 0000"),
                new Student("Moloto Katlego", "240974070", "8008", "Block D - Room 8008")
        };

        for (Student s : data) {
            hashTable.put(s.getStudentId(), s);
            linkedList.add(s);
            bst.insert(s);
        }
    }

    private static void studentLogin(Scanner sc) {
        System.out.print("\nStudent Number : ");
        String id = sc.nextLine().trim();
        System.out.print("4-digit PIN    : ");
        String pin = sc.nextLine().trim();

        Student student = hashTable.get(id);

        if (student != null && student.getPin().equals(pin)) {
            IO.println("\n✅ Login Successful! Hello, " + student.getFullName().toUpperCase() + "!");
            activityStack.push("Student login: " + student.getFullName());
            showStudentDashboard(student);
            // Add a sample help desk ticket
            helpDesk.enqueue(student.getFullName() + " - Log In To Blackboard");
        } else {
            IO.println("❌ Invalid Student Number Or PIN. Please try again.");

            helpDesk.enqueue("Invalid Student Number Or PIN");
            activityStack.push("Invalid Student Number Or PIN");
            IO.println("Press Enter to TRY AGAIN...");
            IO.readln();
        }
    }

    private static void showStudentDashboard(Student s) {
        IO.println("\n" + ".".repeat(65));
        IO.println("                    UL BLACKBOARD");
        IO.println(".".repeat(65));
        IO.println("Name       : " + s.getFullName());
        IO.println("Student No : " + s.getStudentId());
        IO.println("Residence  : " + s.getResidence());
        IO.println("\nPress Enter to view Semester 1 modules...");
        IO.readln();
        IO.println("Semester 1 Modules:");
        int moduleCounter = 5;
        for (String module : s.getModules()) {
            moduleCounter--;
            IO.println("   • " + module);
            if (moduleCounter == 2) {
                IO.println("\nPress Enter to view second semester modules...");
                IO.readln();
                IO.println("Semester 2 Modules:");

            }

        }
        IO.println(".".repeat(65));
        IO.readln("Press Enter to return to main menu...");

    }

    private static void adminLogin(Scanner sc) {

        String user = IO.readln("\nEnter your username: ");
        String pass = IO.readln("Enter your password: ");

        if (ADMIN_USER.equals(user) && ADMIN_PASS.equals(pass)) {
            adminDashboard(sc);
            activityStack.push("Admin login");
        } else {
            IO.println("❌ Admin login failed.");
            IO.println("Please check your credentials and try again.");

            helpDesk.enqueue("Admin login failed");
            activityStack.push("Admin login failed");
        }
    }

    private static void adminDashboard(Scanner sc) {
        boolean inAdmin = true;
        while (inAdmin) {
            IO.println("\n ADMINISTRATION ");
            IO.println("1. View All Students");
            IO.println("2. Search by Student Number");//(HashTable - O(1))
            IO.println("3. Search by Full Name "); //(BST)
            IO.println("4. View Students Sorted by Name ");//(BST Inorder)
            IO.println("5. View Help Desk Queue");
            IO.println("6. View Recent Activities "); //(Stack)
            IO.println("7. Logout");

            int choice = Integer.parseInt(IO.readln(">>"));


            switch (choice) {
                case 1 -> linkedList.displayAll();
                case 2 -> {
                    System.out.print("Enter Student Number :");
                    String id = sc.nextLine();
                    Student s = hashTable.get(id);
                    IO.println(s != null ? s : """
                           \s
                           ERROR 404 :  Student\s""" + id+ """ 
                                        Not found
                            
                            """);
;
                }
                case 3 -> {
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    bst.searchByName(name);
                }
                case 4 -> bst.inorderDisplay();
                case 5 -> helpDesk.displayHelpDesk();
                case 6 -> activityStack.displayRecent();
                case 7 -> inAdmin = false;
                default -> IO.println("Invalid choice.");
            }
        }
    }
}