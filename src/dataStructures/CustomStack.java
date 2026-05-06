package dataStructures;

import tools.Utility;

public class CustomStack {
    Utility tool = new Utility();
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
        tool.heading("RECENT ACTIVITIES - SYSTEM LOGS ");
        Node curr = top;
        int i = 1;
        while (curr != null) {
            IO.println(i++ + ". " + curr.activity);
            curr = curr.next;
        }
    }
}