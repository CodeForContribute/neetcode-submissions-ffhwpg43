class Solution {
    public int search(int[] arr, int target) {
        // binary search - two pass
        // 1. first binary search:
        // - find the pivot - the index of the smallest element.
        // this tells us where the arr was rotated.
        // 2 - second binary search
        // decide which sorted half may contain the target.
        // then run a standard binary search only on that half.
        if(arr == null || arr.length == 0)return -1;
        int n = arr.length;
        int left = 0, right = n-1;
        while(left < right){
            int mid = left + ( right - left ) /2 ;
            if(arr[mid] >= arr[right]){
                left = mid + 1;
            }else right = mid;
        }
        int pivot = left;
        left = 0;right = n-1;
        if(target >= arr[pivot] && target <= arr[right]){
            left = pivot;
        }else right = pivot-1;

        while(left <= right){
            int mid = left + ( right - left ) /2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else right = mid-1;
        }
        return -1;
    }
}
