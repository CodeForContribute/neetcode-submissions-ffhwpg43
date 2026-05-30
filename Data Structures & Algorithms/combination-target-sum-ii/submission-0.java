class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        final List<List<Integer>>result = new ArrayList();
        if(arr == null || arr.length == 0)return result;
        int n = arr.length;
        Arrays.sort(arr);
        dfs(0,new ArrayList(),target,arr,result);
        return result;
    }

    private void dfs(int idx, List<Integer>cur, int target, int[]arr, List<List<Integer>>result){
        if(target == 0){
            result.add(new ArrayList(cur));
            return;
        }
        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i-1])continue;
            if(target - arr[i] < 0)return;
            cur.add(arr[i]);
            dfs(i+1, cur,target-arr[i],arr,result);
            cur.remove(cur.size()-1);
        }
    }
}
