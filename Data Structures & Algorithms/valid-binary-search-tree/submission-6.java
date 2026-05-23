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
        if(root == null)return true;
        return bfs(root);
        // if(root == null)return true;
        // Queue<Object[]>q = new LinkedList();
        // q.offer(new Object[]{root,Integer.MIN_VALUE, Integer.MAX_VALUE});
        // while(!q.isEmpty()){
        //     Object[]cur = q.poll();
        //     TreeNode node = (TreeNode)cur[0];
        //     int lower = (int)cur[1],upper = (int)cur[2];
        //     if(!(lower < node.val && node.val < upper))return false;
        //     if(node.left != null){
        //         q.offer(new Object[]{node.left, lower, node.val});
        //     }
        //     if(node.right != null){
        //         q.offer(new Object[]{node.right, node.val, upper});
        //     }
        // }
        // return true;
    }

    private boolean bfs(TreeNode root){
        if(root == null)return true;
        Queue<Object[]>q = new LinkedList();
        q.offer(new Object[]{root, Long.MIN_VALUE, Long.MAX_VALUE});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                Object[] obj = q.poll();
                TreeNode node = (TreeNode)obj[0];
                long lower = (long) obj[1];
                long upper = (long) obj[2];
                if(node.val <= lower || node.val >= upper)return false;
                if(node.left != null)q.offer(new Object[]{node.left, lower, (long)node.val});
                if(node.right != null)q.offer(new Object[]{node.right, (long)node.val, upper});
            }
        }
        return true;
    }
    private boolean dfs(TreeNode root, long lower, long upper){
        if(root == null)return true;
        if(root.val <= lower || root.val >= upper)return false;
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }
}
