class DSU{
    private int n;
    private int[] parent;
    private int[]size;

    public DSU(int n){
        this.n = n;
        this.parent = new int[n+1];
        this.size = new int[n+1];
        for(int i = 1; i <= n; i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int a){
        int p = parent[a];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb)return false;
        if(size[pa] < size[pb]){
            size[pb] += size[pa];
            parent[pa] = pb;
        }else{
            size[pa] += size[pb];
            parent[pb] = pa;
        }
        return true;
    }

}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0)return new int[]{};
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int[]edge: edges){
            int from = edge[0], to = edge[1];
            if(!dsu.union(from, to)){
                return new int[]{from, to};
            }
        }
        return new int[]{};
    }
}
