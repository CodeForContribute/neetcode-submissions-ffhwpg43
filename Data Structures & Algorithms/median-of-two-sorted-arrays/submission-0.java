class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[]merged = new int[m + n];
        System.arraycopy(nums1,0,merged,0,m);
        System.arraycopy(nums2,0,merged,m,n);
        Arrays.sort(merged);
        int totalLen = merged.length;
        if(totalLen % 2 == 0){
            return (merged[totalLen / 2 - 1] + merged[totalLen / 2]) * 0.5;
        }else{
            return merged[totalLen / 2];
        }
    }
}
