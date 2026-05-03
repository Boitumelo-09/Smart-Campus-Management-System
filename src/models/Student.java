package models;

import lombok.Data;

@Data
public class Student {
    private final String fullName;
    private final String studentId;
    private final String pin;
    private final String residence;
    private final String[] modules = {"SMTA021", "SSTA021", "SCOA021", "SMTA022", "SSTA022", "SCOA022"};



//    public Student(String fullName, String studentId, String pin, String residence) {
//        this.fullName = fullName.trim();
//        this.studentId = studentId.trim();
//        this.pin = pin.trim();
//        this.residence = residence;
//
//    }

//    public String getFullName() { return fullName; }
//    public String getStudentId() { return studentId; }
//    public String getPin() { return pin; }
//    public String getResidence() { return residence; }
//    public String[] getModules() { return modules; }

   // @Override
//    public String toString() {
//        return String.format("%-28s | %-12s | %s", fullName, studentId, residence);
//    }
}