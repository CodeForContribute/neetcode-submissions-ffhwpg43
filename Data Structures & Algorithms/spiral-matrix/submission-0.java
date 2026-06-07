class Solution {
    public List<Integer> spiralOrder(int[][] grid) {
        if(grid == null || grid.length ==0)return new ArrayList();
        int left = 0, right = grid[0].length;
        int top = 0, bottom = grid.length;
        List<Integer>result = new ArrayList();

        while(left < right && top < bottom){

            for(int c = left ; c < right; c++){
                result.add(grid[top][c]);
            }
            top++;
            for(int r = top; r < bottom; r++){
                result.add(grid[r][right-1]);
            }
            right--;
            if(!(left < right && top < bottom))break;
            for(int c = right-1; c >= left; c--){
                result.add(grid[bottom-1][c]);
            }
            bottom--;
            for(int r = bottom-1; r >= top; r--){
                result.add(grid[r][left]);
            }
            left++;
        }
        return result;
    }
}
