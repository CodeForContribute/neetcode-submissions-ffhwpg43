class Solution {
    private boolean[]visited;
    private List<List<Integer>>adj;
    private Set<Integer>cycle;
    private int cycleStart;

    private boolean dfs(int node, int par){
        if(visited[node]){
            cycleStart = node;
            return true;
        }
        visited[node] = true;
        for(int ne : adj.get(node)){
            if(ne == par)continue;
            if(dfs(ne, node)){
                if(cycleStart != -1)cycle.add(node);
                if(cycleStart == node)cycleStart = -1;
                return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        // instead of checking for a cycle after every edge, we build 
        // the whole graph once and find the cycle nodes in a single dfs.

        // key idea :
        // 1. in an undirected graph made from n edges on n nodes, there
        // is exactly one cycle.
        // during dfs - if we reach a node that is already visited, we just found the start of the cycle.
        // while recursion - unwinds - back, we mark every node on that return 
        // path as part of the cycle, until we come back to the cycle start.

        // after we have the set cycle( all nodes that lie  on the cycle.)
        // the redundant edge must connect two cycle nodes
        if(edges == null || edges.length == 0)return new int[]{};
        int n = edges.length;
        adj = new ArrayList();
        for(int i = 0; i <n+1;i++){
            adj.add(new ArrayList());
        }
        for(int[]edge: edges){
            int from = edge[0] , to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        visited = new boolean[n+1];
        cycle = new HashSet();
        cycleStart = -1;
        dfs(1,-1);
        for(int i = edges.length-1; i >= 0; i--){
            int from = edges[i][0], to = edges[i][1];
            if(cycle.contains(from) && cycle.contains(to)){
                return new int[]{from, to};
            }
        }
        return new int[]{};
    }
}
