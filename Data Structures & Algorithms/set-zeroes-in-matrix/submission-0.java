class Solution {
    public void setZeroes(int[][] grid) {

        boolean isCol = false;
        int m = grid.length, n = grid[0].length;

        for(int r = 0;r < m; r++){
            if(grid[r][0] == 0){
                    isCol = true;
                }

                for(int c = 1 ; c < n;++c){
                    if(grid[r][c] == 0){
                        grid[r][0] = 0;
                        grid[0][c] = 0;
                    }
                }
        }
        // iterate over the arr once again and using the first row and first col. update the elements
        for(int r = 1 ; r < m;r++){
            for(int c = 1; c < n;c++){
                if(grid[r][0] == 0 || grid[0][c] == 0){
                    grid[r][c] = 0;
                }
            }
        }
        // see if the first row needs to be set to zero as well.
        if(grid[0][0] == 0){
            for(int c = 0;c < n;c++){
                grid[0][c] = 0;
            }
        }

        // see if the first col needs to be set to 0 as well.
        if(isCol){
            for(int r = 0;r < m;r++){
                grid[r][0] = 0;
            }
        }
    }
}