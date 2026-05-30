class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>>result = new ArrayList();
        if(arr == null || arr.length == 0)return result;
        int n = arr.length;
        List<Integer>cur = new ArrayList();
        backtrack(arr, target,cur,0,result);
        return result;
    }

    private void backtrack(int[]arr, int target, List<Integer>cur, int idx,List<List<Integer>>result){
        // base case
        if(target == 0){
            result.add(new ArrayList(cur));
            return;
        }
        if(target < 0 || idx >= arr.length)return;
        // skip it and move to next index
        backtrack(arr, target,cur,idx+1, result);
        // or take the current index and call dfs on same index again
        cur.add(arr[idx]);
        backtrack(arr, target - arr[idx],cur,idx, result);
        cur.remove(cur.size()-1);
    }
}
