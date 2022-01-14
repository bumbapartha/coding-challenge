package leetcode;

public class E206ReverseLinkedList {
	
	
	/**
	 * Definition for singly-linked list.
	 */
	 class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	class Solution {
	    public ListNode reverseList(ListNode node) {
	        if(node == null){
	            return null;
	        }
	        
	        ListNode tailTracker = new ListNode();
	        reverse(node, tailTracker);
	        node.next = null;
	        return tailTracker.next;
	    }
	    
	    public ListNode reverse(ListNode current, ListNode tailTracker ) {
	        if(current.next == null){
	            tailTracker.next = current;
	            return current;
	        }
	        ListNode temp = reverse(current.next, tailTracker);
	        temp.next = current;
	        return current;
	    }
	}
	
	public static void main(String[] args) {
		Solution reverseList = new E206ReverseLinkedList().new Solution();
		reverseList.reverseList(null);
	}

}
