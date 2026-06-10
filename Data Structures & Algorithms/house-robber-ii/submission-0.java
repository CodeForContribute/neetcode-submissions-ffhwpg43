class Solution {
    private int[]dp;
    public int rob(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        if(arr.length == 1)return arr[0];
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int a =  robLinear(arr,0,arr.length-2); // exclude last house
        Arrays.fill(dp,-1);
        int b =  robLinear(arr,1,arr.length-1); // exclude first house.
        return Math.max(a,b);
    }

    private int robLinear(int[]arr, int idx, int end){
        // base case
        if(idx > end)return 0;
        if(dp[idx] != -1)return dp[idx];
        return dp[idx] = Math.max(robLinear(arr,idx+1,end), arr[idx] + robLinear(arr,idx+2,end));
    }
}
