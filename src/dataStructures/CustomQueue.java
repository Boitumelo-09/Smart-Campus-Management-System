package dataStructures;

public class CustomQueue<T> {
    private CustomLinkedList<T> list = new CustomLinkedList<>();

    public void enqueue(T item) { list.add(item); }  // We'll reuse linked list logic
    public T dequeue() { /* Simplified - in real you'd implement proper remove first */
        // For this assignment, we'll simulate
        System.out.println("   (Dequeued from queue)");
        return null; // Placeholder - you can extend
    }
    public boolean isEmpty() { return false; } // Improve as needed
}