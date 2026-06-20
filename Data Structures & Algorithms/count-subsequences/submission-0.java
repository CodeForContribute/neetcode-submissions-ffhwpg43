class Solution {
    // dictionary that we will use for memo
    private Integer[][]dp;
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        dp = new Integer[m][n];
        return dfs(s,t,0,0);
    }

    private int dfs(String s, String t, int i, int j){
        //int m = s.length(), n = t.length();
        // base case
        if(i == s.length()  || j ==  t.length()){
            return j == t.length() ? 1 : 0;
        }
        if(dp[i][j] != null)return dp[i][j];
        int ans = dfs(s,t,i+1,j);
        if(s.charAt(i) == t.charAt(j)){
            ans += dfs(s,t,i+1,j+1);
        }
        dp[i][j] = ans;
        return ans;
    }
}