class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)return 0;
        List<String>tokenList = new ArrayList(Arrays.asList(tokens));
        return dfs(tokenList);
    }

    //  ["1","2","+","3","*","4","-"]
    private int dfs(List<String>tokens){
        String token = tokens.remove(tokens.size()-1);
        if(!"+-*/".contains(token)){
            return Integer.parseInt(token);
        }

        int right = dfs(tokens); // 2, 3, 4
        int left = dfs(tokens); // 1, 3, 9
        int result = switch(token){
            case "+" -> left + right;
            case "-"-> left-right;
            case "*"-> left * right;
            case "/" -> left / right;
            default -> 0;
        };
        return result;
    }
}
