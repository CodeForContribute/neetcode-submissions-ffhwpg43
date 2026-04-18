class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty())return "";
        Map<Character,Integer>countT = new HashMap();
        Map<Character,Integer>window = new HashMap();
        for(char ch : t.toCharArray()){
            countT.put(ch, countT.getOrDefault(ch,0)+1);
        }
        int need = countT.size();
        int have = 0;
        int left = 0, right = 0, n = s.length(), ans = Integer.MAX_VALUE;
        int[]result = {-1,-1};
        while(right < n){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch,0)+1);
            if(countT.containsKey(ch) && countT.get(ch).equals(window.get(ch)))have++;
            while(have == need){
                if((right-left+ 1) < ans){
                    ans = right-left+1;
                    result = new int[]{ left, right};
                }
                char c = s.charAt(left);
                window.put(c, window.getOrDefault(c,0)-1);
                if(countT.containsKey(c) && countT.get(c) > window.get(c))have--;
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1]+1);
    }
}
