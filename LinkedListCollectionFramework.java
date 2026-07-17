import java.util.LinkedList;

public class LinkedListCollectionFramework {
    public static void main(String[] args) {
        // Created a LinkedList of strings
        LinkedList<String> list = new LinkedList<>();

        // Adding elements to the beginning of the list
        list.addFirst("Java");
        list.addFirst("Learning");
        list.addFirst("Started");
        
        System.out.println("Initial List: " + list);
        
        // Adding an element at index 2
        list.add(2, "with");
        System.out.println("Updated List: " + list);

        // Deleting the first element
        list.removeFirst();
        System.out.println("After removeFirst: " + list);

        // Deleting the last element
        list.removeLast();
        System.out.println("After removeLast: " + list);
        
        // Getting the current size of the list
        System.out.println("Final size of the list: " + list.size());
    }
}