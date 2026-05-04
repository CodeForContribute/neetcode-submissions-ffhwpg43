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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "N";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode>q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null)sb.append("N,");
            else{
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]vals = data.split(",");
        if(vals[0].equals("N"))return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode>q = new LinkedList();
        q.offer(root);
        int idx = 1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!vals[idx].equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(vals[idx]));
                q.offer(left);
                node.left = left;
            }
            idx++;
            if(!vals[idx].equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(vals[idx]));
                q.offer(right);
                node.right = right;
            }
            idx++;
        }
        return root;
    }
}
