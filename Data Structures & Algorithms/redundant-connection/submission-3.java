class Solution {
    private boolean dfs(int node, int parent, List<List<Integer>>adj, boolean[]visited){
        if(visited[node])return true;// this edge forms a cycle hence return it to
        // the answer.
        visited[node] = true;
        for(int ne: adj.get(node)){
            if(ne == parent)continue;
            if(dfs(ne, node, adj, visited)){
                return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        // a tree can not contain a cycle.
        // while adding edges one by one, the first edge that creates a cycle is the
        // redundant connection.
        // for each new edge u,v, temp add it to the graph
        // run dfs to check if a cycle exists.
        // if dfs revisits a node ( not coming from its parent), a cycle is formed -> that edge is the anwer.
        if(edges == null || edges.length == 0)return new int[]{};
        int n = edges.length;
        List<List<Integer>>adj = new ArrayList();
        for(int i = 0; i <= n; i++)adj.add(new ArrayList());
        for(int[]edge: edges){
            int u = edge[0] ,v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[]visited = new boolean[n+1];
            if(dfs(u,-1,adj, visited)){
                return edge;
            }
        }
        return new int[]{};
    }
}
