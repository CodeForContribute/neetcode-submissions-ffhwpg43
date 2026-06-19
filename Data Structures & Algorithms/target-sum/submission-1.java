class Solution {
    private int[][]dp;
    private int totalSum = 0;
    public int findTargetSumWays(int[] arr, int target) {
        if(arr == null || arr.length == 0)return 0;
        for(int a: arr)totalSum += a;
        int n = arr.length;
        dp = new int[n][2*totalSum+1];
        for(int r = 0; r < n; r++){
            for(int c = 0;c < 2*totalSum+1;c++){
                dp[r][c] = Integer.MIN_VALUE;
            }
        }
        return dfs(arr,target,0,0);
    }

    private int dfs(int[]arr, int target, int sum, int idx){
        // base case
        if(idx >= arr.length){
            if(sum == target)return 1;
            else return 0;
        }
        if(dp[idx][sum+totalSum] != Integer.MIN_VALUE)return dp[idx][sum+totalSum];
        int val = dfs(arr,target, sum + arr[idx],idx+1) 
           + dfs(arr,target, sum-arr[idx],idx+1);
        return dp[idx][sum+totalSum] = val;
    }
}
