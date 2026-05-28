class Solution {
    public int search(int[] arr, int target) {
        if(arr == null || arr.length == 0)return -1;
        int n = arr.length;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + right - left/2;
            if(arr[mid] == target)return mid;

            if(arr[mid] >= arr[left]){
                if(arr[left] <= target && target < arr[mid]){
                    right = mid-1;
                }else left = mid+1;
            
            }else{
                if(target > arr[mid] && target <= arr[right]){
                    left = mid+1;
                }else right = mid-1;
            }
        }
        return -1;
    }
}
