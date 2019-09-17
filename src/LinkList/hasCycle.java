package LinkList;


// // time: O(N)  space: O(1)
public class hasCycle{
     class ListNode{
         int val;
         ListNode next;
         ListNode(int x){
             val = x;
             next = null;
         }
     }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

// head = [3,2,0,-4], pos = 1
// slow    |
// fast    |