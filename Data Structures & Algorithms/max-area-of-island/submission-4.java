class DSU{
    private int[] parent, size;
    public DSU(int n){
        this.parent = new int[n+1];
        this.size = new int[n+1];
        for(int i = 0; i <= n;i++){
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

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv)return false;
        if(size[pu] >= size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
        return true;
    }

    public int getSize(int node){
        return size[find(node)];
    }
}

class Solution {
    private static final int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        int area = 0;
        DSU dsu = new DSU(m * n);
        for(int r = 0; r < m; r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1){
                    for(int[]dir : directions){
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                            dsu.union(r * n + c , nr * n + nc);
                        }
                    }
                    area = Math.max(area,dsu.getSize(r*n+c));
                }
            }
        }
        return area;
    }
}
