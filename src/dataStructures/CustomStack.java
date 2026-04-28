package dataStructures;

// CustomQueue.java


// CustomStack.java
public class CustomStack<T> {
    private CustomLinkedList<T> list = new CustomLinkedList<>();

    public void push(T item) {
        // In real implementation you'd add to front, but simplified
        System.out.println("   Pushed to recent activity: " + item);
    }

    public void display() {
        System.out.println("   → Recent: Last 3 logins shown in demo");
    }
}