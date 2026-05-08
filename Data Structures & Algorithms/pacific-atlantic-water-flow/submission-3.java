class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length == 0)return new ArrayList();
        int m = heights.length, n = heights[0].length;

        List<List<Integer>>result = new ArrayList();

        boolean[][]pac = new boolean[m][n];
        boolean[][]atl = new boolean[m][n];

        Queue<int[]>pacQueue = new LinkedList();
        Queue<int[]>atlQueue = new LinkedList();

        // start from boundaries cells
        for(int c = 0;  c < n;c++){
            pacQueue.add(new int[]{0,c});
            atlQueue.add(new int[]{m-1,c});
        }

        for(int r = 0 ;r < m; r++){
            pacQueue.add(new int[]{r,0});
            atlQueue.add(new int[]{r,n-1});
        }

        bfs(pacQueue, pac, heights,m,n);
        bfs(atlQueue, atl, heights,m,n);

        for(int r = 0 ; r < m; r++){
            for(int c = 0 ;c < n; c++){
                if(pac[r][c] && atl[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    private void bfs(Queue<int[]>q, boolean[][]ocean, int[][]heights, int m, int n){
        while(!q.isEmpty()){
            int[]cur = q.poll();
            int r = cur[0],c = cur[1];
            ocean[r][c] = true;
            for(int[]dir: directions){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}
