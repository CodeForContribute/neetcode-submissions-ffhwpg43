class Solution {
    public int findKthLargest(int[] arr, int k) {
        // quickselect -> arr is not sorted - whenever we have to find kth of something
        // averge - O(n) , worst case - O(n^2)
        // pivot -> all elements lesser ( <= ) than pivot ele will be on left
        // all elements greater than ele will be on right
        // elements on left or right will have no respective order among themselves
        // pivot will form partition between them.
        // if pivot == k -> kth largest element
        // if pivot < k : go right -> left = pivot+1
        // if pivot > k : go left -> right = pivot
        if(arr == null || arr.length == 0)return -1;
        int n = arr.length;
        k = n-k;
        return quickSelect(arr, 0, n-1,k);
    }

    private int quickSelect(int[]arr, int left, int right, int k){
        int pivot = arr[right];
        int idx = left;
        for(int j = left; j < right;j++){
            if(arr[j] <= pivot){
                swap(arr,idx,j);
                idx++;
            }
        }
        swap(arr,idx,right);
        if(idx > k){
            return quickSelect(arr, left, idx-1,k);
        }else if (idx < k){
            return quickSelect(arr,idx+1, right,k);
        }else{
            return arr[idx];
        }
    }

    private void swap(int[]arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
