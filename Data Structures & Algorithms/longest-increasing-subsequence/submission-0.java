class Solution {
    private int[][]dp;

    public int lengthOfLIS(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        dp = new int[n][n+1];
        for(int[]row: dp){
            Arrays.fill(row,-1);
        }
        return dfs(arr,0,-1);
    }
    private int dfs(int[]arr, int curIdx, int prevIdx){
        // base case
        if(curIdx == arr.length)return 0;
        if(dp[curIdx][prevIdx+1] != -1)return dp[curIdx][prevIdx+1];
        // not take
        int result = dfs(arr,curIdx+1, prevIdx);
        // take it only if the condition is valid.
        if(prevIdx == -1 || arr[prevIdx] < arr[curIdx]){
            result = Math.max(result, 1 + dfs(arr,curIdx+1,curIdx));
        }
        return dp[curIdx][prevIdx+1] = result;
    }
}
