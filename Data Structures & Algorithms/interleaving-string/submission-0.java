class Solution {
    private int[][]dp;
    public boolean isInterleave(String a, String b, String c) {
        if(a.length() + b.length() != c.length())return false;
        int m = a.length(), n = b.length();
        dp = new int[m][n];
        for(int[]d:dp)Arrays.fill(d,-1);
        // return dfs(a,b,0,0,"",c);
        return dfs(a,0,b,0,c,0);
    }

    private boolean dfs(String a, int i, String b, int j, String c, int k){
        if(i == a.length()){
            return b.substring(j).equals(c.substring(k));
        }
        if(j == b.length()){
            return a.substring(i).equals(c.substring(k));
        }
        if(dp[i][j] != -1)return dp[i][j] == 1 ? true:false;
        boolean ans = false;
        if(a.charAt(i) == c.charAt(k)){
            ans |= dfs(a,i+1,b,j,c,k+1);
        }
        if(b.charAt(j) == c.charAt(k)){
            ans |= dfs(a,i,b,j+1,c,k+1);
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    // private boolean dfs(String a, String b, int i, int j, String result, String c){
    //     //if(i == a.length() && j == b.length() && result.equals(c))return true;
    //     if(i == a.length()){
    //         return b.substring(j)
    //     }
    //     if(dp[i][j] >= 0)return dp[i][j] == 1 ? true : false;
    //     boolean ans = false;
    //     if(i < a.length()){
    //         ans |= dfs(a,b,i+1,j,result + a.charAt(i),c);
    //     }
    //     if(j < b.length()){
    //         ans |= dfs(a,b,i,j+1,result + b.charAt(j),c);
    //     }
    //     dp[i][j] = ans ? 1 : 0;
    //     return ans;
    // }
}