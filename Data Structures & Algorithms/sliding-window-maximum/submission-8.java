class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        int[]result = new int[n-k+1];
        Deque<Integer>dq = new LinkedList();
        for(int i = 0; i < n; i++){
            // remove out of window elements first.
            if(!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.pollFirst();
            }
            /// maintain decreasing order.
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            // store result
            if(i + 1 >= k){
                // i = 2, k = 3, window - 1(0,1,2)
                // i = 3, k = 3, window - 2(1,2,3)
                result[i-k+1] = arr[dq.peekFirst()];
            }
        }
        return result;
        // if(arr == null || arr.length == 0)return new int[]{};
        // int n = arr.length;
        // int[]result = new int[n-k+1];
        // Deque<Integer>dq = new LinkedList();
        // for(int i = 0; i < n;i++){
        //     // remove out of window elements first
        //     if(!dq.isEmpty() && dq.peekFirst() == i-k){
        //         dq.pollFirst();
        //     }
        //     // maintain decreasing order 
        //     while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
        //         dq.pollLast();
        //     }
        //     dq.offerLast(i);

        //     // store the result
        //     if(i+1 >= k){
        //         result[i-k+1] = arr[dq.peekFirst()];
        //     }
        // }
        // return result;
    }
}
