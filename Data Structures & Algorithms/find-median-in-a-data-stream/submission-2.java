class MedianFinder {
    private PriorityQueue<Integer>minHeap;
    private PriorityQueue<Integer>maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<Integer>();
        this.maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        this.maxHeap.offer(num);
        this.minHeap.offer(this.maxHeap.poll());
        rebalance();
    }
    public void rebalance(){
        if(this.minHeap.size() - this.maxHeap.size() == 1){
            this.maxHeap.offer(this.minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(this.maxHeap.size() == this.minHeap.size()){
            return ((double)this.maxHeap.peek() + this.minHeap.peek()) * 0.5;
        }else{
            return (double)this.maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */