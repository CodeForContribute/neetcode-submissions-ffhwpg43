class Solution {
    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    private int dfs(int[][]grid, int r, int c, int m, int n){
        if(grid[r][c] == 0)return 0;
        grid[r][c] = 0; // mark it visited
        int cnt = 1; // count this cell.
        // count the neighbors and add it to cnt and return cnt.
        for(int[]dir:directions){
            int row = r + dir[0],col = c + dir[1];
            if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1){
                cnt += dfs(grid,row,col,m,n);
            }
        }
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int r  = 0; r < m;r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1){
                    ans = Math.max(ans, dfs(grid,r,c,m,n));
                }
            }
        }
        return ans;
    }
}
