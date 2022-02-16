package leetcode;

import leetcode.models.TreeNode;

public class E617MergeTwoBinaryTrees {

}

 
class E617Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return traverseAndMerge(root1, root2);
    }
    
    TreeNode traverseAndMerge(TreeNode root1, TreeNode root2){
        if(root1!= null && root2!= null){
            TreeNode temp = new TreeNode(root1.val+root2.val);
            temp.left = traverseAndMerge(root1.left, root2.left);
            temp.right = traverseAndMerge(root1.right, root2.right);
            return temp;
        }
        else if(root1 !=null && root2 == null){
            return root1;
        }
        else if(root1 ==null && root2 != null){
            return root2;
        }
        else if(root1 ==null && root2 == null){
            return null;
        }
        return null;
    }
}