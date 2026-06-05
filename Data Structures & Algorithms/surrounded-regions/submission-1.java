class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] grid) {
        // wrong
        // exclude the cells on the boundary- O - mark all boundaries - O -> #
        // put all the O into queue apart from excluded ones
        // and do bfs or dfs and mark O to X
        // revert all # to O back.
        // right - take all boundaries - O and start bfs/dfs from it and mark all connecting
        // cells having O as T and then go flip all 'O' remained after it as - 'X'
        // once done -> reflip all 'T' to O again
        if(grid == null || grid.length == 0)return;
        int m = grid.length, n = grid[0].length;
        bfs(grid);
        for(int r = 0; r < m;r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 'O'){
                    grid[r][c] = 'X';
                }else if(grid[r][c] == 'T'){
                    grid[r][c] = 'O';
                }
            }
        }
        // if(grid == null || grid.length == 0)return;
        // int m = grid.length, n = grid[0].length;
        // bfs(grid);
        // for(int r = 0 ;r < m ; r++){
        //     for(int c = 0; c < n; c++){
        //         if(grid[r][c] == 'O'){
        //             grid[r][c] = 'X';
        //         }else if(grid[r][c] == 'T'){
        //             grid[r][c] = 'O';
        //         }
        //     }
        // }
    }

    private void bfs(char[][]grid){
        Queue<int[]>q = new LinkedList();
        int m = grid.length, n = grid[0].length;
        for(int r = 0;r < m;r++){
            for(int c = 0; c < n;c++){
                if((r * c == 0 || r == m-1 || c == n-1) && grid[r][c] == 'O'){
                    q.offer(new int[]{r,c});
                }
            }
        }
        while(!q.isEmpty()){
            int[]node = q.poll();
            int row = node[0] ,col = node[1];
            grid[row][col] = 'T';
            for(int[]dir: directions){
                int r = row + dir[0], c = col + dir[1];
                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 'O')continue;
                q.offer(new int[]{r, c});
            }
        }
    }

    // private void bfs(char[][]grid){
    //     Queue<int[]>q = new LinkedList();
    //     int m = grid.length, n = grid[0].length;
    //     for(int r = 0 ;r < m; r++){
    //         for(int c =0 ;c < n; c++){
    //             if((r * c == 0 || r == m-1 || c == n-1) &&
    //             grid[r][c] == 'O'){
    //                 q.offer(new int[]{r,c});
    //             }
    //         }
    //     }

    //     while(!q.isEmpty()){
    //         int[]cell = q.poll();
    //         int r = cell[0], c = cell[1];
    //         grid[r][c] = 'T';
    //         for(int[]dir: directions){
    //             int nr = r + dir[0], nc = c + dir[1];
    //             if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 'O'){
    //                 q.offer(new int[]{nr,nc});
    //             }
    //         }
    //     }
    // }
}
