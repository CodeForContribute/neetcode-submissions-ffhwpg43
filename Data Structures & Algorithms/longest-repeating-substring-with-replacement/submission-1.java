class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0)return 0;
        int ans = 0, n = s.length();
        Set<Character>unq = new HashSet();
        // put all the chars first in set
        for(char ch : s.toCharArray())unq.add(ch);
        for(char ch : s.toCharArray()){
            int cnt = 0, left = 0, right = 0;
            // for every char - do the sliding window
            // assuming this char is the max occuring chars.
            while(right < n){
                char c = s.charAt(right);
                if(c == ch)cnt++;
                // shrink the window if the remaining chars aper
                while((right-left+1) - cnt > k){
                    char cc = s.charAt(left);
                    if(cc == ch)cnt--;
                    left++;
                }
                ans = Math.max(ans, right-left+1);
                right++;
            }
        }
        return ans;
    }
}
