package dataStructures;

public class CustomStack {
    private Node top;

    private static class Node {
        String activity;
        Node next;
        Node(String activity) { this.activity = activity; }
    }

    public void push(String activity) {
        Node newNode = new Node(activity);
        newNode.next = top;
        top = newNode;
    }

    public void displayRecent() {
        System.out.println("\n    STACKED RECENT ACTIVITIES     ");
        Node curr = top;
        int i = 1;
        while (curr != null) {
            System.out.println(i++ + ". " + curr.activity);
            curr = curr.next;
        }
    }
}