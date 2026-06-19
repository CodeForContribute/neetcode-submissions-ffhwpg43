class Solution {
    private Integer[]dp;
    public int jump(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        dp = new Integer[n];
        Arrays.fill(dp,-1);
        return dfs(arr,0);
    }
    private int dfs(int[]arr, int idx){
        if(idx == arr.length-1)return 0;
        int ans = Integer.MAX_VALUE;
        if(arr[idx] == 0)return ans;
        if(dp[idx] != -1)return dp[idx];
        int end = Math.min(arr.length, idx + arr[idx]+1);

        for(int j = idx+1; j < end;j++){
            int val = dfs(arr,j);
            ans = Math.min(ans, val == Integer.MAX_VALUE ? Integer.MAX_VALUE : val + 1);
        }
        return  dp[idx] = ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
