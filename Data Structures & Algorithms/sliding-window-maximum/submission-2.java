class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        int[]result = new int[n-k+1];
        Deque<Integer>dq = new LinkedList();
        
        for(int i = 0; i < n;i++){
            // remove out of window
            if(!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.pollFirst();
            }
            // maintain decreasing order
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            // Store result
            if(i >= k-1){
                result[i+1-k] = arr[dq.peekFirst()];
            }
        }
        
        return result;
    }
}


