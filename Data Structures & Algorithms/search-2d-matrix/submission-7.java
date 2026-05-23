class Solution {
    public boolean searchMatrix(int[][] grid, int target) {
        if(grid == null || grid.length == 0)return false;
        int m = grid.length, n = grid[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right){
            int mid = left + ( right - left)/2;
            int row = mid / n, col = mid % n;
            if(target > grid[row][col]){
                left = mid+1;
            }else if(target < grid[row][col]){
                right = mid-1;
            }else return true;
        }
        return false;
        // if(grid == null || grid.length == 0)return false;
        // int m = grid.length, n = grid[0].length;
        // int left = 0, right = m * n - 1;
        // while(left <= right){
        //     int mid = left + ( right - left )/2;
        //     int row = mid / n, col = mid % n;
        //     if(target > grid[row][col]){
        //         left = mid+1;
        //     }else if ( target < grid[row][col]){
        //         right = mid-1;
        //     }else return true;
        // }
        // return false;
    }
}
