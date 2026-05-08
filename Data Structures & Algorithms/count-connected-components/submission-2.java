class Solution {
    private void dfs(List<List<Integer>>adj, int node, boolean[]visited){
        visited[node] = true;
        for(int ne : adj.get(node)){
            if(!visited[ne])dfs(adj, ne, visited);
        }
    }
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0)return 0;
        List<List<Integer>>adj = new ArrayList();
        boolean[]visited = new boolean[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList());
        }
        for(int[]edge: edges){
            int from = edge[0], to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        int ans = 0;
        for(int node = 0; node < n;node++){
            if(!visited[node]){
                dfs(adj, node,visited);
                ans++;
            }
        }
        return ans;
    }
}
