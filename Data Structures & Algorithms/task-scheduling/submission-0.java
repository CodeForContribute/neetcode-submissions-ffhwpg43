class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)return 0;
        int[]count = new int[26];
        for(char task: tasks)count[task-'A']++;
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt:count){
            if(cnt> 0)pq.add(cnt);
        }
        int time = 0;
        Queue<int[]>q = new LinkedList();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time = q.peek()[1];
            }else{
                int cnt = pq.poll()-1;
                if(cnt > 0){
                    q.add(new int[]{cnt,time+n});
                }
            }
            // check the front of q and see if task can be taken out
            // and added to pq
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
