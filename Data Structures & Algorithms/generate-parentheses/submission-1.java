class Solution {
    private boolean isValid(String s){
        int open = 0;
        for(char ch : s.toCharArray()){
            open += ch == '(' ? 1 : -1;
            if(open < 0)return false;
        }
        return open == 0;
    }

    private void dfs(String s, List<String>result, int n){
        if( 2 * n == s.length()){
            if(isValid(s))result.add(s);
            return;
        }
        dfs(s + '(', result, n);
        dfs(s + ')', result, n);
    }

    public List<String> generateParenthesis(int n) {
        List<String>result = new ArrayList();
        dfs("", result, n);
        return result;
    }
}
