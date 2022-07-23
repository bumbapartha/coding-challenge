package leetcode;

public class M148SortLinkedList {
    public static void main(String[] args) {
        M148SortLinkedList obj = new M148SortLinkedList();
        obj.run();
    }

    void run() {
        Solution solution = new Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);
        ListNode result = solution.sortList(head);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode sortList(ListNode head) {
            ListNode result = mergeSort(head);
            return result;
        }

        private ListNode mergeSort(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode middle = head;
            ListNode tail = head;
            ListNode prevMiddle = middle;
            while (tail != null && tail.next != null) {
                tail = tail.next.next;
                prevMiddle = middle;
                middle = middle.next;
            }
            prevMiddle.next = null;
            ListNode left = mergeSort(head);
            ListNode right = mergeSort(middle);
            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode head = null;
            ListNode result = null;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    if(result == null){
                        head = left;
                        left = left.next;
                        result = head;
                    }
                    else {
                        result.next = left;
                        left = left.next;
                        result = result.next;
                    }
                } else {
                    if(result == null){
                        head = right;
                        right = right.next;
                        result = head;
                    }
                    else {
                        result.next = right;
                        right = right.next;
                        result = result.next;
                    }
                }
            }
            if (left != null) {
                result.next = left;
            }
            if (right != null) {
                result.next = right;
            }
            return head;
        }

    }


}
