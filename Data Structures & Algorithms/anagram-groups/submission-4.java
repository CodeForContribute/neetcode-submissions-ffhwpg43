class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)return new ArrayList();
        int m = strs.length;
        Map<String, List<String>>anagrams = new HashMap();
        for(String str: strs){
            int[]frq = new int[26];
            for(char ch: str.toCharArray()){
                frq[ch-'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int cnt : frq)keyBuilder.append(cnt).append("#");
            String key = keyBuilder.toString();
            anagrams.computeIfAbsent(key, r->new ArrayList()).add(str);
        }
        return new ArrayList(anagrams.values());
        // List<List<String>>result = new ArrayList();
        // result.addAll(anagrams.values());
        // return result;
    }
}
