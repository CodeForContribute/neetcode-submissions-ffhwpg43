class Solution {
    private static final int[][]directions = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length == 0)return new ArrayList();
        int m = heights.length, n = heights[0].length;
        
        boolean[][]pac = new boolean[m][n];
        boolean[][]atl = new boolean[m][n];
        
        for(int c = 0; c < n;c++){
            dfs(0,c,pac, heights);
            dfs(m-1,c,atl, heights);
        }
        for(int r = 0; r < m;r++){
            dfs(r,0,pac, heights);
            dfs(r,n-1,atl,heights);
        }
        List<List<Integer>>result = new ArrayList();
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(pac[r][c] && atl[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][]ocean, int[][]heights){
        ocean[r][c] = true;
        for(int[]dir:directions){
            int nr = r + dir[0], nc = c + dir[1];
            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
            && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
