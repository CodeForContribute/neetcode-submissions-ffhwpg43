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
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        Map<Node, Node>oldToNew = new HashMap();
        oldToNew.put(node, new Node(node.val));
        // bfs
        Queue<Node>q = new LinkedList();
        q.offer(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node ne: cur.neighbors){
                if(!oldToNew.containsKey(ne)){
                    oldToNew.put(ne, new Node(ne.val));
                    q.offer(ne);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(ne));
            }
        }
        return oldToNew.get(node);
        // if(node == null)return null;
        // Map<Node,Node>oldToNew = new HashMap();
        // Queue<Node>q = new LinkedList();
        // oldToNew.put(node, new Node(node.val));
        // q.offer(node);
        // while(!q.isEmpty()){
        //     Node cur = q.poll();
        //     for(Node ne: cur.neighbors){
        //         if(!oldToNew.containsKey(ne)){
        //             oldToNew.put(ne, new Node(ne.val));
        //             q.offer(ne);
        //         }
        //         oldToNew.get(cur).neighbors.add(oldToNew.get(ne));
        //     }
        // }
        // return oldToNew.get(node);
    }
}