/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node,Node>oldToNew = new HashMap();
    private Node dfs(Node node){
        if(node == null)return null;
        if(oldToNew.containsKey(node))return oldToNew.get(node);
        Node nodeCopy = new Node(node.val);
        oldToNew.put(node,nodeCopy);
        for(Node ne: node.neighbors){
            nodeCopy.neighbors.add(dfs(ne));
        }
        return nodeCopy;
    }
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        return dfs(node);
    }
}