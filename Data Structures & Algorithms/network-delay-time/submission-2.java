class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // floyd-warshall - all pairs shortest path between every (i,j)
        // by allowing an intermediate node mid.
        // after processing all intermediates , distance[i][j] stores the shortest
        // time from i to j.
        // Once all shortest paths are known.
        // look at the row corresponding to the starting node k.
        // the max value in that row is the time when the last node recieves the signal.
        // if any node is unreachable ( distance == inf), return -1.
        int inf = Integer.MAX_VALUE/2;
        int[][]distance = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(distance[i], inf);
            distance[i][i] = 0;
        }

        for(int[]time: times){
            int u = time[0]-1, v = time[1]-1, w = time[2];
            distance[u][v] = w;
        }
        for(int mid = 0; mid < n; mid++){
            for(int r = 0; r < n;r++){
                for(int c = 0; c < n;c++){
                    distance[r][c] = Math.min(distance[r][c],distance[r][mid] + distance[mid][c]);
                }
            }
        }
        int result = Arrays.stream(distance[k-1]).max().getAsInt();
        return result == inf ? -1:result;

    }
}
