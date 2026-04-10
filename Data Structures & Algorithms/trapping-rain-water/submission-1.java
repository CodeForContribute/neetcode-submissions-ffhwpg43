class Solution {
    public int trap(int[] height) {
        // insight - for each position, the water trapped above it depends on the 
        // tallest bar to its left and the tallest bar to its right
        // min(leftMax, rightMax) - height[i]
        // if(height == null || height.length == 0)return 0;
        // int n = height.length;
        // int result = 0;
        // for(int i = 0; i < n;i++){
        //     int leftMax = height[i];
        //     int rightMax = height[i];
        //     for(int j = 0; j < i; j++){
        //         leftMax = Math.max(leftMax,height[j]);
        //     }
        //     for(int j = i+1; j < n; j++){
        //         rightMax = Math.max(rightMax, height[j]);
        //     }
        //     result += Math.min(leftMax, rightMax) - height[i];
        // }
        // return result;
        // prefix & suffix Arrays
        if(height == null || height.length == 0)return 0;
        int n = height.length;
        int result = 0;
        int[]leftMax = new int[n], rightMax = new int[n];
        // leftMax[i] = tallest bar from start up to index i
        // rightMax[i] = tallest bar from end up to index i
        // once we have these, the trapped water at position i is simply
        // trapped water at position i is simply
        // min(leftMax[i], rightMax[i]) - heigh[i];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[n-1] = height[n-1];
        for(int j = n-2; j >= 0; j--){
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }
        
        for(int i = 0; i < n; i++){
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }
}
