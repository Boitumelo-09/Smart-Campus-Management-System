package dataStructures;

import models.Student;

public class CustomBST {
    private Node root;

    private static class Node {
        Student data;
        Node left, right;
        Node(Student data) { this.data = data; }
    }

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node node, Student student) {
        if (node == null) return new Node(student);

        if (student.getFullName().compareToIgnoreCase(node.data.getFullName()) < 0) {
            node.left = insertRec(node.left, student);
        } else {
            node.right = insertRec(node.right, student);
        }
        return node;
    }

    public void searchByName(String name) {
        System.out.println("\nSearching for: " + name);
        Node result = searchRec(root, name);
        if (result != null) {
            System.out.println("Found: " + result.data);
        } else {
            System.out.println("Student not found.");
        }
    }

    private Node searchRec(Node node, String name) {
        if (node == null) return null;

        int cmp = name.compareToIgnoreCase(node.data.getFullName());
        if (cmp == 0) return node;
        return cmp < 0 ? searchRec(node.left, name) : searchRec(node.right, name);
    }

    public void inorderDisplay() {
        System.out.println("\nStudents sorted by Name :");
        inorderRec(root);
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(node.data);
            inorderRec(node.right);
        }
    }
}