class Solution {
    public boolean hasDuplicate(int[] arr) {
        if(arr == null || arr.length == 0)return false;
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 1; i < n;i++){
            if(arr[i] == arr[i-1])return true;
        }
        return false;
    }
}