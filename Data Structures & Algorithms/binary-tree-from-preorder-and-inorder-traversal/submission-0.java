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
    private int preIndex = 0;
    private Map<Integer,Integer>inorderIndex = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length;i++){
            inorderIndex.put(inorder[i],i);
        }
        return dfs(preorder, inorder, 0,inorder.length-1);
    }
    private TreeNode dfs(int[]preorder, int[]inorder, int left, int right){
        // base case
        if(left > right)return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        // find the index of root.val in inorder and split there
        int mid = inorderIndex.get(root.val);
        root.left = dfs(preorder, inorder, left, mid-1);
        root.right = dfs(preorder, inorder, mid+1, right);
        return root;
    }
}
