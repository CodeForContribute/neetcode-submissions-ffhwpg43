class Solution {
    public boolean searchMatrix(int[][] grid, int target) {
     if(grid == null || grid.length == 0)return false;
     int m = grid.length, n = grid[0].length;
     for(int r = 0;r < m;r++){
        for(int c = 0;c < n;c++){
            if(grid[r][c] == target)return true;
        }
     }
     return false;
    }
}
