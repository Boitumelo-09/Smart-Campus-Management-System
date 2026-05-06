package system;

import dataStructures.*;
import models.Student;
import tools.Utility;

import static java.lang.Integer.parseInt;

public class SystemEngine {
    static Utility tool = new Utility();
    private static final CustomHashTable hashTable = new CustomHashTable();
    private static final CustomLinkedList linkedList = new CustomLinkedList();
    private static final CustomBST bst = new CustomBST();
    private static final CustomQueue helpDesk = new CustomQueue();
    private static final CustomStack activityStack = new CustomStack();


    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

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
            int choice = parseInt(IO.readln(">> "));

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

    private static void loadStudents() {
        Student[] data = {
                new Student("Mkhondo Boitumelo", "202402475", "2286", "Sandton Res(Off-Campus) - Room 2286", "Male"),
                new Student("Mashego Beanca", "202401789", "0038", "MBJ Residences - Room 0038", "Female"),
                new Student("Selowa Refentse", "240101280", "2025", "MBJ Residences - Room 2025", "Male"),
                new Student("Raedani Thikhedzo", "202402331", "0691", "PPL Residence - Room 0691", "Male"),
                new Student("Maphanga Thabang", "240101213", "1738", "MBA Residence - Room 1738", "Male"),
                new Student("Tema Kagiso", "202303501", "5134", "Kayla Residence  - Room 5134", "Male"),
                new Student("Tsengiwe Thembinkosi", "250102831", "6743", "MBA Residences - Room 6743", "Male"),
                new Student("Diale Lutricia", "240101158", "1049", "VG Residences - Room 1049", "Female"),
                new Student("Maphidzhe Mutondwa", "240001504", "7017", "Sandton Res(Off-Campus) - Room 7017", "Male"),
                new Student("Chauke Austin", "202100201", "1712", "The Reds Student Residence(Off-Campus) - Room 1712", "Male"),
                new Student("Disoloane Shaun", "202203196", "1234", "MBK Residences - Room 1234", "Male"),
                new Student("Kgoale Blessing", "202400323", "1628", "BEREA Smart Res(Off-Campus) - Room 1628", "Male"),
                new Student("Ramatsetse Kagiso", "202101092", "1669", "Sunset Res(Off-Campus) - Room 1669", "Male"),
                new Student("Kgantsho Gallant", "202001320", "3847", "VK Residences - Room 3847", "Male"),
                new Student("Mihle Giwu", "202403013", "5463", "The Reds Student Residence(Off-Campus) - Room 5463", "Female"),
                new Student("Matshivha Tshinakaho", "240101211", "8577", "MBK Residences - Room 8577", "Female"),
                new Student("Lebese Lerato", "202400056", "9479", "BEREA Smart Res(Off-Campus) - Room 9479", "Female"),
                new Student("Choshi Tetelo kwena", "240001082", "0000", "Sunset Res(Off-Campus) - Room 0000", "Male"),
                new Student("Moloto Katlego", "240974070", "8008", "VK Residences - Room 8008", "Male"),
                new Student("Maluleke Mahlatsi", "250102936", "4269", "Mahlo Res(Off-Campus) - Room 4269", "Male")
        };
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
        tool.heading("BLACKBOARD LOGIN");
        String id = IO.readln("\nStudent Number : ").trim();
        String pin = IO.readln("4-digit PIN    : ").trim();
        Student student = hashTable.get(id);

        if (student != null && student.getPin().equals(pin)) {
            tool.newLine(5);
            IO.print("\n✅ Login Successful! Hello, ".concat(student.getGender().equalsIgnoreCase("Male") ? "Mr. " : "Ms. ").concat(student.getFullName().toUpperCase().concat("!")));
            activityStack.push("Student Log-In: ".concat(student.getFullName().toUpperCase()).concat(": ").concat(student.getStudentId()));
            showStudentDashboard(student);

        } else {
            IO.readln("❌ Invalid Student Number Or PIN. Please try again.");

            activityStack.push("Log-In Attempt: Invalid Student Number Or PIN");

        }
    }

    private static void showStudentDashboard(Student student) {


       tool.heading("UL BLACKBOARD");
        IO.println("Name       : " + student.getFullName());
        IO.println("Gender     : " + student.getGender());
        IO.println("Student No : " + student.getStudentId());
        IO.println("Residence  : " + student.getResidence());
        IO.readln("\nPress Enter to view Semester 1 modules...");

        IO.println("Semester 1 Modules:");

        int moduleCounter = 5;
        for (var module : student.getModules()) {
            moduleCounter--;
            IO.println("   • " + module);
            if (moduleCounter == 2) {
                IO.readln("\nPress Enter to view second semester modules...");
                IO.println("\nSemester 2 Modules:");

            }

        }
        IO.println(".".repeat(90));

        tool.enterToContinue();
        {
            tool.heading("Student Affairs");
            IO.println("1.Request Help Desk");
            IO.println("2.Log-Out");
            int choice = parseInt(IO.readln(">>"));
            switch (choice) {
                case 1 -> {
                    while (true) {
                        String request = IO.readln("\nEnter your request: ").trim();
                        activityStack.push(student.getFullName().concat((": ").concat(student.getStudentId()).concat(" ")).concat(" - Request Help Desk"));
                        helpDesk.enqueue(student.getFullName().concat((": ").concat(student.getStudentId()).concat(" ")).concat(" - ").concat(request));
                        int helpOption = parseInt(IO.readln(" ✔ Help Desk request submitted.\nSubmit another request?\n1. Yes\n2. No\n>>"));
                        if (helpOption == 2) {
                            IO.println("\nThank you for visiting.");
                            activityStack.push("Student Log-Out: ".concat(student.getFullName().toUpperCase()).concat(": ").concat(student.getStudentId()));
                            break;
                        } else if (helpOption > 2) {
                            IO.println("Invalid choice.");
                            tool.enterToContinue();
                        }

                    }
                    tool.enterToContinue();
                }
                case 2 -> {
                    IO.println("Goodbye, ".concat(student.getFullName().toUpperCase().concat("!")));
                    activityStack.push("Student Log-Out: ".concat(student.getFullName().toUpperCase()).concat(": ").concat(student.getStudentId()));
                }
            }
        }
        IO.println(".".repeat(90));
    }

