//PROBLEM: Take elements(numbers in the range of 1-50) of a Linked List as input from the user. 
//         Delete all nodes which have values greater than 25.

import java.util.Scanner;

public class DeletionProblem {
    Node HEAD;

    // Node class structure
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add elements at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (HEAD == null) {
            HEAD = newNode;
            return;
        }
        Node currNode = HEAD;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // Logic to delete all nodes with values > 25
    public void deleteGreater25() {
        // Step 1: Remove nodes from HEAD if they are > 25
        while (HEAD != null && HEAD.data > 25) {
            HEAD = HEAD.next;
        }

        // Step 2: Remove nodes from the rest of the list
        Node currNode = HEAD;
        while (currNode != null && currNode.next != null) {
            if (currNode.next.data > 25) {
                // Skip the node by linking current to the next-next node
                currNode.next = currNode.next.next;
            } else {
                // Move to next node only if no deletion occurred
                currNode = currNode.next;
            }
        }
    }

    // Method to print the list
    public void printList() {
        Node currNode = HEAD;
        if (HEAD == null) {
            System.out.println("List is empty");
            return;
        }
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeletionProblem list = new DeletionProblem();

        System.out.println("--- Linked List Deletion (Nodes > 25) ---");
        System.out.println("Enter numbers between 1-50. Enter -1 to stop.");
        
        while (true) {
            System.out.print("Enter number: ");
            int val = sc.nextInt();
            
            if (val == -1) break;
            
            list.addLast(val);
        }

        System.out.println("\nOriginal List:");
        list.printList();

        // Perform the deletion
        list.deleteGreater25();

        System.out.println("After deleting nodes > 25:");
        list.printList();
        
        sc.close();
    }
}