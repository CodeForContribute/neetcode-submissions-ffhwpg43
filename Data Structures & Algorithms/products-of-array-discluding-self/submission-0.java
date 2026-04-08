class Solution {
    public int[] productExceptSelf(int[] arr) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        int[]result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n;i++){
            result[i] = result[i-1] * arr[i-1];
        }
        // 1 1 2 8
        // 
        int right = 1;
        for(int j = n-1; j >= 0; j--){
            result[j] = result[j] * right;
            right *= arr[j];
        }
        return result;
    }
}  
