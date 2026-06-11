class Solution {
    private int[]dp;
    public int lengthOfLIS(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = 1;
        // dfs(i) - as the LIS length starting from index i
        for(int i = 0; i < n;i++){
            ans = Math.max(ans, dfs(arr,i));
        }
        return ans;
    }

    private int dfs(int[]arr, int idx){
        if(dp[idx] != -1)return dp[idx];
        int ans = 1;
        for(int j = idx+1; j < arr.length; j++){
            if(arr[idx] < arr[j]){
                ans = Math.max(ans,1 + dfs(arr,j));
            }
        }
        return dp[idx] = ans;
    }
}
