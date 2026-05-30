class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        if(arr == null || arr.length == 0)return new ArrayList();
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>>result = new ArrayList();
        dfs(0, new ArrayList(),arr,result);
        return result;
    }

    private void dfs(int idx, List<Integer>cur, int[]arr, List<List<Integer>>result){
        result.add(new ArrayList(cur));
        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i-1])continue; //skip duplicate, take the last one
            cur.add(arr[i]);
            dfs(i+1,cur,arr,result);
            cur.remove(cur.size()-1);
        }
    }
}
