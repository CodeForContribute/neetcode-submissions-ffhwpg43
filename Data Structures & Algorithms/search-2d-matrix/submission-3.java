class Solution {
    public boolean searchMatrix(int[][] grid, int target) {
        if(grid == null || grid.length == 0)return false;
        int m = grid.length, n = grid[0].length;
        int r = 0, c = n-1;
        while(r < m && c >= 0){
            if(grid[r][c] > target){
                c--;
            }else if ( grid[r][c] < target){
                r++;
            }else{
                return true;
            }
        }
        return false;
    }
}
