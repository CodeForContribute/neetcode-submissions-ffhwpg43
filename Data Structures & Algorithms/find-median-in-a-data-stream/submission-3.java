class MedianFinder {
    private PriorityQueue<Integer>maxHeap;
    private PriorityQueue<Integer>minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        rebalance();
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) * 0.5;
        }else{
            return maxHeap.peek();
        }
    }

    private void rebalance(){
        if(minHeap.size() - maxHeap.size() == 1){
            maxHeap.offer(minHeap.poll());
        }
    }
}
