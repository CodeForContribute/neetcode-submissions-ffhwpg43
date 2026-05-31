class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(times == null || times.length == 0)return -1;
        int[]distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k-1] = 0;
        for(int edge = 0; edge < n-1; edge++){
            for(int[]time: times){
                int src = time[0]-1, dest = time[1]-1, weight = time[2];
                if(distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]){
                    distance[dest] = distance[src] + weight;
                }
            }
        }
        int maxDistance = Arrays.stream(distance).max().getAsInt();
        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }
}
