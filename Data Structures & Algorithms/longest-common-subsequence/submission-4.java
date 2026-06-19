class Solution {
    public int longestCommonSubsequence(String a, String b) {
        if(a.length() < b.length())swap(a,b);
        int m = a.length(), n = b.length();
        int[]dp = new int[b.length()+1];

        for(int i = m-1; i >= 0; i--){
            int prev = 0;
            for(int j = n-1; j >= 0; j--){
                int tmp = dp[j];
                if(a.charAt(i) == b.charAt(j)){
                    dp[j] = 1 + prev;
                }else{
                    dp[j] = Math.max(dp[j], dp[j+1]);
                }
                prev = tmp;
            }
        }
        return dp[0];
    }

    private <T> void swap(T a, T b){
        T tmp = a;
        a = b;
        b = tmp;
    }
}
