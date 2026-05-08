class DSU{
    private int[]parent;
    private int[]size;

    public DSU(int n){
        this.parent = new int[n];
        this.size = new int[n];

        for(int i = 0; i < n;i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]]; // Optional path compression
            i = parent[i];
        }
            return i;
    }

    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb)return false;
        if(size[pa] > size[pb]){
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
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int ans = n;
        for(int[]edge : edges){
            int from = edge[0], to = edge[1];
            boolean status = dsu.union(from, to);
            System.out.println(status);
            if(status)ans--;
        }
        return ans;
    }
}
