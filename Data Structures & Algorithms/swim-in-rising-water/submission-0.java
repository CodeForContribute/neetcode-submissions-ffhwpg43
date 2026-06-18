class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int swimInWater(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        Set<Integer>seen = new HashSet();
        PriorityQueue<Integer>pq = new PriorityQueue<Integer>((a,b)->
        grid[a / n][a % n] - grid[b / n][b % n]);
        pq.offer(0);
        int ans = 0;
        while(!pq.isEmpty()){
            int k = pq.poll();
            int row = k / n, col = k % n;
            ans = Math.max(ans, grid[row][col]);
            if(row == n-1 && col == n-1)return ans;
            for(int[]dir: directions){
                int nr = row + dir[0], nc = col + dir[1];
                int ck = nr * n + nc;
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !seen.contains(ck)){
                    pq.offer(ck);
                    seen.add(ck);
                }
            }
        }
        return -1;
    }
}