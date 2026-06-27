class Solution {
    public int[] plusOne(int[] arr) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        for(int idx = n-1; idx >= 0; idx--){
            if(arr[idx] == 9){
                arr[idx] = 0;
            }else{
                arr[idx]++;
                return arr;
            }
        }
        arr = new int[n+1];
        arr[0] = 1;
        return arr;
    }
}