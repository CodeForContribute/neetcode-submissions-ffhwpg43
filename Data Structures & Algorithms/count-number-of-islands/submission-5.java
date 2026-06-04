class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int r = 0; r < m;r++){
            for(int c= 0; c < n;c++){
                if(grid[r][c] == '1'){
                    ans++;
                    //dfs(grid,r,c,m,n);
                    bfs(grid,r,c);
                }
            }
        }
        return ans;
    }

    private void bfs(char[][]grid, int r, int c){
        Queue<int[]>q = new LinkedList();
        grid[r][c] = '0';
        q.offer(new int[]{r,c});
        int m = grid.length, n = grid[0].length;
        while(!q.isEmpty()){
            int[]node = q.poll();
            int row = node[0], col = node[1];
            for(int[]dir: directions){
                int nr = row + dir[0], nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'){
                    grid[nr][nc] = '0';
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }

    private void dfs(char[][]grid, int r, int c, int m,int n){
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != '1')return;
        grid[r][c] = '0';
        for(int[]dir: directions){
            int row = r + dir[0], col = c + dir[1];
            dfs(grid, row, col, m,n);
        }
    }
}
