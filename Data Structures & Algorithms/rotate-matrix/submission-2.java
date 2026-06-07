class Solution {
    public void rotate(int[][] grid) {
        // brute force
        if(grid == null || grid.length == 0)return;
        int n = grid.length;
        int[][]rotated = new int[n][n];
        for(int r =0 ; r < n;r++){
            for(int c = 0 ;c < n;c++){
                rotated[c][n-1-r] = grid[r][c];
            }
        }
        for(int r= 0 ; r < n;r++){
            for(int c = 0;c < n;c++){
                grid[r][c] = rotated[r][c];
            }
        }
    }
}
