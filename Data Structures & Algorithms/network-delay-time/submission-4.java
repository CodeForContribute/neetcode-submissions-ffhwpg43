class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // shortest path faster algo.
        if(times == null || times.length == 0)return -1;
        // instead of relaxing all edges every time, we 
        // only re-process nodes whose distance was actually improved.
        // use a queue to propogate distance updates efficiently.
        Map<Integer,List<int[]>>adj = new HashMap();
        Map<Integer,Integer>distance = new HashMap();
        for(int v =1; v <= n; v++){
            adj.put(v, new ArrayList());
            distance.put(v, Integer.MAX_VALUE);
        }
        for(int[]time: times){
            int src = time[0], dest = time[1], weight = time[2];
            adj.get(src).add(new int[]{dest,weight});
        }
        //int[]distance = new int[n+1];
        //Arrays.fill(distance, Integer.MAX_VALUE);
        distance.put(k,0);
        Queue<int[]>q = new LinkedList();
        q.offer(new int[]{k,0});

        while(!q.isEmpty()){
            int[]cur = q.poll();
            int node = cur[0], time = cur[1];
            if(distance.get(node) < time)continue;
            for(int[]ne: adj.get(node)){
                int nextNode = ne[0], weight = ne[1];
                if(weight + time < distance.get(nextNode)){
                    distance.put(nextNode,time + weight);
                    q.offer(new int[]{nextNode,time+weight});
                }
            }
        }
        int result = Collections.max(distance.values());
        return result == Integer.MAX_VALUE ? -1: result;
    }
}
