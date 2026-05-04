class Solution {
    public int findDuplicate(int[] arr) {
        if(arr == null || arr.length == 0)return -1;
        for(int ele : arr){
            int idx = Math.abs(ele)-1;
            if(arr[idx] < 0)return Math.abs(ele);
            arr[idx] *= -1;
        }
        return -1;
        // if(arr == null || arr.length == 0)return -1;
        // for(int ele : arr){
        //     int idx = Math.abs(ele)-1;
        //     if(arr[idx] < 0)return Math.abs(ele);
        //     arr[idx] *= -1;
        // }
        // return -1;
    }
}
