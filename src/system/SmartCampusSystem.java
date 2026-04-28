package system;

import dataStructures.*;
import models.Student;

public class SmartCampusSystem {
    private CustomHashMap<String, Student> studentsById;  // O(1) lookup
    private CustomArrayList<Student> allStudents;         // For iteration
    private CustomQueue<String> helpDeskQueue;            // FIFO for help desk
    private CustomStack<String> recentLogins;             // LIFO for recent activity

    public SmartCampusSystem() {
        studentsById = new CustomHashMap<>();
        allStudents = new CustomArrayList<>();
        helpDeskQueue = new CustomQueue<>();
        recentLogins = new CustomStack<>();

        loadSampleStudents();
    }

    private void loadSampleStudents() {
        String[][] data = {
                {"202402474", "Mkhondo Boitumelo", "2286"},
                {"202401789", "Mashego Beanca", "0038"},
                {"240101280", "Selowa Refentse", "2025"},
                {"202402331", "Raedani Thikhedzo", "0691"},
                {"240101213", "Maphanga Thabang", "1738"},
                {"202303501", "Tema Kagiso", "5134"},
                {"250102831", "Tsengiwe Thembinkosi", "6743"},
                {"240101158", "Diale Lutricia", "1049"},
                {"240001504", "Maphidzhe Mutondwa", "7017"},
                {"202100201", "Chauke Austin", "1712"},
                {"202203196", "Disoloane Shaun", "1234"},
                {"202400323", "Kgoale Blessing", "1628"},
                {"202101092", "Ramatsetse Kagiso", "1669"},
                {"202001320", "Kgantsho Gallant", "3847"},
                {"202403013", "Mihle Giwu", "5463"},
                {"240101211", "Matshivha Tshinakaho", "8577"},
                {"202400056", "Lebese Lerato", "9479"},
                {"240001082", "Choshi Tetelo kwena", "0000"},
                {"240974070", "Moloto Katlego", "80083"}
        };

        for (String[] s : data) {
            Student student = new Student(s[0], s[1], s[2]);
            studentsById.put(s[0], student);
            allStudents.add(student);
        }
    }

    public void login(String studentId) {
        Student student = studentsById.get(studentId);
        if (student != null) {
            System.out.println("\n✅ SUCCESSFUL LOGIN - WELCOME TO UL CAMPUS SYSTEM");
            student.displayInfo();
            recentLogins.push(student.getFullName() + " (" + studentId + ")");
        } else {
            System.out.println("\n❌ ACCESS DENIED: Student ID not found.");
        }
    }

    public void showRecentLogins() {
        System.out.println("\n🔥 RECENT CAMPUS ACTIVITY (Last logins - Stack):");
        recentLogins.display();
    }

    public void joinHelpDesk(String studentId) {
        Student s = studentsById.get(studentId);
        if (s != null) {
            helpDeskQueue.enqueue(s.getFullName() + " (" + studentId + ")");
            System.out.println("✅ " + s.getFullName() + " joined the Help Desk queue.");
        }
    }

    public void processHelpDesk() {
        if (!helpDeskQueue.isEmpty()) {
            System.out.println("🛠️ Help Desk now serving: " + helpDeskQueue.dequeue());
        } else {
            System.out.println("✅ Help Desk queue is empty.");
        }
    }

    public void displayAllStudents() {
        System.out.println("\n📋 ALL REGISTERED STUDENTS (" + allStudents.size() + "):");
        for (int i = 0; i < allStudents.size(); i++) {
            Student s = allStudents.get(i);
            System.out.printf("%-15s | %-25s | Room %s%n",
                    s.getStudentId(), s.getFullName(), s.getHostelRoom());
        }
    }
}
