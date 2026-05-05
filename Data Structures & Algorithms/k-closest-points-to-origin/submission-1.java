class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points == null || points.length == 0)return new int[][]{};
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int[]point: points){
            int distance = (point[0] * point[0] + point[1] * point[1]);
            pq.offer(new int[]{distance,point[0],point[1]});
        }
        int[][]result = new int[k][2];
        for(int i = 0; i < k;i++){
            int[]point = pq.poll();
            result[i] = new int[]{point[1],point[2]};
        }
        return result;
    }
}
