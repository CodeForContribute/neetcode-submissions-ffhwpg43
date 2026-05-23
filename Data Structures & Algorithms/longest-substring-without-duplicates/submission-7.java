class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)return 0;
        int n = s.length();
        Map<Character,Integer>mp = new HashMap();
        int left = 0, right = 0,ans = 0;
        while(right < n){
            char ch = s.charAt(right);
            if(mp.containsKey(ch)){
                left = Math.max(mp.get(ch)+1, left);
            }
            mp.put(ch, right);
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
