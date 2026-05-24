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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList();
        List<List<Integer>>result = new ArrayList();
        Queue<TreeNode>q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer>level = new ArrayList();
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();
                if(node != null){
                    level.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(level.size() > 0) result.add(level);
        }
        return result;
    }
}
