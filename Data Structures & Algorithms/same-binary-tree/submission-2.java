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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if they are same then their level order traversal would be same as well.
        Queue<TreeNode>pQ = new LinkedList();
        Queue<TreeNode>qQ = new LinkedList();
        pQ.add(p);qQ.add(q);
        while(!pQ.isEmpty() && !qQ.isEmpty()){
            int m = pQ.size(), n = qQ.size();
            if(m != n)return false;// the number of nodes at a given level are not same then return false
            for(int i = 0; i < n;i++){
                TreeNode node1 = pQ.poll(), node2 = qQ.poll();
                if(node1 == null && node2 == null)continue;
                if(node1 == null || node2 == null)return false;
                if(node1.val != node2.val)return false;
                pQ.add(node1.left);qQ.add(node2.left);
                pQ.add(node1.right);qQ.add(node2.right);
            }
        }
        return pQ.isEmpty() && qQ.isEmpty();
        // Stack<TreeNode[]>stack = new Stack();
        // stack.push(new TreeNode[]{p,q});
        // while(!stack.isEmpty()){
        //     TreeNode[]nodes = stack.pop();
        //     TreeNode node1 = nodes[0], node2 = nodes[1];
        //     if(node1 == null && node2 == null)continue;
        //     if(node1 == null || node2 == null)return false;
        //     if(node1.val != node2.val)return false;
        //     stack.push(new TreeNode []{node1.left, node2.left});
        //     stack.push(new TreeNode[]{node1.right, node2.right});
        // }
        // return true;
    }
}
