class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0)return new int[]{};
        int n = edges.length;
        int[]inDegree = new int[n+1];
        List<List<Integer>>adj = new ArrayList();
        for(int i = 0; i <= n;i++)adj.add(new ArrayList());
        for(int[]edge: edges){
            int from = edge[0], to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
            inDegree[from]++;inDegree[to]++;
        }
        Queue<Integer>q = new LinkedList();
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 1)q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            inDegree[node]--;
            for(int ne : adj.get(node)){
                inDegree[ne]--;
                if(inDegree[ne] == 1)q.offer(ne);
            }
        }
        for(int i = edges.length-1; i >= 0; i--){
            int from = edges[i][0], to = edges[i][1];
            if(inDegree[from] == 2 && inDegree[to] > 0){
                return new int[]{from, to};
            }
        }
        return new int[]{};
    }
}
