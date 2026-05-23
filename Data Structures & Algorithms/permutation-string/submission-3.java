class Solution {
    public boolean checkInclusion(String a, String b) {
        // b contains perm of a ? 
        if(a ==  null || a.length() == 0)return true;
        int[]frqa = new int[26],frqb = new int[26];
        for(char ch : a.toCharArray())frqa[ch-'a']++;
        int left = 0, right = 0, n = b.length();
        while(right < n){
            char ch = b.charAt(right);
            frqb[ch-'a']++;
            while(right-left+1 > a.length()){
                char c = b.charAt(left);
                frqb[c-'a']--;
                left++;
            }
            if(right-left+1 == a.length() && Arrays.equals(frqa, frqb))return true;
            right++;
        }
        return false;
    }
}
