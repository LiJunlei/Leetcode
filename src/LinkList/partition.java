package LinkList;
//                             h
// head    = 1->4->3->2->5->2
// sH      0 - 1 - 2 - 2
//                   s
// bH       0 - 4 - 3- 5
//                     b


public class partition {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0), bigHead = new ListNode(0);
        ListNode small = smallHead, big = bigHead;
        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        big.next = null;
        return smallHead.next;
    }
    public static void main(String[] arg){
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        System.out.println(partition(head, x));
    }
}
