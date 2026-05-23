class Solution {
    public int trap(int[] height) {
        // using stack
        if(height == null || height.length == 0)return 0;
        int result = 0;
        Stack<Integer>stack = new Stack();
        int n = height.length;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]){
                int mid = height[stack.pop()];
                if(!stack.isEmpty()){
                    int right = height[i];
                    int left = height[stack.peek()];
                    int h = Math.min(right,left)-mid;
                    int w = i-stack.peek()-1;
                    result += h * w;
                }
            }
            stack.push(i);
        }
        return result;
    }
}
