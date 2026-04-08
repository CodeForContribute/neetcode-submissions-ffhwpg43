class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)return new ArrayList();
        int m = strs.length;
        Map<String,List<String>>anagramStringMap = new HashMap();
        for(String str: strs){
            int[]frq = new int[26];
            for(char ch : str.toCharArray()){
                frq[ch-'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int cnt: frq)keyBuilder.append(cnt).append("#");
            String key = keyBuilder.toString();
            // Arrays.sort(ch);// nlogn
            // String key = new String(ch);
            // Grouping logic
            if(!anagramStringMap.containsKey(key)){
                anagramStringMap.put(key, new ArrayList());
            }
            anagramStringMap.get(key).add(str);
        }
        List<List<String>>result = new ArrayList();
        for(Map.Entry<String,List<String>>e:anagramStringMap.entrySet()){
            result.add(e.getValue());
        }
        return result;
    }
}
