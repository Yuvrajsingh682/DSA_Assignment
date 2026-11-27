// Node class representing each element in the Singly Linked List
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Custom Stack class implemented using Singly Linked List
class Stack {
    private Node top;
    private int count;

    public Stack() {
        this.top = null;
        this.count = 0;
    }

    // Insert an element at the top of the Stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        count++;
        System.out.println(data + " inserted");
    }

    // Remove and return the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int poppedValue = top.data;
        top = top.next;
        count--;
        System.out.println(poppedValue + " removed");
        return poppedValue;
    }

    // Return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Check whether the Stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Return the total number of elements in the Stack
    public int size() {
        return count;
    }

    // Display all elements from top to bottom
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Helper for Challenge 4: Find middle element using slow/fast pointers
    public int findMiddle() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        Node slow = top;
        Node fast = top;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}

// Main class to test the Sample Test Case
public class StackImplementation {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();                       // Expected: 30 -> 20 -> 10
        System.out.println(stack.peek());      // Expected: 30

        stack.pop();                           // Expected: 30 removed
        stack.display();                       // Expected: 20 -> 10

        System.out.println(stack.size());      // Expected: 2
        System.out.println(stack.isEmpty());   // Expected: false

        stack.pop();                           // Expected: 20 removed
        stack.pop();                           // Expected: 10 removed

        System.out.println(stack.isEmpty());   // Expected: true
        stack.pop();                           // Expected: Stack Underflow
    }
}