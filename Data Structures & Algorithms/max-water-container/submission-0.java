class Solution {
    public int maxArea(int[] heights) {
        if(heights == null || heights.length == 0)return 0;
        int n = heights.length;
        int result = 0;
        for(int i = 0 ; i < n;i++){
            for(int j = i+1; j < n;j++){
                result = Math.max(result, Math.min(heights[j], heights[i])* (j-i));
            }
        }
        return result;
    }
}
