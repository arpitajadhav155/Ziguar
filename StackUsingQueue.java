import java.util.*;
public class StackUsingQueue {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public StackUsingQueue() {
        front = null;
        rear = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }

        int poppedValue = rear.data;

        if (front == rear) {
            front = null;
            rear = null;
        }
        else {
            Node current = front;
            while (current.next != rear) {
                current = current.next;
            }
            current.next = null;
            rear = current;
        }
        return poppedValue;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }

        return rear.data;
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void display()
    {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Node current = front;

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        Scanner sc = new Scanner(System.in);

        System.out.println("Stack using Queue");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Top");
        System.out.println("4. Display");
        System.out.println("5. Quit");

        boolean quit = false;

        while (!quit) {
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    int poppedElement = stack.pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;
                case 3:
                    int topElement = stack.top();
                    if (topElement != -1) {
                        System.out.println("Top element: " + topElement);
                    }
                    break;
                case 4: 
                    stack.display();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
