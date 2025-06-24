package doublePointer;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class intersection_of_two_linked_list {
    public static void main(String[] args) {
        // Create common part: 8 -> 9 -> 10
        ListNode common = new ListNode(8, new ListNode(9, new ListNode(10)));
        // First list: 1 -> 2 -> 3 -> 8 -> 9 -> 10
        ListNode head = new ListNode(1,
            new ListNode(2,
                new ListNode(3, common)));
        // Second list: 6 -> 7 -> 8 -> 9 -> 10 (intersects at 8)
        ListNode head2 = new ListNode(6,
            new ListNode(7, common));
        ListNode intersection = getIntersectionNode(head, head2);
        System.out.println("Intersection node value: " + (intersection != null ? intersection.val : "null"));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //TODO: implement the logic to find the intersection of two linked lists

        //checking edge case
        if(headA == null || headB == null) {
            return null;
        }

        //create two ListNode to store the head of two linked lists
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {
            if(p1 == null) {
                p1 = headB;
            }else{
                p1 = p1.next;
            }
            if(p2 == null) {
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
        return p1;
    }
}


