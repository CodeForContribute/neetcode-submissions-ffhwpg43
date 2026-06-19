class Solution {
    private int[][]dp;
    public int longestCommonSubsequence(String a, String b) {
        int m = a.length(), n = b.length();
        dp = new int[m][n];
        for(int[]d: dp)Arrays.fill(d, -1);
        return dfs(a,b,0,0);
    }

    private int dfs(String a, String b, int i, int j){
        if(i == a.length() || j == b.length())return 0;
        if(dp[i][j] != -1)return dp[i][j];
        if(a.charAt(i) == b.charAt(j)){
            dp[i][j] = 1 + dfs(a,b,i+1,j+1);
        }else {
            dp[i][j] = Math.max(dfs(a,b,i+1,j) , dfs(a,b,i,j+1));;
        }
        return dp[i][j];
    }
}
