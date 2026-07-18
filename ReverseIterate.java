public class ReverseIterate {
    Node HEAD;

    // Node class representing each element in the Linked List
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to insert a new node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (HEAD == null) {
            HEAD = newNode;
            return;
        }

        newNode.next = HEAD;
        HEAD = newNode;
    }

    
    // Reverses the Linked List iteratively. 
    public void reverseIterate() {
        // If the list is empty or has only one node, no reversal needed
        if (HEAD == null || HEAD.next == null) {
            return;
        }

        Node prevNode = HEAD;
        Node currNode = HEAD.next;
        
        while (currNode != null) {
            Node nextNode = currNode.next; // Store reference to the next node
            currNode.next = prevNode;      // Reverse the current node's pointer

            // Move pointers one step forward
            prevNode = currNode;
            currNode = nextNode;            
        }
        
        // Finalize: Set original head's next to null and update head to the last node
        HEAD.next = null;
        HEAD = prevNode;
    }

    // Method to display the Linked List
    public void printList() {
        Node currNode = HEAD;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseIterate list = new ReverseIterate();
        list.addFirst(10);
        list.addFirst(8);
        list.addFirst(6);
        list.addFirst(4);
        list.addFirst(2);
        list.addFirst(0);
        
        System.out.print("Before reversing : ");
        list.printList();

        System.err.print("After reversing : ");
        list.reverseIterate();
        list.printList();
    }
}