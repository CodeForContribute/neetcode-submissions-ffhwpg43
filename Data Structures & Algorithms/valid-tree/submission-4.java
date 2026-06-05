class DSU{
    int[]parent, size;
    int comps;

    public DSU(int n){
        this.parent = new int[n];
        this.size = new int[n];
        this.comps = n;
        for(int i = 0; i < n; i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int node){
        if(node == parent[node])return node;
        return find(parent[node]);
    }

    public boolean union(int a, int b){
        int pa = find(a), pb = find(b);
        if(pa == pb)return false;
        if(size[pa] < size[pb]){
            size[pb] += size[pa];
            parent[pa] = pb;
        }else {
            size[pa] += size[pb];
            parent[pb] = pa;
        }
        comps--;
        return true;
    }

    public int getComponents(){
        return this.comps;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // a graph is valid
        // it has no cycles - check if adding an edge forms a cycle.
        // it is fully connected - total connected components = 1;
        if(edges.length > n-1)return false;
        DSU dsu = new DSU(n);
        for(int[]edge: edges){
            int from = edge[0], to = edge[1];
            if(!dsu.union(from, to)){
                return false;// this edge forms a cycle.
            }
        }
        return dsu.getComponents() == 1;
    }
}
