class Solution {
    public int findDuplicate(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        int ans = 0;
        for(int b = 0 ;b < 32; b++){
            int x = 0, y = 0;
            int mask = 1 << b;
            for(int ele : arr){
                if((ele & mask) != 0)x++;
            }

            for(int ele = 1; ele < n;ele++){
                if((ele & mask) != 0)y++;
            }
            if(x > y){
                ans |= mask;
            }
        }
        return ans;
    }
}
