// class Solution {
//     public int search(int[] arr, int target) {
//         // binary search - one pass
//         if(arr == null || arr.length == 0)return -1;
//         int n = arr.length;
//         int left = 0, right = n-1;
//         while(left <= right){
//             int mid = left + ( right - left ) /2 ;
//             if(arr[mid] == target)return mid;
//             if(arr[left] <= arr[mid]){
//                 if(arr[left] <= target && target < arr[mid]){
//                     right = mid-1;
//                 }else left = mid+1;
//             }else {
//                 if(arr[mid] <= target && target < arr[right]){
//                     left = mid+1;
//                 }else right = mid-1;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int search(int[] arr, int target) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target)return mid;
            else if(arr[mid] >= arr[left]){
                if(target  >= arr[left] && target < arr[mid]){
                    right = mid-1;
                }else left = mid+1;
            }else {
                if(target <= arr[right] && target > arr[mid]){
                    left = mid+1;
                }else right = mid-1;
            }
        }
        return -1;
    }
}
