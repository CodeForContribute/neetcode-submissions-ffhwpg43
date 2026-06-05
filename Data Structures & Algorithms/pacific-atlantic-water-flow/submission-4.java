class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length == 0)return new ArrayList();
        int m = heights.length, n = heights[0].length;
        List<List<Integer>>result = new ArrayList();
        
        boolean[][]pac = new boolean[m][n];
        boolean[][]atl = new boolean[m][n];

        Queue<int[]>pacQ = new LinkedList();
        Queue<int[]>atlQ = new LinkedList();
        
        for(int c = 0;c < n;c++){
            pacQ.add(new int[]{0,c});
            atlQ.add(new int[]{m-1,c});
        }

        for(int r = 0; r < m;r++){
            pacQ.add(new int[]{r,0});
            atlQ.add(new int[]{r,n-1});
        }

        bfs(pacQ,pac, heights, m,n);
        bfs(atlQ,atl, heights, m,n);

        for(int r = 0; r < m;r++){
            for(int c = 0; c < n;c++){
                if(pac[r][c] && atl[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    private void bfs(Queue<int[]>q ,boolean[][]ocean, int[][]heights, int m, int n){

        while(!q.isEmpty()){
            int[]node = q.poll();
            int row = node[0], col = node[1];
            ocean[row][col] = true;
            for(int[]dir: directions){
                int r = row + dir[0] ,c = col + dir[1];
                if(r < 0 || c < 0 || r >= m || c >= n || ocean[r][c] == true || heights[r][c] < heights[row][col])continue;
                q.offer(new int[]{r,c});
            }
        }
    }

}
