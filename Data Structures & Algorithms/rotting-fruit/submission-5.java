class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int orangesRotting(int[][] grid) {

        // multi source bfs
        // 0 - empty cell, 1 - fresh oranges, 2 - rotten oranges.
        // count total freshOranges and put rotten ones in q and start multi source bfs.
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int fresh = 0, time = 0;
        for(int r = 0; r < m;r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1)fresh++;
            }
        }

        while(fresh > 0){
            boolean flag = false;

            for(int r = 0; r < m;r++){
                for(int c = 0;c < n;c++){
                    if(grid[r][c] == 2){
                        for(int[]dir: directions){
                            int row = r + dir[0], col = c + dir[1];
                            if(row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == 1){
                                grid[row][col] = 3;
                                fresh--;
                                flag = true;
                            }
                        }
                    }
                }
            }

            if(!flag)return -1;
            for(int r= 0;r < m;r++){
                for(int c = 0; c< n;c++){
                    if(grid[r][c] == 3)grid[r][c] = 2;
                }
            }
            
            time++;
        }
        return fresh == 0 ? time : -1;
        
        // if(grid == null || grid.length == 0)return 0;
        // int m = grid.length, n = grid[0].length;
        // Queue<int[]>q = new LinkedList();
        // int fresh = 0, time = 0;

        // for(int r = 0; r < m;r++){
        //     for(int c = 0; c < n;c++){
        //         if(grid[r][c] == 1){
        //             fresh++;
        //         }
        //         if(grid[r][c] == 2){
        //             q.offer(new int[]{r,c});
        //         }
        //     }
        // }

        // // multiple source bfs
        // while(fresh > 0 && !q.isEmpty()){
        //     int size = q.size();
        //     for(int i = 0; i < size; i++){
        //         int[]cur = q.poll();
        //         int row = cur[0], col = cur[1];
        //         for(int[]dir: directions){
        //             int nr = row + dir[0], nc = col + dir[1];
        //             if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 1)continue;
        //             grid[nr][nc] = 2;
        //             q.offer(new int[]{nr,nc});
        //             fresh--;
        //         }
        //     }
        //     if(!q.isEmpty())time++;
        // }
        // return fresh == 0 ? time : -1;
    }
}
