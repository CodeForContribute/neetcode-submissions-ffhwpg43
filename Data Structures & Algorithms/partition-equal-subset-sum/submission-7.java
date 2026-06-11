class Solution {
    private Boolean[][]dp;
    public boolean canPartition(int[] arr) {
        if(arr == null || arr.length == 0)return true;
        int sum = 0;
        for(int a: arr)sum += a;
        if(sum % 2 != 0)return false;
        int n = arr.length;
        dp = new Boolean[n][sum/2+1];
        return dfs(arr,0,sum/2);
    }

    private boolean dfs(int[]arr, int idx, int target){
        if(idx == arr.length)return target == 0;
        if(target < 0)return false;
        if(dp[idx][target] != null)return dp[idx][target];
        return dp[idx][target] = dfs(arr,idx+1,target) || dfs(arr,idx+1,target-arr[idx]);
    }
}
