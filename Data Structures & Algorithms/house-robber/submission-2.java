class Solution {
    public int rob(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        int rob1 = 0, rob2 = 0;
        for(int a: arr){
            int tmp = Math.max(rob1 + a, rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        return rob2;
    }
}
