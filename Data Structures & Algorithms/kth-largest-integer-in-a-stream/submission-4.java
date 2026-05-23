class KthLargest {
    private PriorityQueue<Integer>pq;
    private int k;

    public KthLargest(int k, int[] arr) {
        this.k = k;
        this.pq = new PriorityQueue<Integer>();
        for(int a: arr){
            addElementAndCheckPQSize(a);
        }
    }
    
    public int add(int val) {
        addElementAndCheckPQSize(val);
        return pq.peek();
    }

    private void addElementAndCheckPQSize(int val){
        pq.offer(val);
        if(pq.size() > k)pq.poll();
    }
}
