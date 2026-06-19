class Solution {
    public boolean canJump(int[] arr) {
        int n = arr.length;
        boolean[]dp = new boolean[n];
        dp[n-1] = true;
        for(int i = n-2 ; i>= 0; i--){
            boolean possible = false;
            for(int j = i + 1; j <= Math.min(n-1,i+arr[i]); j++){
                if(dp[j]){
                    possible = true;
                    break;
                }
            }
            if(possible){
                dp[i] = true;
            }
        }
        return dp[0];
    }
}
