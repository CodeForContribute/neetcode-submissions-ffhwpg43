class Solution {
    public int[] dailyTemperatures(int[] temps) {
        if(temps == null || temps.length == 0)return new int[]{};
        Stack<Integer>stack = new Stack();
        int n = temps.length;
        int[]result = new int[n];
        for(int i = 0; i < n;i++){
            int tmp = temps[i];
            while(!stack.isEmpty() && tmp > temps[stack.peek()]){
                int days = i - stack.peek();
                result[stack.peek()] = days;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
