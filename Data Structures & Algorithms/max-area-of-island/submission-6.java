class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int r = 0;r < m;r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1){
                    ans = Math.max(ans, dfs(grid,r,c));
                }
            }
        }
        return ans;
    }
    private int dfs(int[][]grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1)return 0;
        grid[r][c] = 0;
        return 1 + dfs(grid,r-1,c) +
                   dfs(grid,r+1,c) +
                   dfs(grid,r,c-1) +
                   dfs(grid,r,c+1);
    }
}
