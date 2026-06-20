class Solution {
    private Integer[][] dp;

    public int change(int amount, int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        dp = new Integer[n + 1][amount + 1];
        return dfs(arr, 0, amount);
    }

    private int dfs(int[] arr, int idx, int target) {
        if (target < 0 || idx >= arr.length)
            return 0;
        if (target == 0)
            return 1;
        if (dp[idx][target] != null)
            return dp[idx][target];
        if(arr[idx] > target){
            return dp[idx][target] = dfs(arr,idx+1,target);
        }
        int take = dfs(arr, idx, target - arr[idx]);
        int skip = dfs(arr, idx + 1, target);
        return dp[idx][target] = take + skip;
    }
}