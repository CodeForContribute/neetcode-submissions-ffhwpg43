class Solution {
    public int rob(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int rob1 = 0, rob2 = 0;
        for(int a: arr){
            int temp = Math.max(rob1 + a, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
