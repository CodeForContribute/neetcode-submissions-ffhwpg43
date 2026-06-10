class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, maxlen = 0;
        for(int i = 0; i < n;i++){
            // odd length
            int len1 = expand(s,i,i);
            // even length
            int len2 = expand(s,i,i+1);
            int len = Math.max(len1, len2);
            if(len > maxlen){
                maxlen = len;
                start = i - (len-1)/2;
            }
        }
        return s.substring(start,start+maxlen);
        // int start = 0, maxLen = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     int len1 = expand(s, i, i);
        //     int len2 = expand(s, i, i + 1);
        //     int len = Math.max(len1, len2);
        //     if (len > maxLen) {
        //         maxLen = len;
        //         start = i - (len - 1) / 2;
        //     }
        // }
        // return s.substring(start, start + maxLen);
    }
    private int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;right++;
        }
        return right-left-1;
    }
    // private int expand(String s, int l, int r) {
    //     while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    //         l--;
    //         r++;
    //     }
    //     return r - l - 1;
    // }
}