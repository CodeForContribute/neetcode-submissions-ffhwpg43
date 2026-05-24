class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int missingOne = 0;
        int result = 0;
        for(int a: arr)result ^= a;
        for(int i = 0; i <= n;i++){
            result ^= i;
        }
        return result;
    }
}
