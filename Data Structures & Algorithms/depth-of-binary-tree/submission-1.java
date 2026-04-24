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
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        Stack<Pair<TreeNode,Integer>>stack = new Stack();
        stack.push(new Pair(root,1));
        int ans = 0;
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer>p = stack.pop();
            TreeNode node = p.getKey();
            Integer depth = p.getValue();
            if(node != null){
                ans = Math.max(ans, depth);
                stack.push(new Pair(node.left, depth+1));
                stack.push(new Pair(node.right, depth+1));
            }
        }
        return ans;
    }
}
