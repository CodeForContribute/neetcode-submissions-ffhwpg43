class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]>q = new LinkedList();
        int fresh = 0, time = 0;

        for(int r = 0; r < m; r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
            }
        }

        // multiple source bfs
        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0 ;i < length;i++){
                int[]cur = q.poll();
                int r = cur[0],c = cur[1];
                for(int[]dir: directions){
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row,col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
