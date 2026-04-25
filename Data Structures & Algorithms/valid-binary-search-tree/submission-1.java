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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean valid(TreeNode root, int lower, int upper){
        if(root == null)return true;
        if(!(root.val > lower && root.val < upper))return false;
        return valid(root.left, lower, root.val) && valid(root.right,root.val, upper);
    }
}
