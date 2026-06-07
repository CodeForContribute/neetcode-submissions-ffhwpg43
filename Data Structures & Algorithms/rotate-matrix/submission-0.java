class Solution {
    public void rotate(int[][] grid) {
        // swap the rows and cols in grid
        // then reverse the cols
        if(grid == null || grid.length == 0)return;
        int m = grid.length, n = grid[0].length;
        for(int r = 0; r < m;r++){
            for(int c = r ; c < n;c++){
                swap(grid,r,c);
            }
        }
        for(int r = 0; r < n;r++){
            for(int c = 0; c < n/2; c++){
                //swap(grid,c,n-c-1);
                int temp = grid[r][c];
                grid[r][c] = grid[r][n-c-1];
                grid[r][n-c-1] = temp;
            }
        }
    }

    private void swap(int[][] grid, int r, int c){
        int temp = grid[r][c];
        grid[r][c] = grid[c][r];
        grid[c][r] = temp;
    }
}
