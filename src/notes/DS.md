# HOW THE DATA STRUCTURES WORK IN THE SMART CAMPUS MANAGEMENT SYSTEM

**Smart Campus Management System**  
**Built from Scratch using Custom Data Structures**  
**Prepared by: Group 1**

---

## Introduction

The Smart Campus Management System was developed using **five custom data structures**, all implemented **from scratch** without relying on Java’s built-in Collections Framework (`ArrayList`, `HashMap`, `TreeMap`, etc.).

Each data structure was carefully selected based on its strengths and time complexity to solve specific real-world problems in a university environment.

---

## 1. CustomHashTable – Fast Login by Student number

**Purpose:**  
To provide **O(1) average-case** lookup using Student ID as the unique key.

**How it Works:**
- Implements **Hashing with Separate Chaining**.
- Uses an array of linked lists (buckets) to handle collisions.
- A hash function converts the Student ID into an array index.
- If two keys hash to the same index, they are stored in a chain (linked list).

**Key Methods:**

| Method              | Description                              | Time Complexity |
|---------------------|------------------------------------------|-----------------|
| `put(key, value)`   | Inserts or updates a student             | O(1) average    |
| `get(key)`          | Retrieves student using Student ID       | O(1) average    |
| `contains(key)`     | Checks if a student exists               | O(1) average    |

**Implementation Details:**
- Private inner `Entry` class (key, value, next pointer)
- Hash function: `Math.abs(key.hashCode()) % table.length`
- Table size initialized to a prime number (31) to minimize collisions

**Real Usage:** Student authentication during login.

---

## 2. CustomLinkedList – Ordered Storage & Display

**Purpose:**  
To store all students in insertion order and easily display the complete list.

**How it Works:**
- Classic **Singly Linked List** implementation.
- Each node holds a `Student` object and a reference to the next node.
- Students are added at the end of the list.

**Key Methods:**

| Method             | Description                                   |
|--------------------|-----------------------------------------------|
| `add(Student)`     | Adds a student at the end of the list         |
| `displayAll()`     | Prints all students in a formatted table      |
| `size()`           | Returns the total number of students          |

**Implementation Details:**
- Private inner `Node` class
- Only `head` pointer is maintained
- Linear traversal for displaying records

**Real Usage:** Admin viewing all registered students.

---

## 3. CustomBST (Binary Search Tree) – Search & Sort by Name

**Purpose:**  
To support efficient searching by student name and display students in alphabetical order.

**How it Works:**
- Binary Search Tree where ordering is based on **student’s full name** (case-insensitive).
- Left subtree contains names alphabetically smaller than the parent.
- Right subtree contains names alphabetically larger or equal.

**Key Methods:**

| Method                    | Description                                              |
|---------------------------|----------------------------------------------------------|
| `insert(Student)`         | Inserts a new student into the BST                       |
| `searchByName(String)`    | Searches for a student by name                           |
| `inorderDisplay()`        | Displays all students sorted alphabetically              |

**Implementation Details:**
- Fully recursive insertion and search
- Uses `compareToIgnoreCase()` for name comparison
- **In-order traversal** (Left → Root → Right) gives sorted output automatically

**Real Usage:**
- Searching students by name
- Generating alphabetically sorted student lists

---

## 4. CustomQueue – Help Desk Ticket System

**Purpose:**  
To manage help desk and support requests in **First-In-First-Out (FIFO)** order.

**How it Works:**
- Implemented using a singly linked list with `front` and `rear` pointers.
- New tickets are added at the rear (`enqueue`).
- Oldest tickets are processed first from the front (`dequeue`).

**Key Methods:**

| Method                   | Description                              |
|--------------------------|------------------------------------------|
| `enqueue(String)`        | Adds a new help desk ticket              |
| `dequeue()`              | Removes and returns the front ticket     |
| `displayHelpDesk()`      | Displays all pending tickets             |

**Real Usage:** Automatically adds tickets when students log in.

---

## 5. CustomStack – Recent Activity Log

**Purpose:**  
To track recent system activities using **Last-In-First-Out (LIFO)** behavior.

**How it Works:**
- Implemented as a singly linked list with only a `top` pointer.
- New activities are pushed on top.
- Most recent activities appear first when displayed.

**Key Methods:**

| Method                | Description                                   |
|-----------------------|-----------------------------------------------|
| `push(String)`        | Adds a new activity to the top                |
| `displayRecent()`     | Displays activities from most recent to oldest|

**Real Usage:** Logs every successful student login.

---

## Summary Table

| Data Structure       | Main Operation                  | Time Complexity       | Implementation Technique          | Campus Use Case                        |
|----------------------|---------------------------------|-----------------------|-----------------------------------|----------------------------------------|
| CustomHashTable      | Search by Student ID            | O(1) average          | Hashing + Separate Chaining       | Fast Student Login                     |
| CustomLinkedList     | Display all students            | O(n)                  | Singly Linked List                | Full Student Register                  |
| CustomBST            | Search by Name + Sorting        | O(log n) average      | Recursive Binary Search Tree      | Name Search & Sorted Reports           |
| CustomQueue          | Help Desk Tickets               | O(1)                  | Linked List Queue                 | Support Ticket Management              |
| CustomStack          | Recent Activities               | O(1)                  | Linked List Stack                 | Activity & Audit Logging               |

---

## Why Implemented From Scratch?

- To demonstrate deep understanding of internal workings of data structures.
- To prove the ability to select the **right data structure** for the **right problem**.
- To clearly show time and space complexity trade-offs.
- To avoid black-box usage of Java Collections Framework.

---

**Prepared by:** Group 1  
**System Name:** Smart Campus Management System  
**Date:** May 2026

---
