class Solution {
    public int findDuplicate(int[] arr) {
        // fast and slow pointer
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length;
        int slow = 0, fast = 0;// 0-> index will not have loop
        while(true){
            slow = arr[slow];
            fast = arr[arr[fast]];
            if(slow == fast)break;
        }
        int slow2 = 0;
        while(true){
            slow = arr[slow];
            slow2 = arr[slow2];
            if(slow == slow2)return slow;
        }
    }
}
