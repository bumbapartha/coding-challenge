package leetcode;

public class H23MergeKSortedLists {
    public static void main(String[] args) {
        H23MergeKSortedLists obj = new H23MergeKSortedLists();
        obj.run();
    }

    private void run() {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode result = solution.mergeKLists(new ListNode[]{n1, n2, n3});
        while (result != null){
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            return mergeKLists(lists, 0, lists.length);
        }

        public ListNode mergeKLists(ListNode[] lists, int left, int right) {
            if(left == right && left < lists.length){
                return lists[left];
            }
            else if(left < right){
                int mid = (left + right) / 2;
                ListNode leftResult = mergeKLists(lists, left, mid);
                ListNode rightResult = mergeKLists(lists, mid+1, right);
                return mergeTwoList(leftResult, rightResult);
            }
            else {
                return null;
            }
        }

        /*
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode result = null;
            for(int i=0; i< lists.length; i++){
                result = mergeTwoList(result, lists[i]);
            }
            return result;
        }
        */

        private ListNode mergeTwoList(ListNode left, ListNode right){
            if(left == null && right == null){
                return null;
            }
            else if(left == null){
                return right;
            }
            else if(right == null){
                return left;
            }
            else {
                ListNode head = null;
                ListNode result = head;
                while(left != null && right !=null){
                    if(left.val < right.val){
                        if(head == null){
                            head = left;
                            result = head;
                            left = left.next;
                        }
                        else {
                            result.next = left;
                            left = left.next;
                            result = result.next;
                        }
                    }
                    else {
                        if(head == null){
                            head = right;
                            result = head;
                            right = right.next;
                        }
                        else {
                            result.next = right;
                            right = right.next;
                            result = result.next;
                        }
                    }
                }
                if(left != null){
                    result.next = left;
                }
                if(right != null){
                    result.next = right;
                }
                return head;
            }
        }

    }
}
