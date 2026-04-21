class Solution {
    public int search(int[] arr, int target) {
        // find the pivot - min element 
        // after finding the pivot - the arr becomes
        // a sorted left half and sorted right half.
        // we can perform bs on the correct half where the 
        // target could lie.
        if(arr == null || arr.length == 0)return -1;
        int n = arr.length;
        int left = 0, right = n -1;
        // find min/pivot 
        while(left < right){
            int mid = left + ( right - left)/2;
            if(arr[mid] < arr[right]){
                right = mid;
            }else left = mid+1;
        }
        int pivot = left;

        int result = bs(arr,target,0,pivot-1);
        if(result != -1){
            return result;
        }
        return bs(arr,target,pivot,arr.length-1);
    }

    private int bs(int[]arr, int target, int left, int right){
        while(left <= right){
            int mid = left + ( right - left)/2;
            if(arr[mid] == target)return mid;
            else if ( arr[mid] > target){
                right = mid-1;
            }else left = mid+1;
        }
        return -1;
    }
}
