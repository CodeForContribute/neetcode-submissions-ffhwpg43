class Solution {
    private int[]dp;
    public int rob(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return dfs(arr,0);
    }
    private int dfs(int[]arr, int idx){
        if(idx >= arr.length)return 0;
        if(dp[idx] != -1)return dp[idx];
        return dp[idx] = Math.max(dfs(arr,idx+1),arr[idx] + dfs(arr,idx+2));
    }
}