    private static void adminLogin() {
        tool.newLine(5);
        tool.heading("ADMIN LOGIN");
        String adminUserName = IO.readln("\nAdmin username: ").trim();
        String adminPassword = IO.readln("Admin password: ").trim();
        IO.readln("Confirm and proceed >>");
        if (ADMIN_USERNAME.equals(adminUserName) && ADMIN_PASSWORD.equals(adminPassword)) {
            adminDashboard();
            activityStack.push("ADMIN: Log-In Successful");

        } else {
            IO.println("❌ Admin login failed.\nPlease check your credentials and try again...");
            activityStack.push("ADMIN: Log-In Failed");
        }
    }

    private static void adminDashboard() {
        tool.newLine(5);
        boolean isAdmin = true;
        while (isAdmin) {
            tool.heading("ADMINISTRATION");
            IO.println("1. View All Students");
            IO.println("2. Search by Student Number");//(HashTable - O(1))
            IO.println("3. Search by Full Name "); //(BST)
            IO.println("4. View Students Sorted by Name ");//(BST Inorder)
            IO.println("5. View Help Desk Tasks");
            IO.println("6. View Recent Activities "); //(Stack)
            IO.println("7. Log-Out");
            int choice = parseInt(IO.readln(">>"));

            switch (choice) {
                case 1 -> {
                    tool.newLine(5);
                    linkedList.displayAll();
                    activityStack.push("ADMIN OPERATION: View All Students");
                    tool.enterToContinue();
                }
                case 2 -> {
                    tool.newLine(5);
                    tool.heading("SEARCH BY STUDENT NUMBER");
                    String studentNumber = IO.readln("Student Number :");
                    Student student = hashTable.get(studentNumber);
                    IO.println(student != null ? student : """
                            \s
                            ERROR 404 :  Student\s""" + studentNumber + """ 
                                        Not found
                            
                            """);
                    activityStack.push("ADMIN OPERATION: Search by Student Number: ".concat(studentNumber));
                    tool.enterToContinue();

                }
                case 3 -> {
                    tool.newLine(5);
                    tool.heading("SEARCH BY FULL NAME");
                    String name = IO.readln("Search: ").trim();
                    bst.searchByName(name);
                    activityStack.push("ADMIN OPERATION: Search by Full Name: ".concat(name));
                    tool.enterToContinue();
                }
                case 4 -> {
                    tool.newLine(5);
                    tool.heading("STUDENTS SORTED BY NAME");
                    bst.inorderDisplay();
                    activityStack.push("ADMIN OPERATION: View Students Sorted by Name");
                    tool.enterToContinue();
                }
                case 5 -> {
                    tool.newLine(5);
                    helpDesk.displayHelpDesk();
                    tool.heading("HELP DESK AFFAIRS");
                    int taskChoice = parseInt(IO.readln("1. Resolve a task\n2. Log-Out\n>>"));
                    switch (taskChoice) {
                        case 1 -> {
                            while (true) {

                                tool.heading("Help Desk Affairs");
                                String taskNumber = IO.readln("Resolve a task by entering the task number:");
                                String dequeuedTask = helpDesk.dequeue(parseInt(taskNumber));
                                tool.heading("ATTENDED: ".concat(dequeuedTask));
                                activityStack.push("ADMIN OPERATION: Resolved a task: ".concat(taskNumber));
                                int option = Integer.parseInt(IO.readln("Resolve another task?\n   1. Yes\n   2. No\n   >>"));

                                if (option == 2) {
                                    IO.println("Thank you for visiting.");
                                    break;
                                } else if (option > 2) {
                                    IO.println("Invalid choice.");
                                    tool.enterToContinue();
                                }
                            }
                            tool.enterToContinue();
                        }
                        case 2 -> {
                            return;
                        }
                        default -> IO.println("Invalid choice.");
                    }

                }

                case 6 -> {
                    tool.newLine(5);
                    activityStack.displayRecent();
                    tool.enterToContinue();
                }
                case 7 -> isAdmin = false;
                default -> IO.println("Invalid choice.");
            }
        }
    }
}