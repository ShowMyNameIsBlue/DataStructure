package LeetCode;


public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return null;
        head.next = removeElements(head.next,val);
        return head.val == val? head.next: head;

    }

    public ListNode middleNode(ListNode head) {

//        int i = 1;
//        ListNode  cur = head;
//        while(cur.next!=null){
//            i++;
//            cur =cur.next;
//        }
//        for(int j = 1 ; j<(i/2+1);j++){
//            if(head.next!=null)
//                head = head.next;
//            else
//                break;
//        }
//        return head;
        //快慢指针；
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //翻转链表
    public ListNode reverse(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode next = head.next;
        head.next = null;
        ListNode reverse = reverse(next);
        next.next = head;
        return reverse;
    }

    //判断回文链表
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null)
            return true;
        ListNode cur = head;
        System.out.println(cur);
        head= reverse(cur);
        System.out.println(head);
        while(head!=null&&cur!=null){
            if(cur.val!=head.val)
                return false;
            cur = cur.next;
            head = head.next;
        }
        return true;

    }


    //返回两链表相交节点；
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA  = pA == null ? headB : pA.next;
            pB  = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
