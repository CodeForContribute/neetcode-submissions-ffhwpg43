class KthLargest {
    private final List<Integer>arr;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.arr = new ArrayList();
        for(int ele : nums)this.arr.add(ele);
    }
    
    public int add(int val) {
        this.arr.add(val);
        Collections.sort(this.arr);
        return this.arr.get(arr.size()-k);    
    }
}
