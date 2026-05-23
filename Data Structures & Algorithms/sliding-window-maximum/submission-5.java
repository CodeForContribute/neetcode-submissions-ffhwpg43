class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        int[]result = new int[n-k+1];
        // [1,2,1,0,4,2,6], k = 3
        // Output: [2,2,4,4,6]
        for(int i = 0; i < n-k+1; i++){
            int windowMax = arr[i];
            for(int j = i; j < i+k; j++){
                // window of size k
                // get the max from here
                windowMax = Math.max(arr[j], windowMax);
            }
            result[i] = windowMax;
        }
        return result;
    }
}
