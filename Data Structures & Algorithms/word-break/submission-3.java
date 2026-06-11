class Solution {
    private Map<Integer,Boolean>dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)return true;
        dp = new HashMap();
        dp.put(s.length(), true);
        return dfs(s,wordDict,0);
    }

    private boolean dfs(String s, List<String>wordDict, int idx){
        if(dp.containsKey(idx))return dp.get(idx);
        for(String word: wordDict){
            if(idx + word.length() <= s.length() && s.substring(idx, idx+word.length()).equals(word)){
                if(dfs(s,wordDict, idx+word.length())){
                    dp.put(idx, true);
                    return true;
                }
            }
        }
        dp.put(idx, false);
        return false;
    }
}
