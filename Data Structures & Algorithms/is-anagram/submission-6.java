class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null)return true;
        if(s == null || t == null)return false;
        int m = s.length(), n = t.length();
        if(m != n)return false;
        Map<Character,Integer>sCharFrq = new HashMap();
        Map<Character,Integer>tCharFrq = new HashMap();
        for(char ch : s.toCharArray())sCharFrq.put(ch, sCharFrq.getOrDefault(ch,0)+1);
        for(char ch : t.toCharArray())tCharFrq.put(ch, tCharFrq.getOrDefault(ch,0)+1);
        for(char ch : s.toCharArray()){
            if (!sCharFrq.getOrDefault(ch, 0).equals(tCharFrq.getOrDefault(ch, 0))) {
                return false;
            }
        }
        return true;
        //return sCharFrq.equals(tCharFrq);
    }
}
