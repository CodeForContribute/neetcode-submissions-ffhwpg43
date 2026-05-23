class Solution {
    public boolean checkInclusion(String a, String b) {
        if(a == null &&  b == null)return true;
        if(a == null || b == null)return false;
        if(a.length() > b.length())return false;
        int m = a.length(), n = b.length();
        int[]aFrq = new int[26], bFrq = new int[26];
        int left = 0, right = 0;
        for(char ch : a.toCharArray())aFrq[ch-'a']++;
        while(right < n){
            char ch = b.charAt(right);
            bFrq[ch-'a']++;
            while(right - left + 1 > m){
                char c = b.charAt(left);
                bFrq[c-'a']--;
                left++;
            }
            if(right-left+1 == m && Arrays.equals(aFrq,bFrq))return true;
            right++;
        }
        return false;
    }
}
