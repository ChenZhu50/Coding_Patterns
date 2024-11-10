public class Solution {

    // Definition of a linked list node
    static class LinkedListNode {
        public int data;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Utility class to handle linked list operations
    static class MyLinkedList {
        public LinkedListNode head;

        // Method to create a linked list from an array
        public void createLinkedList(Integer[] values) {
            if (values.length == 0)
                return;
            this.head = new LinkedListNode(values[0]);
            LinkedListNode current = this.head;
            for (int i = 1; i < values.length; i++) {
                current.next = new LinkedListNode(values[i]);
                current = current.next;
            }
        }

        // Method to print the list
        public void printListWithForwardArrow() {
            LinkedListNode current = this.head;
            while (current != null) {
                System.out.print(current.data + (current.next != null ? " -> " : ""));
                current = current.next;
            }
        }
    }

    /*
     * 1. 通过快慢指针找到这个linklist的middle point
     * 2. 此时快指针在linklist的结尾，转换middle point之后的link list的方向
     * 3. 初始化max_sum = 0 来记录最大的twin sum
     * 4. 初始化curr 指向link的头部，此时的prev应该就是这个revers之后的尾巴
     * 5. 遍历，记录
     * 6. 返回
     */
    public static int twinSum(LinkedListNode head) {
        int max_sum = 0;
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // 寻找middle point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时你的fast应该在结尾，slow在中间(结尾指的是最后一个node，不是null，因为你的循环不会到null)

        LinkedListNode curr = slow;
        LinkedListNode prev = null; // 用于反转我们的linklist

        //反转我们的linklist
        while(curr != null){
            //你的temp一定是在里面的，因为要无限的更新，直到你的curr = null
            //但当你curr = null的时候，你的temp因为要在循环内更新，所以也会在null停下，而不会导致out of index的问题
            LinkedListNode temp = curr.next;
            curr.next = prev; //更换指针指向
            prev = curr; //将prev移动到prev，但是此时你的curr的next指针已经更新到了prev，所以无法再用prev = prev.next的方法了
            curr = temp; //此时你的之前的temp就保存了更改指向前的下一个节点
        }

        curr = head; // 重置到头部准备算max

        //你的中点只会被curr指到，因为之前的切割办法，会在1/2 +1 的地方停下（因为fast会指向null）
        while(prev != null){ 
            max_sum = Math.max(max_sum, curr.data + prev.data);
            prev = prev.next;
            curr = curr.next;
        }

        return max_sum;
    }

    public static void main(String[] args) {
        Integer[][] lists = {
                { 2, 3, 5, 7 },
                { 81, 144, 64, 121, 25, 49 },
                { 4, 5, 6, 7 },
                { 1, 1000 },
                { 11, 77, 44, 99, 22, 66, 55, 88 }
        };

        for (int i = 0; i < lists.length; ++i) {
            MyLinkedList inputLinkedList = new MyLinkedList();
            inputLinkedList.createLinkedList(lists[i]);
            System.out.print((i + 1) + ".\tLinked list: ");
            inputLinkedList.printListWithForwardArrow();
            System.out.println("\tMaximum twin sum: " + twinSum(inputLinkedList.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
