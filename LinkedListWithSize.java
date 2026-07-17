// File Name: LinkedListWithSize.java

public class LinkedListWithSize {
    Node HEAD;
    private int size; // Variable to keep track of the number of nodes

    LinkedListWithSize() {
        this.size = 0; // Initialize size to 0 when the list is created
    }

    // Node class structure
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++; // Increment size whenever a new node is created
        }
    }
    
    // Add element at the beginning
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(HEAD == null) {
            HEAD = newNode;
            return;
        }
        newNode.next = HEAD;
        HEAD = newNode;
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
        System.out.println("NULL");
    }

    // Method to return the current size of the list
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListWithSize list = new LinkedListWithSize();
        
        list.addFirst("Wednesday");
        list.addFirst("Tuesday");
        list.addFirst("Monday"); 
        list.addFirst("Sunday");
        
        System.out.print("Original List: ");
        list.printList();

        System.out.println("The size of a list : " + list.getSize());
    }
}