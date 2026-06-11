class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)return 0;
        int n = s.length();
        // dp[i] depends only one dp[i+1] and dp[i+2];
        // dp1 - ways to decode from i+1;
        // dp2 - ways to decode from i+2;
        // at each idx, we compute the current ans using these 2 values, then shift them forward.
        int dp1 = 1, dp2 = 0, dp = 0;

        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                dp = 0;
            }else{
                dp = dp1;
                if(i+1 < n && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')){
                    dp += dp2;
                }
            }
            dp2 = dp1;
            dp1 = dp;
            dp = 0;
        }
        return dp1;
    }
}
