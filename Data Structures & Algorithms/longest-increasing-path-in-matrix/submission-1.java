class Solution {
    private static final int[][]directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private int[][]dp;

    private int dfs(int[][]grid, int r, int c,int prevVal){
        int m = grid.length, n = grid[0].length;
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] <= prevVal)return 0;
        if(dp[r][c] != -1)return dp[r][c];
        int ans = 1;
        for(int[]d : directions){
            int row = r + d[0], col = c + d[1];
            ans = Math.max(ans, 1 + dfs(grid,row,col,grid[r][c]));
        }
        return dp[r][c] = ans;
    }

    public int longestIncreasingPath(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        dp = new int[m][n];
        for(int[]d: dp){
            Arrays.fill(d, -1);
        }
        for(int r = 0;r < m;r++){
            for(int c = 0;c < n;c++){
                ans = Math.max(ans, dfs(grid,r,c,Integer.MIN_VALUE));
            }
        }
        return ans;
    }
}
