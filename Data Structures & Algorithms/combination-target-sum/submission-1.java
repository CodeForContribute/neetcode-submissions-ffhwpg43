class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        // optimised - we all sort the arr and so that if the current sum in recursion becomes -ve,
        //  we will explore other indices.
        // at each position - we try every number starting from index i, allowing reuse of the same number.
        // we build combinations step by step,and whenever the running total equals == target, we will record it.
        // sorting + pruning significantly reduces unnecessary recursion.

        List<List<Integer>>result = new ArrayList();
        if(arr == null || arr.length == 0)return result;
        int n = arr.length;
        Arrays.sort(arr);
        dfs(arr,target,0, new ArrayList(),result);
        return result;
    }
    private void dfs(int[]arr, int target, int idx, List<Integer>cur, List<List<Integer>>result){
        // base case
        // if(target < 0 || idx >= arr.length)return;
        if(target == 0){
            result.add(new ArrayList(cur));
            return;
        }
        int n = arr.length;
        for(int i = idx; i < n;i++){
            if(target - arr[i] < 0)return;
            // choice -1 - skip it and go to next one
            //dfs(arr,target,i+1,cur,result);
            // choice - 2 - add this and reuse this index again in next recursive call.
            cur.add(arr[i]);
            dfs(arr,target - arr[i], i, cur, result);
            cur.remove(cur.size()-1);
        }
    }
}
