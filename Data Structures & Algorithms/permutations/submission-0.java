class Solution {
    public List<List<Integer>> permute(int[] arr) {
        if(arr == null || arr.length == 0)return new ArrayList();
        int n = arr.length;
        List<List<Integer>>result = new ArrayList();
        dfs(arr,new ArrayList(),new boolean[n],result);
        return result;
    }

    private void dfs(int[]arr, List<Integer>cur, boolean[]pick, List<List<Integer>>result){
        if(cur.size() == arr.length){
            result.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < arr.length;i++){
            if(!pick[i]){
                cur.add(arr[i]);
                pick[i] = true;
                dfs(arr,cur,pick,result);
                cur.remove(cur.size()-1);
                pick[i] = false;
            }
        }
    }
}
