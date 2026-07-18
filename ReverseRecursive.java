public class ReverseRecursive {
    Node HEAD;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Appends a new node to the end of the list.
     * Time Complexity: O(n)
     */
    public void addLast(int data) {
        Node newNode = new Node(data);
        // If the list is empty, the new node becomes the head
        if (HEAD == null) {
            HEAD = newNode;
            return;
        }

        // Traverse to the end of the list
        Node currNode = HEAD;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        // Link the last node to the new node
        currNode.next = newNode; 
    } 

    
    // Reverses the linked list using recursion.
    public Node reverseListRecursive(Node head) {
       // Base case: If list is empty or reaches the last node, return current node
       if(head == null || head.next == null) {
           return head;
        }

       // Recursive call to reach the end of the list
       Node newHead = reverseListRecursive(head.next);
      
       // Make the next node point back to the current node
       head.next.next = head;
       // Set the current node's next to null (avoids cycles)
       head.next = null;
       
       return newHead;
    }

    public void printList() {
        Node currNode = HEAD;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseRecursive list = new ReverseRecursive();
        list.addLast(00);
        list.addLast(11);
        list.addLast(22);
        list.addLast(33);
        list.addLast(44);
        list.addLast(55);
        
        System.out.print("Before reversing : ");
        list.printList();

        // Perform recursive reversal and update the HEAD
        System.out.print("After reversing : ");
        list.HEAD = list.reverseListRecursive(list.HEAD);
        list.printList();
    }
}