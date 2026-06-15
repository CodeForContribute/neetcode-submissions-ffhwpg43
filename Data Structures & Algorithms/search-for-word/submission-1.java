class Solution {
    public boolean exist(char[][] grid, String word) {
        if(grid == null || grid.length == 0)return false;
        if(word.isEmpty())return true;
        int m = grid.length, n = grid[0].length;
        for(int r = 0;r < m; r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == word.charAt(0)){
                    if(dfs(grid,r,c,word,0))return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][]grid, int r, int c, String word, int idx){
        if(idx == word.length())return true;
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != word.charAt(idx)){
            return false;
        }
        grid[r][c] = '#';
        boolean result = dfs(grid,r+1,c,word,idx+1)
                        || dfs(grid,r-1,c,word,idx+1)
                        || dfs(grid,r,c+1, word, idx+1)
                        || dfs(grid,r,c-1,word,idx+1);
        grid[r][c] = word.charAt(idx);
        return result;
    }
}
