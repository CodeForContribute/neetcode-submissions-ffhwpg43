class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)return new int[]{};
        Stack<Integer>stack = new Stack();
        int n = temperatures.length;
        int[]result = new int[n];
        for(int i = 0 ; i < n; i++){
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > temperatures[stack.peek()]){
                int days = i - stack.peek();
                result[stack.peek()] = days;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
