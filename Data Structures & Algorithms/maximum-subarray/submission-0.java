class Solution {
    public int maxSubArray(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int maxVal = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n;j++){
                sum += arr[j];
                maxVal = Math.max(maxVal, sum);
            }
        }
        return maxVal;
    }
}
