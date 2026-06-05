class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0)return;
        int m = grid.length, n = grid[0].length;
        Queue<int[]>q = new LinkedList();
        for(int r = 0; r < m;r++){
            for(int c =0 ; c < n;c++){
                if(grid[r][c] == 0)q.offer(new int[]{r,c});
            }
        }

        while(!q.isEmpty()){
            int[]node = q.poll();
            int row = node[0], col = node[1];
            for(int[]dir: directions){
                int r = row + dir[0], c = col + dir[1];
                if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != Integer.MAX_VALUE)continue;
                grid[r][c] = 1 + grid[row][col];
                q.offer(new int[]{r,c});
            }
        }
        //if(grid == null || grid.length == 0)return;
        // -1 water cell, 0 - treasure, inf - land 
        // start from treasure - multi bfs - 0 cell.
        // keep updating the nearest distance for each land cell for each treasure cell.
        // as we do the bfs, automatically it will provide the nearest distance.
        // int m = grid.length, n = grid[0].length;
        // Queue<int[]>q = new LinkedList();
        // for(int r = 0 ; r < m; r++){
        //     for(int c = 0;c < n;c++){
        //         if(grid[r][c] == 0)q.offer(new int[]{r,c});
        //     }
        // }
        // if(q.size() == 0)return;
        // while(!q.isEmpty()){
        //     int[]node = q.poll();
        //     int row = node[0],col = node[1];
        //     for(int[]dir: directions){
        //         int r = row + dir[0],c = col + dir[1];
        //         if(r >= m || c >= n || c < 0 || r < 0 || grid[r][c] != Integer.MAX_VALUE){
        //             continue;
        //         }
        //         q.offer(new int[]{r,c});
        //         grid[r][c] = grid[row][col] + 1;
        //     }
        // }
    }
}
