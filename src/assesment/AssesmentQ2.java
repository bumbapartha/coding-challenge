package assesment;

public class AssesmentQ2 {
	
	public static void main(String[] args) {
		//System.out.println(new AssesmentQ2().new Solution().addTwoNumbers(null, null));
	}
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int n1=0, n2=0, c=0;
	        ListNode head=null, temp = null;
	        while(true){
	        	n1 = 0;
	        	n2 = 0;
	            if(l1==null && l2==null && c==0){
	                break;
	            }
	            if(l1 != null){
	                n1 = l1.val;
	                l1 = l1.next;
	            }
	            if(l2 != null){
	                n2 = l2.val;
	                l2 = l2.next;
	            }
	            int r = n1+n2+c;
	            c = r / 10;
	            r = r % 10;
	            ListNode node = new ListNode(r);
	            if(head == null){
	                temp = node;
	                head = temp;
	            }
	            else {
	                temp.next = node;
	                temp = temp.next;
	            }
	        }
	        return head;
	    }
	}

}
