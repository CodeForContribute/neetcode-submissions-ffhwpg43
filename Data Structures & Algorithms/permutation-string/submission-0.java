class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null && s2 == null)return true;
        if(s1 == null || s2 == null)return false;
        if(s1.length() > s2.length())return false;
        int k = s1.length(), n = s2.length();
        int[]s1CharFrq = new int[26];
        for( char ch : s1.toCharArray())s1CharFrq[ch-'a']++;
        int left = 0, right = 0;
        int[]permuteFrq = new int[26];
        while(right < n){
            char ch = s2.charAt(right);
            permuteFrq[ch-'a']++;
            while(right - left + 1 > k){
                char c = s2.charAt(left);
                permuteFrq[c-'a']--;
                left++;
            }
            if(right - left + 1 == k && Arrays.equals(permuteFrq,s1CharFrq))return true;
            right++;
        }
        return false;
    }
}
