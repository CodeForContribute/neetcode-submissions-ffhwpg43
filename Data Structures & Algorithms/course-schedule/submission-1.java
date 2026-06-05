class Solution {
    public boolean canFinish(int n, int[][] preqs) {
        int[]indegree = new int[n];
        List<List<Integer>>adj = new ArrayList();
        for(int node = 0; node < n;node++){
            adj.add(new ArrayList());
        }
        for(int[]pre : preqs){
            int to = pre[0], from = pre[1];
            indegree[to]++;
            adj.get(from).add(to);
        }
        Queue<Integer>q = new LinkedList();
        for(int node = 0; node < n; node++){
            if(indegree[node] == 0)q.offer(node);
        }
        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;
            for(int ne : adj.get(node)){
                indegree[ne]--;
                if(indegree[ne] == 0){
                    q.offer(ne);
                }
            }
        }
        return finish == n;
        // int[]inDegree = new int[numCourses];
        // List<List<Integer>>adj = new ArrayList();
        // for(int i = 0; i < numCourses; i++){
        //     adj.add(new ArrayList());
        // }
        // for(int[]pre: prerequisites){
        //     int to = pre[0], from = pre[1];
        //     inDegree[to]++;
        //     adj.get(from).add(to);
        // }
        // Queue<Integer>q = new LinkedList();
        // for(int i = 0; i < numCourses;i++){
        //     if(inDegree[i] == 0)q.add(i);
        // }
        // int finish = 0;
        // while(!q.isEmpty()){
        //     int node = q.poll();
        //     finish++;
        //     for(int ne : adj.get(node)){
        //         inDegree[ne]--;
        //         if(inDegree[ne] == 0)q.add(ne);
        //     }
        // }
        // return finish == numCourses;
    }
}
