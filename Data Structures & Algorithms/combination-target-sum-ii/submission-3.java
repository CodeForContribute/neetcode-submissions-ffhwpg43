class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        if(arr == null || arr.length == 0)return new ArrayList();
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>>result = new ArrayList();
        dfs(arr, target, 0, new ArrayList(),result);
        return result;
    }

    private void dfs(int[]arr, int target, int idx, List<Integer>cur, List<List<Integer>>result){
        // base case
        if(target == 0){
            result.add(new ArrayList(cur));
            return;
        }
        if(target < 0 || idx >= arr.length)return;

        cur.add(arr[idx]);
        dfs(arr,target-arr[idx],idx+1,cur,result);
        cur.remove(cur.size()-1);

        while( idx + 1 < arr.length && arr[idx] == arr[idx+1])idx++;

        dfs(arr,target, idx+1,cur,result);

    }
}
