class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)return new ArrayList();
        int m = strs.length;
        Map<String,List<String>>anagramStringMap = new HashMap();
        for(String str: strs){
            char[]ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
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
