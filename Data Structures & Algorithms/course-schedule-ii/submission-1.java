class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        //if(pre == null || pre.length == 0)return new int[]{};
        int n = pre.length;
        int[]inDegree = new int[numCourses];
        List<List<Integer>>adj = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList());
        }
        for(int[]p: pre){
            int from = p[1], to = p[0];
            adj.get(from).add(to);
            inDegree[to]++;
        }
        Queue<Integer>q = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0)q.add(i);
        }

        int idx = 0;
        int[]result = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            result[idx++] = node;
            for(int ne : adj.get(node)){
                inDegree[ne]--;
                if(inDegree[ne] == 0)q.offer(ne);
            }
        }
        return idx == numCourses ? result : new int[]{};
    }
}
