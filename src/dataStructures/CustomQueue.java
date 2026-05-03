package dataStructures;

import tools.Utility;

public class CustomQueue {
    Utility tools = new Utility();

    private static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }
    private Node front, rear;
    public void enqueue(String ticket) {
        Node newNode = new Node(ticket);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue() {
        if (front == null) return null;
        String data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public void displayHelpDesk() {

        tools.heading("QUEUED HELP DESK TASKS");
        Node curr = front;
        int i = 1;
        while (curr != null) {
            IO.println(i++ + ". " + curr.data);
            curr = curr.next;
        }
    }
}