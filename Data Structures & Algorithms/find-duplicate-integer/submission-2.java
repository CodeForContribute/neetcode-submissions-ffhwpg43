class Solution {
    public int findDuplicate(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        int left = 1, right = n-1;
        while(left < right){
            int mid = left + ( right -left)/2;
            int lessOrEqual = 0;
            for(int i = 0; i < n;i++){
                if(arr[i] <= mid)lessOrEqual++;
            }
            if(lessOrEqual <= mid){
                left = mid+1;
            }else right = mid;
        }
        return left;
    }
}
