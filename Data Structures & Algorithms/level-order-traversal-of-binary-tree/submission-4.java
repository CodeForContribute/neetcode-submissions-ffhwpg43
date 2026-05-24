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
    private List<List<Integer>>result = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null)return;
        if(result.size() == level){
            result.add(new ArrayList());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right, level+1);
    }
}
