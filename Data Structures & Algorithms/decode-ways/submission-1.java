class Solution {
    //private int[]dp;
    private Map<Integer,Integer>dp = new HashMap();
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)return 0;
        int n = s.length();
        //dp = new int[n];
        //Arrays.fill(dp,-1);
        //dp.put(s.length(),1);
        return dfs(s,0);
    }

    private int dfs(String s, int idx){
        if(idx == s.length())return 1;
        if(s.charAt(idx) == '0')return 0;
        if(dp.containsKey(idx))return dp.get(idx);
        int result = dfs(s,idx+1);
        if(idx < s.length()-1){
            if((s.charAt(idx) == '1') || ( s.charAt(idx) == '2' && s.charAt(idx+1) < '7')){
                result += dfs(s,idx+2);
            }
        }
        dp.put(idx,result);
        return result;
    }
}
