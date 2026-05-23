class Solution {
    public boolean isValidSudoku(char[][] grid) {
        if(grid == null || grid.length == 0)return true;
        int m = grid.length, n = grid[0].length;

        Map<Integer,Set<Character>>rows = new HashMap();
        Map<Integer,Set<Character>>cols = new HashMap();
        Map<Integer,Set<Character>>squares = new HashMap();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n;c++){
                if(grid[r][c] == '.')continue;
                int box = (r / 3) * 3 + (c / 3);
                if(
                    rows.computeIfAbsent(r, k-> new HashSet()).contains(grid[r][c])
                    || cols.computeIfAbsent(c, k-> new HashSet()).contains(grid[r][c])
                    || squares.computeIfAbsent(box, k-> new HashSet()).contains(grid[r][c])
                )return false;

                rows.get(r).add(grid[r][c]);
                cols.get(c).add(grid[r][c]);
                squares.get(box).add(grid[r][c]);
            }
        }
        return true;
    }
}
