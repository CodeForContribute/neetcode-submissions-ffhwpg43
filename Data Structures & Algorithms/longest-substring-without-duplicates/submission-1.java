class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)return 0;
        int left = 0, right = 0,n = s.length(), ans = 0;
        int[]frq = new int[128];
        while(right < n){
            char ch = s.charAt(right);
            frq[ch]++;
            while(frq[ch] > 1){
                char c = s.charAt(left);
                frq[c]--;
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
