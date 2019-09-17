package LinkList;

// 1,2,3,4 => 3.  1,2,3,4,5 => 3  -> slow,fast起始点靠后。
//head :   [1,2,3,4,5]
// slow     |
// fast     |

// time: O(N)  space: O(1)
public class middleNode{
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode middleNode(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next == null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}