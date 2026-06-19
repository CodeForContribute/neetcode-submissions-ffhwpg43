class Solution {
    public int maxSubArray(int[] arr) {
        int maxSum = arr[0], curSum = 0;
        for(int a : arr){
            if(curSum < 0){
                curSum = 0;
            }
            curSum += a;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
