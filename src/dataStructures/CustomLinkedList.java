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
        IO.println("\n" + "_".repeat(70));
        IO.println("                  ALL REGISTERED STUDENTS");
        IO.println("=".repeat(70));
        System.out.printf("%-28s | %-12s | %s%n", "Full Name", "Student No", "Residence");
        IO.println("-".repeat(70));

        Node curr = head;
        while (curr != null) {
            IO.println(curr.data);
            curr = curr.next;
        }
        IO.println("-".repeat(70));
        IO.println("Total Students: " + size);
    }

    public int size() { return size; }
}