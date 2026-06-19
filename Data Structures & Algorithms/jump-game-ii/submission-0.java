class Solution {
    private int[]dp;

    public int jump(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1] = 0;

        for(int i = n-2; i >= 0; i--){
            int end = Math.min(arr.length, i + arr[i]+1);
            for(int j = i + 1 ; j < end; j++){
                if(dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[0];
    }
}
