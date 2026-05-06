package dataStructures;

import tools.Utility;

public class CustomQueue {
    Utility tools = new Utility();
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

    public String dequeue(int taskNumber) {
        if (front == null || taskNumber < 1) return null;

        if (taskNumber == 1) {
            String data = front.data;
            front = front.next;
            if (front == null) rear = null;
            return data;
        }

        Node previous = front;
        Node current = front.next;
        int currentNumber = 2;

        while (current != null && currentNumber < taskNumber) {
            previous = current;
            current = current.next;
            currentNumber++;
        }

        if (current == null) return null;

        String data = current.data;
        previous.next = current.next;

        if (current == rear) {
            rear = previous;
        }

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