class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)return 0;
        Map<Character,Integer>mp = new HashMap();
        int n = s.length();
        int left = 0, ans = 0;
        for(int right = 0; right < n;right++){
            if(mp.containsKey(s.charAt(right))){
                left = Math.max(left, mp.get(s.charAt(right))+1);
            }
            mp.put(s.charAt(right),right);
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
