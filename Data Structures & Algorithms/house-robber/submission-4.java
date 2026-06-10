class Solution {
    private int[]dp;
    public int rob(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        // dp = new int[n];
        // Arrays.fill(dp,-1);
        // return dfs(arr,0);
        // bottom up
        // for each house idx, the max money we can have depends on
        // not robbing it - same money as idx-1
        // robbing it - money at idx + best up to idx-2
        // handle edge cases - no house - return 0;
        // one house - return its value.
        if(arr.length == 1)return arr[0];
        int[]dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i = 2; i < n;i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }
        return dp[n-1];
    }
    private int dfs(int[]arr, int idx){
        if(idx >= arr.length)return 0;
        if(dp[idx] != -1)return dp[idx];
        dp[idx] = Math.max(dfs(arr,idx+1), arr[idx] + dfs(arr, idx+2));
        return dp[idx];
    }
}
