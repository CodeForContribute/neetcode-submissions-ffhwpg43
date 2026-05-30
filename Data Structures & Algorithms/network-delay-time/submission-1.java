class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // nodes - [1, n]
        // start bfs from k
        // update the time for signal to reach from k to each node
        // return the min time at node n
        Map<Integer,List<int[]>>adj = new HashMap();
        for(int[]time:times){
            int src = time[0], dest = time[1], weight = time[2];
            adj.computeIfAbsent(src, v-> new ArrayList())
            .add(new int[]{dest, weight});
        }
        Map<Integer,Integer>distance = new HashMap();
        for(int i = 1; i <= n; i++)distance.put(i, Integer.MAX_VALUE);
        dfs(k,0,adj,distance);
        int result = Collections.max(distance.values());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(int node, int time, Map<Integer,List<int[]>>adj,Map<Integer,Integer>distance){
        if(time >= distance.get(node))return;
        distance.put(node, time);
        if(!adj.containsKey(node))return;
        for(int[]edge: adj.get(node)){
            dfs(edge[0], time + edge[1], adj,distance);
        }
    }
}
