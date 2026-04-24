/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        isBalancedUtil(root);
        return ans;
    }
    private int isBalancedUtil(TreeNode root){
        if(root == null)return 0;
        int leftHeight = isBalancedUtil(root.left);
        int rightHeight = isBalancedUtil(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)ans = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

