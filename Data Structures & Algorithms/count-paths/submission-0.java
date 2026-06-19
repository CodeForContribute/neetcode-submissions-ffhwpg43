class Solution {
    private int[][]dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[]d: dp)Arrays.fill(d, -1);
        return dfs(0,0,m,n);
    }

    private int dfs(int i, int j, int m, int n){
        if(i == m-1 && j == n-1)return 1;
        if(i >= m || j >= n)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        return dp[i][j] = dfs(i,j+1,m,n) + dfs(i+1, j,m,n);
    }
}
