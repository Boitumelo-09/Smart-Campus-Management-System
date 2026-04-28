package models;

import dataStructures.CustomLinkedList;
import interfaces.Login;
import lombok.Data;
@Data
public class Student {
    private String studentId;
    private String fullName;
    private String hostelRoom;
    private CustomLinkedList<String> modules;

    public Student(String studentId, String fullName, String hostelRoom) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.hostelRoom = hostelRoom;
        this.modules = new CustomLinkedList<>();
        // Every student gets these core modules
        modules.add("SMTA021");
        modules.add("SSTA021");
        modules.add("SCOA021");
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getFullName() { return fullName; }
    public String getHostelRoom() { return hostelRoom; }
    public CustomLinkedList<String> getModules() { return modules; }

    public void displayInfo() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║              STUDENT PROFILE               ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.printf("║ Name      : %s%n", fullName);
        System.out.printf("║ Student ID: %s%n", studentId);
        System.out.printf("║ Hostel    : Room %s%n", hostelRoom);
        System.out.println("║ Modules   : SMTA021, SSTA021, SCOA021     ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}