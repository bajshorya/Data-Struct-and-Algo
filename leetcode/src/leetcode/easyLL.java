// public class easyLinkedList {
//     public static void deleteNode(ListNode node) {
//         node.val = node.next.val;
//         node.next = node.next.next;
//     }
// }
public class easyLL {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move both previous and current pointers forward
                prev = curr;
            }
            curr = curr.next;
        }
        
        // Return the new head (after the dummy node)
        return dummy.next;
        }
    public static void main(String[] args) {
        
    }
}

