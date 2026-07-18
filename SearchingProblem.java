// PROBLEM: Make a Linked List & add the following elements: (1, 5, 7, 3, 8, 2, 3). 
// Search for the number 7 & display its index.

public class SearchingProblem {
    Node HEAD;

    public class Node {
        int data;
        Node next;
    
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add a new element at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = HEAD;
        HEAD = newNode;
    }

    // Method to traverse and print the Linked List
    public void printlist() {
        Node currNode = HEAD;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // Method to search for a key and return its index
    public int Search(int key) {
        Node currNode = HEAD;
        // Counter to track the current position   
        int index = 0; 

        while (currNode != null) {
            // Check if the current node's data matches the search key
            if (currNode.data == key) {
                return index; 
            }
            // Move to the next node
            currNode = currNode.next; 
            // Increment the index counter
            index++;                  
        }
        // Return -1 if the key is not present in the list
        return -1; 
    }

    public static void main(String[] args) {
        SearchingProblem list = new SearchingProblem();

        // Adding elements to the list
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(8);
        list.addFirst(3);
        list.addFirst(7);
        list.addFirst(5);
        list.addFirst(1);

        System.out.print("Original List : ");
        list.printlist();

        // Perform the search operation
        int index = list.Search(7);
        if(index != -1) {
            System.out.println("Number 7 found at index: " + index);
        } 
        else {
            System.out.println("Number 7 not found.");
        }
    }  
}