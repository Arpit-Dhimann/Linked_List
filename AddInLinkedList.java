public class AddInLinkedList {
    Node HEAD;

    // Node class structure
    class Node {
        String data;
        Node next;

        // Constructor to initialize node data
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Add element at the beginning of the list
    public void addFirst(String data) {
        Node newNode = new Node(data);
        // If list is empty, new node becomes the HEAD
        if(HEAD == null) {
            HEAD = newNode;
            return;
        }

        // Link new node to current HEAD and update HEAD
        newNode.next = HEAD;
        HEAD = newNode;
    } 

    // Add element at the end of the list
    public void addLast(String data) {
        Node newNode = new Node(data);
        // If list is empty, new node becomes the HEAD
        if (HEAD == null) {
            HEAD = newNode;
            return;
        }

        // Traverse to the last node
        Node currNode = HEAD;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        // Attach new node at the end
        currNode.next = newNode; 
    } 

    // Traverse and print the list
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
            
        System.out.print("NULL");
        System.out.println();
    }
     
    // Main method to test operations
    public static void main(String[] args) {
        AddInLinkedList list = new AddInLinkedList();
        
        // Changing inputs to test order
        list.addFirst("Java"); 
        list.addFirst("Learning");
        list.printList(); // Output: Learning -> Java -> NULL

        list.addLast("is");
        list.addLast("Fun!");
        list.printList(); // Output: Learning -> Java -> is -> Fun! -> NULL
    }
}