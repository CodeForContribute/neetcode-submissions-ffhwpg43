class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty())return "";
        int n = s.length();
        int left = 0, right = 0,ans= Integer.MAX_VALUE;
        Map<Character,Integer>cntT = new HashMap();
        Map<Character, Integer>cntS = new HashMap();
        for(char ch : t.toCharArray())cntT.put(ch, cntT.getOrDefault(ch,0)+1);
        int need = cntT.size();
        int have = 0;
        int[]result = {-1,-1};
        while(right < n){
            char ch = s.charAt(right);
            cntS.put(ch, cntS.getOrDefault(ch,0)+1);
            if(cntT.containsKey(ch) && cntT.get(ch) == cntS.get(ch))have++;
            while(have == need){
                if(right-left+1 < ans){
                    ans = right-left+1;
                    result = new int[]{left, right};
                }
                char c = s.charAt(left);
                cntS.put(c, cntS.getOrDefault(c, 0)-1);
                if(cntT.containsKey(c) && cntT.get(c) > cntS.get(c))have--;
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? "": s.substring(result[0], result[1]+1);
    }
}
