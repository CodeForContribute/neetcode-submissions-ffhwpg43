class Solution {
    public int largestRectangleArea(int[] heights) {
        // write brute force first
        if(heights == null || heights.length == 0)return 0;
        int n = heights.length;
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int height = heights[i];
            int right = i + 1;
            while(right < n && heights[right] >= height){
                right++;
            }
            int left = i;
            while(left >= 0 && heights[left] >= height){
                left--;
            }
            right--;
            left++;
            maxArea = Math.max(maxArea, height * (right-left+1));
        }
        return maxArea;
    }
}
