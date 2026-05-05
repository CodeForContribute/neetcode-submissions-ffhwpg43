class KthLargest {
    private PriorityQueue<Integer>minHeap;
    private int k;

    public KthLargest(int k, int[] arr) {
        this.k = k;
        this.minHeap = new PriorityQueue();
        for(int a: arr){
            this.minHeap.offer(a);
            if(minHeap.size() > k)minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k)minHeap.poll();
        return minHeap.peek();
    }
}
