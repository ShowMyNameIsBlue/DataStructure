package LeetCode;


public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public ListNode(int[] arr){
            if (arr.length==0||arr == null){
                  throw new IllegalArgumentException("Array is Illegal");
            }

            this.val = arr[0];
            ListNode cur =  this;
            for (int i = 1; i <arr.length ; i++) {
                  cur.next = new ListNode(arr[i]);
                  cur = cur.next;
            }
      }
      @Override
      public String toString(){
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur!=null){
                  res.append(cur.val + "->");
                  cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
      }
}
