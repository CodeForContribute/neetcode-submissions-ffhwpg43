class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result = new ArrayList();
        if(s == null || s.length() == 0)return result;
        int n = s.length();
        backtrack(s,0,new ArrayList(),result);
        return result;
    }

    private void backtrack(String s, int idx, List<String>cur, List<List<String>>result){
        // base case
        if(idx == s.length()){
            result.add(new ArrayList(cur));
            return;
        }
        for(int i = idx+1; i <= s.length();i++){
            String piece = s.substring(idx, i);
            if(!validPalindrome(piece))continue;
            cur.add(piece);
            backtrack(s,i,cur,result);
            cur.remove(cur.size()-1);
        }
    }

    private boolean validPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;right--;
        }
        return true;
    }
}
