package LinkList;


// time: O(N)  space: O(1)
public class detectCycle {
     class ListNode{
         int val;
         ListNode next;
         ListNode(int x){
             val = x;
             next = null;
         }
     }
    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode slow2 = head;
                while(slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}