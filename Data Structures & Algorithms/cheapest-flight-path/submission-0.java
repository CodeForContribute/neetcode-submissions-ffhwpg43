class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
       // build adj list - adj[u] - > list of {v, price};
       List<int[]>[]adj = new ArrayList[n];
       for(int i = 0; i < n; i++)adj[i] = new ArrayList();
       for(int[]f: flights){
        int u = f[0], v = f[1], w = f[2];
        adj[u].add(new int[]{v, w});
       }

       // distance[city][stopsUsed] = cheapest cost to reach city 
       int[][]distance = new int[n][k+2];
       for(int[]row : distance)Arrays.fill(row, INF);
       distance[src][0] = 0;

    
       PriorityQueue<int[]>pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
       pq.offer(new int[]{0,src,0});

       while(!pq.isEmpty()){

        int[]top = pq.poll();
        int cost = top[0], city = top[1], stopsUsed = top[2];

        // first time we pop dest, it's the cheapest valid cost
        if(city == dst)return cost;
        if(stopsUsed == k+1)continue;
        if(distance[city][stopsUsed] < cost)continue;

        for(int[]ne : adj[city]){
            int next = ne[0], weight = ne[1];
            int nextCost = cost + weight;
            if(nextCost < distance[next][stopsUsed+1]){
                distance[next][stopsUsed+1] = nextCost;
                pq.offer(new int[]{nextCost,next,stopsUsed+1});
            }
        }
       }
       return -1;
    }
}
