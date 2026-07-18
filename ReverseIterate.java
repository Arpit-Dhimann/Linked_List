public class ReverseIterate {
    Node HEAD;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (HEAD == null) {
            HEAD = newNode;
            return;
        }

        newNode.next = HEAD;
        HEAD = newNode;
    }

    //ITERATIVE WAY TO REVERSE LIST
    public void reverseIterate() {
        if (HEAD == null || HEAD.next == null) {
            return;
        }

        Node prevNode = HEAD;
        Node currNode = HEAD.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;            
        }
        HEAD.next = null;
        HEAD = prevNode;
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