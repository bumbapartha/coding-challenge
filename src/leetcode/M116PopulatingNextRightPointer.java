package leetcode;

public class M116PopulatingNextRightPointer {

}


//Definition for a Node.
class Node {
 public int val;
 public Node left;
 public Node right;
 public Node next;

 public Node() {}
 
 public Node(int _val) {
     val = _val;
 }

 public Node(int _val, Node _left, Node _right, Node _next) {
     val = _val;
     left = _left;
     right = _right;
     next = _next;
 }
};

class M116Solution {
 public Node connect(Node root) {
	 Node temp = root;

     if(temp == null) {
         return null;
     }
     else if(temp.left == null ){
         return temp;
     }
     else if(temp.left != null) {
         temp.left.next = temp.right;
         Node firstLeft = temp.left;
         Node firstRight = temp.right;
         firstLeft.next = firstRight;
         while(firstLeft.right != null)  {
             firstLeft = firstLeft.right;
             firstRight = firstRight.left;
             firstLeft.next = firstRight;
         }
         connect(temp.left);
         connect(temp.right);
     }
     return root;
 }
}