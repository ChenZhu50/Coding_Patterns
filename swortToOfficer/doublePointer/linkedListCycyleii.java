package doublePointer;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class linkedListCycyleii {
    public static void main(String[] args) {
        // Example: 3 -> 2 -> 0 -> -4, pos = 1 (cycle at node with value 2)
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle here

        ListNode cycleStart = detectCycle(head);
        System.out.println("Cycle starts at node with value: " + (cycleStart != null ? cycleStart.val : "null"));
    }

    public static ListNode detectCycle(ListNode head) {
        // TODO: Implement the solution for LeetCode 142 here
        //use two pointers to find the cycle
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
