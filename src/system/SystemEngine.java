package system;

import dataStructures.*;
import models.Student;
import tools.Utility;

public class SystemEngine {
    static Utility tool = new Utility();
    private static final CustomHashTable hashTable = new CustomHashTable();
    private static final CustomLinkedList linkedList = new CustomLinkedList();
    private static final CustomBST bst = new CustomBST();
    private static final CustomQueue helpDesk = new CustomQueue();
    private static final CustomStack activityStack = new CustomStack();


    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private static void loadStudents() {
        Student[] data = {new Student("Mkhondo Boitumelo",
                "202402475", "2286", "Sandton Res(Off-Campus) - Room 2286"),
                new Student("Mashego Beanca", "202401789", "0038", "MBJ Residences - Room 0038"), new Student("Selowa Refentse", "240101280", "2025", "MBJ Residences - Room 2025"), new Student("Raedani Thikhedzo", "202402331", "0691", "PPL Residence - Room 0691"), new Student("Maphanga Thabang", "240101213", "1738", "MBA Residence - Room 1738"), new Student("Tema Kagiso", "202303501", "5134", "Kayla Residence  - Room 5134"), new Student("Tsengiwe Thembinkosi", "250102831", "6743", "MBA Residences - Room 6743"), new Student("Diale Lutricia", "240101158", "1049", "VG Residences - Room 1049"), new Student("Maphidzhe Mutondwa", "240001504", "7017", "Sandton Res(Off-Campus) - Room 7017"), new Student("Chauke Austin", "202100201", "1712", "The Reds Student Residence(Off-Campus) - Room 1712"), new Student("Disoloane Shaun", "202203196", "1234", "MBK Residences - Room 1234"), new Student("Kgoale Blessing", "202400323", "1628", "BEREA Smart Res(Off-Campus) - Room 1628"), new Student("Ramatsetse Kagiso", "202101092", "1669", "Sunset Res(Off-Campus) - Room 1669"), new Student("Kgantsho Gallant", "202001320", "3847", "VK Residences - Room 3847"), new Student("Mihle Giwu", "202403013", "5463", "The Reds Student Residence(Off-Campus) - Room 5463"), new Student("Matshivha Tshinakaho", "240101211", "8577", "MBK Residences - Room 8577"), new Student("Lebese Lerato", "202400056", "9479", "BEREA Smart Res(Off-Campus) - Room 9479"), new Student("Choshi Tetelo kwena", "240001082", "0000", "Sunset Res(Off-Campus) - Room 0000"), new Student("Moloto Katlego", "240974070", "8008", "VK Residences - Room 8008"), new Student("Maluleke Mahlatsi", "250102936", "4269", "Mahlo Res(Off-Campus) - Room 4269")};

        try {
            for (Student s : data) {
                hashTable.put(s.getStudentId(), s);
                linkedList.add(s);
                bst.insert(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void studentLogin() {
        tool.newLine(5);
        tool.heading( "BLACKBOARD LOGIN");
        String id = IO.readln("\nStudent Number : ").trim();
        String pin = IO.readln("4-digit PIN    : ").trim();
        Student student = hashTable.get(id);

        if (student != null && student.getPin().equals(pin)) {
            IO.println("\n✅ Login Successful! Hello, ".concat(student.getFullName().toUpperCase().concat(".!")));
            activityStack.push("Student login: ".concat(student.getFullName().toUpperCase()));
            showStudentDashboard(student);
            helpDesk.enqueue(student.getFullName().concat(" - Log In To Blackboard"));
        } else {
            IO.readln("❌ Invalid Student Number Or PIN. Please try again.");
            helpDesk.enqueue("Invalid Student Number Or PIN");
            activityStack.push("Invalid Student Number Or PIN");

        }
    }

    private static void showStudentDashboard(Student s) {
        tool.newLine(5);
        IO.println("\n" + ".".repeat(65));
        IO.println("                    UL BLACKBOARD");
        IO.println(".".repeat(65));
        IO.println("Name       : " + s.getFullName());
        IO.println("Student No : " + s.getStudentId());
        IO.println("Residence  : " + s.getResidence());
        IO.readln("\nPress Enter to view Semester 1 modules...");

        IO.println("Semester 1 Modules:");

        int moduleCounter = 5;
        for (var module : s.getModules()) {
            moduleCounter--;
            IO.println("   • " + module);
            if (moduleCounter == 2) {
                IO.readln("\nPress Enter to view second semester modules...");
                IO.println("Semester 2 Modules:");

            }

        }
        IO.println(".".repeat(65));
        IO.readln("Press Enter to return to main menu...");
        IO.println(".".repeat(65));
    }

    private static void adminLogin() {
        tool.newLine(5);
        tool.heading("ADMIN LOGIN");
        String adminUserName = IO.readln("\nAdmin username: ").trim();
        String adminPassword = IO.readln("Admin password: ").trim();
        IO.readln("Confirm and proceed >>");
        if (ADMIN_USERNAME.equals(adminUserName) && ADMIN_PASSWORD.equals(adminPassword)) {
            adminDashboard();
            activityStack.push("Logged In as Admin");
            helpDesk.enqueue("Admin login");
        } else {
            IO.println("❌ Admin login failed.");
            IO.readln("Please check your credentials and try again.");
            helpDesk.enqueue("Admin login failed");
            activityStack.push("Admin login failed");
        }
    }

    private static void adminDashboard() {
        tool.newLine(5);
        boolean inAdmin = true;
        while (inAdmin) {
            IO.println("\n ADMINISTRATION ");
            IO.println("1. View All Students");
            IO.println("2. Search by Student Number");//(HashTable - O(1))
            IO.println("3. Search by Full Name "); //(BST)
            IO.println("4. View Students Sorted by Name ");//(BST Inorder)
            IO.println("5. View Help Desk Tasks");
            IO.println("6. View Recent Activities "); //(Stack)
            IO.println("7. Logout");
            int choice = Integer.parseInt(IO.readln(">>"));


            switch (choice) {
                case 1 -> linkedList.displayAll();
                case 2 -> {
                    String id = IO.readln("Student Number :");
                    Student s = hashTable.get(id);
                    IO.println(s != null ? s : """
                            \s
                            ERROR 404 :  Student\s""" + id + """ 
                                        Not found
                            
                            """);

                }
                case 3 -> {
                    String name = IO.readln("Search: ");
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

    public void run() {

        loadStudents();

        boolean running = true;

       tool.heading("Welcome to the Smart Campus Management System\n    Developed By Group 1");
       tool.enterToContinue();
        while (running) {
            tool.newLine(5);
           tool.heading("MAIN MENU");
            IO.println("1. Blackboard Login");
            IO.println("2. Admin Login");
            IO.println("3. Exit");
            int choice = Integer.parseInt(IO.readln(">> "));

            switch (choice) {
                case 1 -> studentLogin();
                case 2 -> adminLogin();
                case 3 -> {
                    IO.println("Thank you for using the system. Goodbye !");
                    running = false;
                }
                default -> IO.println("Invalid option.");
            }
        }

    }
}