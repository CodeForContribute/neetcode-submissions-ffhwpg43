class Solution {
    private int[][]dp;
    public int minDistance(String a, String b) {
        // insert a character -> dfs(a,b,i,j+1);
        // delete a character -> dfs(a,b,i+1,j);
        // replace a character -> dfs(a,b,i+1, j+1);
        int m = a.length(), n = b.length();
        dp = new int[m][n];
        for(int[]d:dp)Arrays.fill(d,-1);
        return dfs(a,b,0,0);
    }

    private int dfs(String a, String b, int i, int j){
        // base case
        if(i == a.length())return b.length()-j; // insert the remaining characters in a to form b
        if(j == b.length())return a.length()-i; // delete the remaing characters from a to form b
        if(dp[i][j] != -1)return dp[i][j];
        int val = -1;
        if(a.charAt(i) == b.charAt(j)){
            val = dfs(a,b,i+1,j+1);
        }else{
            val = 1 + Math.min(dfs(a,b,i,j+1),Math.min(dfs(a,b,i+1,j),dfs(a,b,i+1,j+1)));
        }
        return dp[i][j] = val;
    }
}