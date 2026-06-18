class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int[][]indegrees = new int[m][n];

        for(int r = 0 ; r < m;r++){
            for(int c = 0;c < n; c++){
                for(int[]dir: directions){
                    int nr = r + dir[0] , nc = c + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[r][c] > grid[nr][nc]){
                        indegrees[r][c]++;
                    }
                }
            }
        }

        Queue<int[]>q = new LinkedList();
        for(int r = 0; r < m;r++){
            for(int c = 0 ; c < n;c++){
                if(indegrees[r][c] == 0){
                    q.offer(new int[]{r,c});
                }
            }
        }

        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                int[]node = q.poll();
                int r = node[0], c = node[1];
                for(int[]d : directions){
                    int nr = r + d[0], nc = c + d[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[r][c] < grid[nr][nc]){
                        indegrees[nr][nc]--;
                        if(indegrees[nr][nc] == 0){
                            q.offer(new int[]{nr,nc});
                        }
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}
