class Solution {
    private Map<Integer,Boolean>dp;
    private Set<String>wordSet;
    private int t;

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)return true;
        dp = new HashMap();
        wordSet = new HashSet(wordDict);
        dp.put(s.length(), true);

        t = 0;
        for(int i = 0; i < wordDict.size();i++){
            t = Math.max(t,wordDict.get(i).length());
        }

        return dfs(s,wordSet,0);
    }

    private boolean dfs(String s, Set<String>wordSet, int idx){
        if(idx == s.length())return true;
        if(dp.containsKey(idx))return dp.get(idx);
        for(int i = idx; i < Math.min(s.length(), idx+t); i++){
            if(wordSet.contains(s.substring(idx, i+1))){
                if(dfs(s,wordSet,i+1)){
                    dp.put(idx,true);
                    return true;
                }
            }
        }
        dp.put(idx, false);
        return false;
    }
}
