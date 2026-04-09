class Solution {
    public boolean isValidSudoku(char[][] grid) {
        // if a char is a digit
        // check if there is another same digit in the row
        // check if there is another same digit in the col
        // check if there is another same digit in boxes for duplicate detection
        if(grid == null || grid.length == 0)return true;
        int m = grid.length, n = grid[0].length;
        for(int r = 0; r < 9; r++){
            Set<Character>seen = new HashSet();
            for(int c = 0 ; c < 9; c++){
                if(grid[r][c] == '.')continue;
                if(seen.contains(grid[r][c]))return false;
                seen.add(grid[r][c]);
            }
        }
        // do same thing for cols
        for(int c = 0; c < 9; c++){
            Set<Character>seen = new HashSet();
            for(int r = 0; r < 9;r++){
                if(grid[r][c] == '.')continue;
                if(seen.contains(grid[r][c]))return false;
                seen.add(grid[r][c]);
            }
        }

        for(int square = 0; square < 9; square++){
            Set<Character>seen = new HashSet();
            for(int r = 0 ;r < 3; r++){
                for(int c = 0;c < 3; c++){
                    int row = (square / 3) * 3 + r;
                    int col = (square % 3) * 3 + c;
                    if(grid[row][col] == '.')continue;
                    if(seen.contains(grid[row][col]))return false;
                    seen.add(grid[row][col]);
                }
            }
        }
        return true;
    }
}
