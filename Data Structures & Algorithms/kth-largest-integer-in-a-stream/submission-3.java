class KthLargest {
    private PriorityQueue<Integer>pq;
    private int k;

    public KthLargest(int k, int[] arr) {
        this.k = k;
        this.pq = new PriorityQueue<Integer>();
        for(int a: arr){
            pq.offer(a);
            if(pq.size() > k)pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k)pq.poll();
        return pq.peek();
    }
}
