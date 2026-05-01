package dataStructures;

public class CustomQueue {
    private Node front, rear;

    private static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

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
        System.out.println("\n   QUEUED HELP DESK TASKS    ");
        Node curr = front;
        int i = 1;
        while (curr != null) {
            System.out.println(i++ + ". " + curr.data);
            curr = curr.next;
        }
    }
}