class Solution {
    private int[] stretch(int[]heights, boolean left){
        int n = heights.length;
        int[]result = new int[n];
        Stack<Integer>stack = new Stack();
        if(left){
            for(int i = 0; i < n;i++){
                result[i] = -1;
                while(!stack.isEmpty() && heights[stack.peek()]  >= heights[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    result[i] = stack.peek();
                }
                stack.push(i);
            }
        }else{
            for(int i = n-1; i >= 0; i--){
                result[i] = n;
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    result[i] = stack.peek();
                }
                stack.push(i);
            }
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)return 0;
        int[]leftMost = stretch(heights, true),rightMost = stretch(heights, false);
        int maxArea = 0, n = heights.length;
        for(int i = 0; i < n; i++){
            leftMost[i]++;
            rightMost[i]--;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i]+1));
        }
        return maxArea;
    }
}
