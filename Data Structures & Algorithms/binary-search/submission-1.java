class Solution {
    public int search(int[] arr, int target) {
        if(arr == null || arr.length == 0)return -1;
        return binarySearch(arr,0,arr.length-1,target);
    }
    private int binarySearch(int[]arr, int left, int right, int target){
        // base condition
        if(left > right)return -1;
        int mid = left + (right-left)/2;
        if(arr[mid] == target)return mid;
        if(arr[mid] > target){
            return binarySearch(arr,left,mid-1,target);
        }else return binarySearch(arr,mid+1, right, target);
    }
}
