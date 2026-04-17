class Solution {
    public int[] twoSum(int[] arr, int target) {
        if(arr == null || arr.length == 0)return new int[]{};
        int left = 0, right = arr.length-1;
        while(left <= right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            }else if(sum > target){
                right--;
            }else left++;
        }
        return new int[]{};
    }
}
