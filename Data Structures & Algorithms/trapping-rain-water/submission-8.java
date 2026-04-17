class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)return 0;
        int n = height.length;
        Stack<Integer>stack = new Stack();
        int result = 0;
        for(int i = 0; i < n;i++){
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]){
                int mid = height[stack.pop()];
                if(!stack.isEmpty()){
                    int right = height[i];
                    int left = height[stack.peek()];
                    int h = Math.min(left, right) - mid;
                    int w = i - stack.peek() - 1;
                    result += ( h * w);
                }
            }
            stack.push(i);
        }
        return result;
    }
}
