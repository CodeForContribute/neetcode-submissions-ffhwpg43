class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int area = 0;
        for(int r = 0 ;r < m ;r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1){
                    area = Math.max(area, bfs(grid,r,c));
                }
            }
        }
        return area;
    }

    private int bfs(int[][]grid, int r, int c){
        int m = grid.length, n = grid[0].length;
        Queue<int[]>q = new LinkedList();
        int ans = 1;
        grid[r][c] = 0;
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0], col = node[1];
            for(int[]dir: directions){
                int nr = row + dir[0], nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    ans++;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return ans;
    }
}
