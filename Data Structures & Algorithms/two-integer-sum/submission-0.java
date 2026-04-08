class Solution {
    public int[] twoSum(int[] arr, int target) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        Map<Integer,Integer>sumPosIndex = new HashMap();
        for(int i = 0; i < n;i++){
            int complement = target - arr[i];
            if(sumPosIndex.containsKey(complement)){
                int[]result = new int[]{i, sumPosIndex.get(complement)};
                Arrays.sort(result);
                return result;
            }
            sumPosIndex.put(arr[i],i);
        }
        return new int[]{};
    }
}
