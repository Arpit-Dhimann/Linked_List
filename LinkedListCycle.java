/*PROBLEM : Linked List Cycle. Given head, the head of a linked list, determine if the linked list 
            has a cycle in it. There is a cycle in a linked list if there is some node in the list 
            that can be reached again by continuously following the next pointer.
 
            Example:
            Input: head = [3,2,0,-4], pos = 1
            Output: true

            Logic: 
            -> Used Floyd's Cycle-Finding Algorithm (Slow and Fast pointers).
            -> If there is a cycle, the fast pointer will eventually meet the slow pointer.
*/

public class LinkedListCycle {

    // Definition for singly-linked list node
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public boolean hasCycle(Node HEAD) {
        // Initialize two pointers
        Node slow = HEAD;
        Node fast = HEAD;

        // Traverse the list: fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by 1
            fast = fast.next.next;  // Move fast pointer by 2

            // If fast and slow meet, there is a cycle
            if (fast == slow) {
                return true;
            }
        }

        // If fast reaches the end, there is no cycle
        return false;
    }

    public static void main(String[] args) {
        // Creating a sample list: 1 -> 2 -> 3 -> 4 -> (cycle back to 2)
        Node HEAD = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        HEAD.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creating a cycle here

        LinkedListCycle solution = new LinkedListCycle();

        if (solution.hasCycle(HEAD)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle detected.");
        }
    }
}