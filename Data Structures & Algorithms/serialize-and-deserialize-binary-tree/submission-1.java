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
    private int preIndex = 0;
    private void dfs(TreeNode root, List<String>result){
        if(root == null){
            result.add("N");
            return;
        }
        result.add(String.valueOf(root.val));
        dfs(root.left,result);
        dfs(root.right, result);
    }

    private TreeNode dfs2(String[]vals){
        if(vals[preIndex].equals("N")){
            preIndex++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[preIndex]));
        preIndex++;
        node.left = dfs2(vals);
        node.right = dfs2(vals);
        return node;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String>result = new ArrayList();
        dfs(root,result);
        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]vals = data.split(",");
        return dfs2(vals);
    }
}
