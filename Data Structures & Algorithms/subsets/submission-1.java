class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>>result = new ArrayList();
        List<Integer>subset = new ArrayList();
        dfs(arr,0,subset,result);
        return result;
    }
    private void dfs(int[]arr, int idx, List<Integer>subset, List<List<Integer>>result){
        // base case
        if(idx >= arr.length){
            result.add(new ArrayList(subset));
            return;
        }
        // take current element and explore next indices.
        dfs(arr,idx+1,subset, result);
        subset.add(arr[idx]);
        dfs(arr,idx+1,subset,result);
        subset.remove(subset.size()-1);
    }
}
