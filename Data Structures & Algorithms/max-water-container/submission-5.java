class Solution {
    public int maxArea(int[] heights) {
        if(heights == null || heights.length == 0)return 0;
        int n = heights.length;
        int left = 0, right = n-1;
        int result = 0;
        while(left < right){
            int area = Math.min(heights[left], heights[right]) * ( right-left);
            result = Math.max(result,area);
            if(heights[left] < heights[right])left++;
            else right--;
        }
        return result;
        // if(heights == null || heights.length == 0)return 0;
        // int n = heights.length;
        // int left = 0, right = n-1;
        // int result = 0;
        // while(left < right){
        //     int area = Math.min(heights[left], heights[right]) * ( right - left);
        //     result = Math.max(result, area);
        //     if(heights[left] < heights[right])left++;
        //     else right--;
        // }
        // return result;
    }
}
