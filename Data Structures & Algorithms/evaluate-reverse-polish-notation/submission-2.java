class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)return 0;
        Set<String>operators = Set.of("+","-","*","/");
        Stack<Integer>stack = new Stack();
        for(String token: tokens){
            if(operators.contains(token)){
                int top = stack.pop();
                int prevTop = stack.pop();
                int result = switch(token){
                    case "+" -> top + prevTop;
                    case "-" -> prevTop-top;
                    case "*" -> prevTop * top;
                    case "/" -> prevTop/top;
                    default -> 0;
                };
                stack.push(result);
            }else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
        // if(tokens == null || tokens.length == 0)return 0;
        // Set<String>operators = Set.of("+", "-","*","/");
        // Stack<Integer>stack = new Stack();
        // for(String token : tokens){
        //     if(operators.contains(token)){
        //         int top = stack.pop();
        //         int prevTop = stack.pop();
        //         int result = 0;
        //         if(token.equals("+")){
        //             result = (top + prevTop);
        //         }else if ( token.equals("-")){
        //             result = (prevTop-top);
        //         }else if( token.equals("*")){
        //             result = (top * prevTop);
        //         }else {
        //             result = (prevTop / top);
        //         }
        //         stack.push(result);
        //     }else{
        //         stack.push(Integer.parseInt(token));
        //     }
        // }
        // return stack.pop();
    }
}
