class Solution {
    private void backtrack(int open, int close, int n, List<String>result, StringBuilder stack){
        // base case
        // 3. open == close == n, add the built string to the result.
        if(open == close && open == n){
            result.add(stack.toString());
            return;
        }
        // if open < n, add '(' and recurse.
        if(open < n){
            stack.append('(');
            backtrack(open+1,close,n,result,stack);
            stack.deleteCharAt(stack.length()-1);
        }
        // 5. if close < open, add ')' and recurse.
        if(close < open){
            stack.append(')');
            backtrack(open,close+1,n,result,stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        // algo
        // 1. start with empty string.
        // 2. Track 
            //  open -> number of '(' used.
            //  close -> number of ')' used.
        // 3. open == close == n, add the built string to the result.
        // 4. if open < n, add '(' and recurse.
        // 5. if close < open, add ')' and recurse.
        // backtrack after each cahoice.
        List<String>result = new ArrayList();
        StringBuilder stack = new StringBuilder();
        backtrack(0,0,n,result,stack);
        return result;
    }
}
