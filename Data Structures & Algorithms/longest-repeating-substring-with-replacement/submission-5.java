class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0)return 0;
        int n = s.length();
        int left = 0, right = 0, ans = 0,maxfrq = 0;
        Map<Character,Integer>frq = new HashMap();
        while(right < n){
            char ch = s.charAt(right);
            frq.put(ch, frq.getOrDefault(ch,0)+1);
            maxfrq = Math.max(maxfrq,frq.get(ch));
            if((right-left+1) - maxfrq > k){
                char c = s.charAt(left);
                frq.put(c, frq.getOrDefault(c,0)-1);
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
