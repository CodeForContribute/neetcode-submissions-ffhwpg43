class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    private int dfs(int[][]grid, int r,int c, int m, int n){
        // base case
        if(r < 0 || c < 0 || r >= m || c >=n || grid[r][c] == 0)return 0;
        grid[r][c] = 0;
        int ans = 1;
        for(int[]dir : directions){
            ans += dfs(grid,r+dir[0],c + dir[1], m,n);
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int area = 0;
        for(int r = 0;r < m; r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1){
                    area = Math.max(area,dfs(grid,r,c,m,n));
                }
            }
        }
        return area;
    }
}
