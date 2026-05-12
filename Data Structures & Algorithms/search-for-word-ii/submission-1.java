class Solution {
    private boolean backtrack(char[][]grid, int r, int c, String word, int idx){
        if(idx >= word.length())return true;
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != word.charAt(idx))return false;
        grid[r][c] = '#';
        boolean ret = backtrack(grid,r+1,c,word,idx+1)
                      || backtrack(grid,r-1,c,word,idx+1)
                      || backtrack(grid,r,c+1, word, idx+1)
                      || backtrack(grid,r,c-1,word,idx+1);
        grid[r][c] = word.charAt(idx);
        return ret;
    }

    public List<String> findWords(char[][] grid, String[] words) {
        if(grid == null || grid.length == 0 || words == null || words.length == 0)return new ArrayList();

        int m = grid.length, n = grid[0].length;
        List<String>result = new ArrayList();
        for(String word: words){

            boolean found = false;
            for(int r = 0 ;r < m && !found; r++){
                for(int c = 0; c < n; c++){
                    if(grid[r][c] == word.charAt(0)){
                        if(backtrack(grid,r,c,word,0)){
                            result.add(word);
                            found = true;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
