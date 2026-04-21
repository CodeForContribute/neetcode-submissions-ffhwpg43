class Solution {
    public int findMin(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        int left = 0, right = n-1;
        int ans = arr[0];
        while(left <= right){
            if(arr[left] < arr[right]){
                ans = Math.min(ans, arr[left]);
                break;
            }

            int mid = left + ( right - left )/2;
            ans = Math.min(ans, arr[mid]);
            if(arr[mid] >= arr[left]){
                left = mid+1;
            }else right = mid-1;
        }
        return ans;
    }
}
