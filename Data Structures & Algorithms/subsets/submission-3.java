class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        if(arr == null || arr.length == 0)return new ArrayList();
        int n = arr.length;
        List<List<Integer>>result = new ArrayList();
        for(int i = 0; i < (1 << n); i++){ // 2 ^ n
            List<Integer>subset = new ArrayList();
            for(int j = 0; j < n; j++){ // n
                // check which bit is set, if it is set, include into answer.
                if((i & (1 << j)) != 0){
                    subset.add(arr[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
