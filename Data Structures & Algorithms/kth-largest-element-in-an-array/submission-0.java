class Solution {
    public int findKthLargest(int[] arr, int k) {
        if(arr == null || arr.length == 0)return 0;
        PriorityQueue<Integer>pq = new PriorityQueue();
        for(int a: arr){
            pq.add(a);
            if(pq.size() > k)pq.poll();
        }
        return pq.peek();
    }
}
