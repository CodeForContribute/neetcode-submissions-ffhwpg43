class Solution {
    public boolean isAnagram(String s, String t) {
        // first length must be same
        // chars inside both strings must be same
        if(s == null && t == null)return true;
        if(s == null || t == null)return false;
        int m = s.length(), n = t.length();
        if(m != n)return false;
        char[]sChars = s.toCharArray();
        char[]tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for(int i = 0; i < m;i++){
            if(sChars[i] != tChars[i])return false;
        }
        return true;
    }
}
