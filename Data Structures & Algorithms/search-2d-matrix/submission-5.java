class Solution {
    public boolean searchMatrix(int[][] grid, int target) {
        if(grid == null || grid.length == 0)return false;
        int m = grid.length, n = grid[0].length;
        int r = m-1, c = 0;
        while(r >= 0 && c < n){
            if(grid[r][c] < target){
                c++;
            }else if ( grid[r][c] > target){
                r--;
            }else return true;
        }
        return false;
        // while(r < m && c >= 0){
        //     if(grid[r][c] > target){
        //         c--;
        //     }else if ( grid[r][c] < target){
        //         r++;
        //     }else{
        //         return true;
        //     }
        // }
        // return false;
    }
}
