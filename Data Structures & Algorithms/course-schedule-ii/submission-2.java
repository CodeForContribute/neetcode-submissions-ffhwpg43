class Solution {
    public int[] findOrder(int n, int[][] pre) {

        int[]indegree = new int[n];
        int[]topologicalOrder = new int[n];

        List<List<Integer>>adj = new ArrayList();
        for(int node = 0; node < n;node++){
            adj.add(new ArrayList());
        }

        for(int[]p : pre){
            int from = p[1], to = p[0];
            adj.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer>q = new LinkedList();
        for(int node = 0; node < n; node++){
            if(indegree[node] == 0)q.offer(node);
        }
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topologicalOrder[idx++] = node;
            for(int ne : adj.get(node)){
                indegree[ne]--;
                if(indegree[ne] == 0){
                    q.offer(ne);
                }
            }
        }
        return idx == n ? topologicalOrder : new int[]{};

        // int idx = 0;
        // int[]result = new int[numCourses];
        // while(!q.isEmpty()){
        //     int node = q.poll();
        //     result[idx++] = node;
        //     for(int ne : adj.get(node)){
        //         inDegree[ne]--;
        //         if(inDegree[ne] == 0)q.offer(ne);
        //     }
        // }
        // return idx == numCourses ? result : new int[]{};
    }
}
