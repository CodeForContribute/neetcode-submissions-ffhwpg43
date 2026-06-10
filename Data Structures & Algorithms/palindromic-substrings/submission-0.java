class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)return 0;
        int ans = 0, n = s.length();
        for(int i = 0; i < n; i++){
            // odd lengths
            ans += expand(s,i,i);
            ans += expand(s,i,i+1);
        }
        return ans;
    }

    private int expand(String s, int left, int right){
        int res = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            res++;
        }
        return res;
    }
}
