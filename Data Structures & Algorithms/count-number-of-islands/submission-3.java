class DSU{
    private int[]parent, size;
    public DSU(int n){
        this.parent = new int[n+1];
        this.size = new int[n+1];
        for(int i = 0; i <= n; i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    public int find(int node){
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb)return false;
        if(size[pa] >= size[pb]){
            size[pa] += size[pb];
            parent[pb] = pa;
        }else{
            size[pb] += size[pa];
            parent[pa] = pb;
        }
        return true;
    }
}
class Solution {
    private static final int[][]directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        DSU dsu = new DSU( m * n);
        int islands  = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == '1'){
                    islands++;
                    for(int[]dir:directions){
                        int nr = r + dir[0], nc = c + dir[1];
                        if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'){
                            if(dsu.union(r * n + c, nr * n + nc)){
                                islands--;
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
