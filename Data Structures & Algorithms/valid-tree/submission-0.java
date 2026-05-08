class Solution {
    public boolean validTree(int n, int[][] edges) {
        // graph to be valid - no cycle 
        // if is fully connected - all nodes visited once
        // so if there is number of nodes - n, then there would be
        // n-1 edges
        if(edges.length > n-1)return false;
        List<List<Integer>>adj = new ArrayList();
        for(int i = 0; i < n;i++){
            adj.add(new ArrayList());
        }

        for(int[]edge : edges){
            int from  = edge[0] ,to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        Set<Integer>visited = new HashSet();
        if(!dfs(0,-1,visited,adj)){
            return false;//found a cycle.
        }
        return visited.size() == n; // all nodes visited once.
        // so disconnected check.
    }

    private boolean dfs(int node, int parent, Set<Integer>visited,List<List<Integer>>adj){
        if(visited.contains(node))return false;
        visited.add(node);
        for(int ne : adj.get(node)){
            if(ne == parent)continue; // visited -> gives cycle, parent -> ignoring ne
            if(!dfs(ne, node, visited, adj)){
                return false;
            }
        }
        return true;
    }
}
