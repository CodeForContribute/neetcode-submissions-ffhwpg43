class Solution {
    private Map<Integer,Boolean>dp = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)return true;
        Set<String>wordSet = new HashSet(wordDict);
        int n = s.length();
        //dp = new boolean[n];
        return dfs(s,wordSet,0);
    }
    private boolean dfs(String s, Set<String>wordSet, int idx){
        if(idx >= s.length())return true;
        if(dp.containsKey(idx))return dp.get(idx);
        boolean result = false;
        // for(int i = idx; i < s.length();i++){
        //     String sub = s.substring(idx,i+1);
        //     if(wordSet.contains(sub) && dfs(s,wordSet,i+1)){
        //         result = true;
        //         break;
        //     }
        // }
        for(String word: wordSet){
            if(idx + word.length() <= s.length() && s.substring(idx, idx+word.length()).equals(word)){
                if(dfs(s,wordSet,idx+word.length())){
                    dp.put(idx,true);
                    return true;
                }
            }
        }
        dp.put(idx,false);
        return false;
    }
}
