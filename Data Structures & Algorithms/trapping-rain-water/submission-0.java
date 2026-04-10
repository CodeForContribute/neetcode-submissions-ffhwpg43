class Solution {
    public int trap(int[] height) {
        // insight - for each position, the water trapped above it depends on the 
        // tallest bar to its left and the tallest bar to its right
        // min(leftMax, rightMax) - height[i]
        if(height == null || height.length == 0)return 0;
        int n = height.length;
        int result = 0;
        for(int i = 0; i < n;i++){
            int leftMax = height[i];
            int rightMax = height[i];
            for(int j = 0; j < i; j++){
                leftMax = Math.max(leftMax,height[j]);
            }
            for(int j = i+1; j < n; j++){
                rightMax = Math.max(rightMax, height[j]);
            }
            result += Math.min(leftMax, rightMax) - height[i];
        }
        return result;
    }
}
