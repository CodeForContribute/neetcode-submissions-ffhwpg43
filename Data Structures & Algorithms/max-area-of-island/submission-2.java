class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    private int bfs(int[][]grid, int r, int c, int m, int n){
        Queue<int[]>q = new LinkedList();
        grid[r][c] = 0;
        q.add(new int[]{r,c});
        int ans = 1;
        while(!q.isEmpty()){
            int[]node = q.poll();
            r = node[0]; c = node[1];
            for(int[]dir: directions){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    q.add(new int[]{nr, nc});
                    ans++;
                }
            }
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int area = 0;
        for(int r = 0; r < m; ++r){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1){
                    area = Math.max(area,bfs(grid,r,c,m,n));
                }
            }
        }
        return area;
    }
}
