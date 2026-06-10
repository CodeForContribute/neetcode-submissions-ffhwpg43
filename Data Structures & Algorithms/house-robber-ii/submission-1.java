class Solution {
    public int rob(int[] arr) {
        // bottom up
        if(arr == null || arr.length == 0)return 0;
        if(arr.length == 1)return arr[0];
        return Math.max(dfs(Arrays.copyOfRange(arr,1,arr.length)),
                            dfs(Arrays.copyOfRange(arr,0,arr.length-1))
                            );
    }

    private int dfs(int[]arr){
        if(arr.length == 0)return 0;
        if(arr.length == 1)return arr[0];
        int n = arr.length;
        int[]dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i = 2; i < n;i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }
        return dp[n-1];
    }
}
