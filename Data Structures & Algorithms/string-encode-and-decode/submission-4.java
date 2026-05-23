class Solution {

    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0)return "";
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()).append('@').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String>result = new ArrayList();
        int i = 0, n = str.length();
        while(i < n){
            int j = i;
            while(j < n && str.charAt(j) != '@')j++;
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i,j));
            i = j;
        }
        return result;
        // List<String>result = new ArrayList();
        // int i =0;
        // int n = str.length();
        // while(i < n){
        //     int j = i;
        //     while(j < n && str.charAt(j) != '#')j++;
        //     int length = Integer.parseInt(str.substring(i,j));
        //     i = j + 1;
        //     j = i + length;
        //     result.add(str.substring(i,j));
        //     i = j;
        // }
        // return result;
    }
}
