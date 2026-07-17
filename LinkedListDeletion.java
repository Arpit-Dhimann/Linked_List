public class LinkedListDeletion {
    Node HEAD;

    // Node class structure: Represents each element in the list
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Add element at the beginning: O(1) time complexity
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(HEAD == null) {
            HEAD = newNode;
            return;
        }
        newNode.next = HEAD;
        HEAD = newNode;
    } 

    // Traverse and print the list: O(n) time complexity
    public void printList(){
        if (HEAD == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = HEAD;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    // Delete at First: Move HEAD pointer to the next node
    public void deleteFirst() {
        if (HEAD == null) {
            System.out.println("The list is empty.");
            return;
        }
        HEAD = HEAD.next;
    }
    
    // Delete at Last: Traverse to second-last node and make its next null
    public void deleteLast() {
        if (HEAD == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Case: Only one node exists
        if (HEAD.next == null) {
            HEAD = null;
            return;
        }

        // Traverse using two pointers: secondLast and lastNode
        Node secondLast = HEAD;
        Node lastNode = HEAD.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        // Break the link to the last node
        secondLast.next = null;
    }

    public static void main(String[] args) {
        LinkedListDeletion list = new LinkedListDeletion();
        
        // Changing inputs to represent a process flow
        list.addFirst("Deploy");
        list.addFirst("Test");
        list.addFirst("Build"); 
        list.addFirst("Code");
        
        System.out.print("Original List: ");
        list.printList(); // Expected: Code -> Build -> Test -> Deploy -> NULL

        // Perform deletion operations
        list.deleteFirst();
        System.out.print("After deleting first (Code): ");
        list.printList();

        list.deleteLast();
        System.out.print("After deleting last (Deploy): ");
        list.printList();
    }
}