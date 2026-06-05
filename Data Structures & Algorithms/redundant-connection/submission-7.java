class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0)return new int[]{};
        int n = edges.length;
        int[]indegree = new int[n+1];
        List<List<Integer>>adj = new ArrayList();
        for(int node = 0; node <= n;node++){
            adj.add(new ArrayList());
        }
        for(int[]edge: edges){
            int from = edge[0], to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
            indegree[from]++;indegree[to]++;
        }

        Queue<Integer>q = new LinkedList();
        for(int node = 1 ; node <= n; node++){
            if(indegree[node] == 1)q.offer(node);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            indegree[node]--;
            for(int ne : adj.get(node)){
                indegree[ne]--;
                if(indegree[ne] == 1)q.offer(ne);
            }
        }
        for(int i = edges.length-1; i >= 0; i--){
            int from = edges[i][0], to = edges[i][1];
            if(indegree[from] == 2 && indegree[to] == 2){
                return new int[]{from, to};
            }
        }
        return new int[0];
    }
}
