class Solution {
    public int singleNumber(int[] arr) {
        int result = 0;
        for(int a: arr){
            result ^= a;
        }
        return result;
    }
}
