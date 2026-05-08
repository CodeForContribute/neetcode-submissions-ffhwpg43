class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1)return false;
        List<List<Integer>>adj = new ArrayList();

        for(int i = 0; i < n;i++)adj.add(new ArrayList());
        for(int[]edge: edges){
            int from = edge[0], to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        Set<Integer>visited = new HashSet();
        Queue<int[]>q = new LinkedList();
        q.offer(new int[]{0,-1}); // node,parent
        visited.add(0);
        while(!q.isEmpty()){
            int[]cur = q.poll();
            int node = cur[0], parent = cur[1];
            for(int ne : adj.get(node)){
                if(ne == parent)continue;
                if(visited.contains(ne))return false;
                visited.add(ne);
                q.offer(new int[]{ne, node});
            }
        }
        return visited.size() == n;
    }
}
