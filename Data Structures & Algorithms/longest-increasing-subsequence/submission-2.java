class Solution {
    public int lengthOfLIS(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = n-1; i >= 0; i--){
            for(int j = i +1; j < n;j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
            }
        }
        int ans = 0;
        for(int a : dp){
            ans = Math.max(ans,a);
        }
        return ans;
    }
}
