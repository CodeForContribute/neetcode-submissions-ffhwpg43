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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new ArrayList();
        List<Integer>result = new ArrayList();
        Queue<TreeNode>q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode rightSide = null;
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();
                if(node != null){
                    rightSide = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(rightSide != null){
                result.add(rightSide.val);
            }
        }
        return result;
    }
}
