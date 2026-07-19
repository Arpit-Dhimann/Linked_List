/*PROBLEM : Remove Nth Node From End of List. Given the head of a linked list, 
            remove the nth node from the end of the list and return its head.
 
            Example:
            Input: head = [1,2,3,4,5], n = 2
            Output: [1,2,3,5]
*/

public class RemoveNthNode {
    
    // Static nested class representing a node in the linked list
    static class Node {
        int val;
        Node next;

        Node(int val) { 
            this.val = val; 
        }
        
        Node(int val, Node next) { 
            this.val = val; 
            this.next = next; 
        }
    }
    
    // Function to remove the Nth node from the end
    public Node removeNthFromEnd(Node HEAD, int n) {
        // Base case: If the list is empty or has only one node
        if(HEAD.next == null) {
            return null;
        }
 
        // Step 1: Calculate the total size of the linked list
        int size = 0;
        Node temp = HEAD;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
 
        // Step 2: If n is equal to the size, the head node needs to be removed
        if(n == size) {
            return HEAD.next;
        }
 
        // Step 3: Traverse to the node just before the one that needs to be removed
        int ptf = size - n; // Position to find
        Node prev = HEAD; 
        int cp = 1; // Current position
 
        while(cp != ptf) {
            prev = prev.next;
            cp++;
        }
 
        // Step 4: Remove the target node by skipping it
        prev.next = prev.next.next;
        return HEAD;
    }

    // Helper method to traverse and print the linked list
    public static void printList(Node HEAD) {
        Node curr = HEAD;
        while(curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        RemoveNthNode sol = new RemoveNthNode();
        
        System.out.print("Original List: ");
        printList(head);

        // Deleting the 2nd node from the end (which is node with value 4)
        head = sol.removeNthFromEnd(head, 2);

        System.out.print("Updated List: ");
        printList(head);
    }
}