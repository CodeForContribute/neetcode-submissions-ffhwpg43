class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0)return 0;
        int n = s.length();
        // brute force
        // idea is to try every possible substring starting at every index.
        int ans = 0;
        for(int i = 0; i < n; i++){
            Map<Character,Integer>cnt = new HashMap();
            int maxf = 0;
            for(int j = i; j < n;j++){
                cnt.put(s.charAt(j), cnt.getOrDefault(s.charAt(j),0)+1);
                maxf = Math.max(maxf,cnt.get(s.charAt(j)));
                if((j-i+1) - maxf <= k){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
