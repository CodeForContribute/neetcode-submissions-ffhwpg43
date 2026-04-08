class Solution {
    public int search(int[] arr, int target) {
        if(arr == null || arr.length == 0)return -1;
        int n = arr.length;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target)return mid;
            else if(arr[mid] > target)right--;
            else left++;
        }
        return -1;
    }
}
