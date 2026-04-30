class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void bfs(char[][]grid, int r, int c, int m, int n){
        Queue<int[]>q = new LinkedList();
        grid[r][c] = '0';
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int[]node = q.poll();
            int row = node[0],col = node[1];
            for(int[]dir: directions){
                int nr = row + dir[0],nc = col + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                    grid[nr][nc] = '0';
                    q.offer(new int[]{nr,nc});
                }
            }
        }

    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int r = 0; r < m;r++){
            for(int c = 0; c < n;c++){
                if(grid[r][c] == '1'){
                    ans++;
                    bfs(grid,r,c,m,n);
                }
            }
        }
        return ans;
    }
}
