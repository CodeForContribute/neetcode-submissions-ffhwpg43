class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(char[][]grid, int r, int c, int m, int n){
        grid[r][c] = '0';
        for(int[]dir: directions){
            int row = r + dir[0];
            int col = c + dir[1];
            if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1'){
                dfs(grid,row,col,m,n);
            }
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int r = 0;r < m;r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == '1'){
                    ans++;
                    dfs(grid,r,c,m,n);
                }
            }
        }
        return ans;
    }
}
