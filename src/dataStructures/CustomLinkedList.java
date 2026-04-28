package dataStructures;
import models.Student;

public class CustomLinkedList {
    private Node head;
    private int size = 0;

    private static class Node {
        Student data;
        Node next;
        Node(Student data) { this.data = data; }
    }

    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        size++;
    }

    public void displayAll() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                  ALL REGISTERED STUDENTS");
        System.out.println("=".repeat(70));
        System.out.printf("%-28s | %-12s | %s%n", "Full Name", "Student ID", "Residence");
        System.out.println("-".repeat(70));

        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println("-".repeat(70));
        System.out.println("Total Students: " + size);
    }

    public int size() { return size; }
}