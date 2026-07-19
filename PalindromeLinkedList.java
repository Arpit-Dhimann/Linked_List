/*PROBLEM : Palindrome Linked List. Given the head of a singly linked list, 
            return true if it is a palindrome, or false otherwise.

            Example:
            Input: head = [1, 2, 2, 1]
            Output: true

            Logic: 
            1. Find the middle node.
            2. Reverse the second half of the list.
            3. Compare the first half and reversed second half.
 */

public class PalindromeLinkedList {

    // Definition for singly-linked list node
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // Helper method to find the middle of the Linked List using slow/fast pointers
    public Node getMiddle(Node HEAD) {
        Node fast = HEAD;
        Node slow = HEAD;
        // Move fast by 2 steps and slow by 1 step
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; // Returns the middle node
    }

    // Helper method to reverse a Linked List
    public Node reverse(Node HEAD) {
        Node prev = null;
        Node curr = HEAD;

        while (curr != null) {
            Node next = curr.next; // Store next node
            curr.next = prev;         // Reverse the link
            prev = curr;              // Move prev forward
            curr = next;              // Move curr forward
        }
        return prev; // Returns the new head
    }

    // Main logic to check if the Linked List is a Palindrome
    public boolean isPalindrome(Node HEAD) {
        if (HEAD == null || HEAD.next == null) {
            return true;
        }

        // 1. Find the middle of the list
        Node firstHalfEnd = getMiddle(HEAD);
        
        // 2. Reverse the second half of the list
        Node secondHalfStart = reverse(firstHalfEnd.next);
        
        // 3. Compare the first half and the reversed second half
        Node firstHalfStart = HEAD;
        while (secondHalfStart != null) {
            if (secondHalfStart.val != firstHalfStart.val) {
                return false; // Not a palindrome
            }
            secondHalfStart = secondHalfStart.next;
            firstHalfStart = firstHalfStart.next;
        }

        return true; // Is a palindrome
    }

    public static void main(String[] args) {
        // Creating a sample palindrome list: 1 -> 2 -> 2 -> 1 -> NULL
        Node HEAD = new Node(1);
        HEAD.next = new Node(2);
        HEAD.next.next = new Node(2);
        HEAD.next.next.next = new Node(1);

        PalindromeLinkedList solution = new PalindromeLinkedList();
        
        if (solution.isPalindrome(HEAD)) {
            System.out.println("The list is a Palindrome.");
        } else {
            System.out.println("The list is NOT a Palindrome.");
        }
    }
}