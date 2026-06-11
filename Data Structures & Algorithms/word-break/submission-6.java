class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // bottom up
        if(s == null || s.length() == 0)return true;
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[s.length()] = true;

        for(int i = s.length()-1; i >= 0; i--){
            for(String word: wordDict){
                if(i + word.length() <= n && s.substring(i,i+word.length()).equals(word)){
                    dp[i] = dp[i + word.length()];
                }
                if(dp[i])break;
            }
        }
        return dp[0];
    }
}
