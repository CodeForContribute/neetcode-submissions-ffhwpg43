class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int m = a.length(),n = b.length();
        int[][]dp = new int[m+1][n+1];
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
