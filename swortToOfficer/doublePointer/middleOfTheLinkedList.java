package doublePointer;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class middleOfTheLinkedList {
    public static void main(String[] args) {
        // Example: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(5))))) ;

        ListNode middle = middleNode(head);
        System.out.println("Middle node value: " + (middle != null ? middle.val : "null"));
    }

    // Placeholder for the solution
    public static ListNode middleNode(ListNode head) {
        //use two pointers to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
