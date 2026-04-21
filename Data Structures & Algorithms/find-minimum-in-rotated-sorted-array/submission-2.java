class Solution {
    public int findMin(int[] arr) {
        // in rotated sorted arr , min element is the first element of 
        // the rotated portion
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        int left = 0, right = n-1;
        while(left < right){
            int mid = left + ( right - left)/2;
            if(arr[mid] < arr[right]){
                // check the lower bound in left side,including mid
                right = mid;
            }else left = mid+1;
        }
        return arr[left];
    }
}
