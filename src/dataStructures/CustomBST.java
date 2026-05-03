package dataStructures;
import models.Student;
import tools.Utility;

public class CustomBST {
      Utility tool = new Utility();
    //tree ---> the actual Node(have student, left and right)

    private static class Node {
        Student data;
        Node left, right;
        Node(Student data) { this.data = data; }
    }
    private Node rootNode;



    public void insert(Student student) {
        rootNode = insertRec(rootNode, student);
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
        IO.readln("Confirm Search For: "+name.concat("..."));

        Node result = searchRec(rootNode, name);
        if (result != null) {
            System.out.println("Found: " + result.data);
        } else {
            System.out.println("Student not found.");
        }
    }

    private Node searchRec(Node node, String name) {
        if (node == null) return null;

        int stringComparisonValue = name.compareToIgnoreCase(node.data.getFullName());
        if (stringComparisonValue == 0) return node;
        return stringComparisonValue < 0 ? searchRec(node.left, name) : searchRec(node.right, name);

    }

    public void inorderDisplay() {
        tool.heading("Students sorted by Name");
        inorderRec(rootNode);
        tool.enterToContinue();
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
           IO.println(node.data);
            inorderRec(node.right);
        }
    }
}