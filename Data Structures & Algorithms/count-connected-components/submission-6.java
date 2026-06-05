class DSU{
    int[]parent, rank;
    int comps;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        comps = n;
        for(int node = 0; node < n;node++){
            parent[node] = node;
            rank[node] = 1;
        }
    }

    public int find(int node){
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int a, int b){
        int roota = find(a);
        int rootb = find(b);
        if(roota == rootb)return false;
        if(rank[roota] <= rank[rootb]){
            parent[roota] = rootb;
            rank[rootb] += rank[roota];
        }else{
            parent[rootb] = roota;
            rank[roota] += rank[rootb];
        }
        comps--;
        return true;
    }

    public int getComps(){
        return comps;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0)return 0;
        DSU dsu = new DSU(n);
        for(int[]edge: edges){
            int from = edge[0] ,to = edge[1];
            dsu.union(from, to);
        }
        return dsu.getComps();
    }
}
