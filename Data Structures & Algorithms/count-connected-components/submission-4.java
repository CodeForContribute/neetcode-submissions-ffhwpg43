class Solution {
    // private void dfs(List<List<Integer>>adj, int node, boolean[]visited){
    //     visited[node] = true;
    //     for(int ne : adj.get(node)){
    //         if(!visited[ne])dfs(adj, ne, visited);
    //     }
    // }

    private void dfs(List<List<Integer>>adj,boolean[]visited,int node){
        visited[node] = true;
        for(int ne : adj.get(node)){
            if(!visited[ne])dfs(adj,visited, ne);
        }
    }

    private void bfs(List<List<Integer>>adj, int node, boolean[]visited){
        Queue<Integer>q = new LinkedList();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int ne : adj.get(cur)){
                if(!visited[ne]){
                    visited[ne] = true;
                    q.offer(ne);
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0)return 0;
        List<List<Integer>>adj = new ArrayList();
        boolean[]visited = new boolean[n];
        for(int node = 0 ; node <n ; node++){
            adj.add(new ArrayList());
        }
        for(int[]edge: edges){
            int from = edge[0],to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        int ans = 0;
        for(int node = 0; node < n;node++){
            if(!visited[node]){
                ans++;
                dfs(adj,visited,node);
            }
        }
        return ans;
        // int ans = 0;
        // for(int node = 0; node < n;node++){
        //     if(!visited[node]){
        //         //dfs(adj, node,visited);
        //         bfs(adj, node, visited);
        //         ans++;
        //     }
        // }
        // return ans;
    }
}
