class Solution {
    Map<Integer,Integer>dp = new HashMap();
    public int jump(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        return dfs(arr,0);
    }

    private int dfs(int[]arr, int idx){
        if(dp.containsKey(idx))return dp.get(idx);
        if(idx == arr.length-1)return 0;
        if(arr[idx] == 0)return 1000000000;
        int ans = 1000000000;
        int end = Math.min(arr.length, idx + arr[idx]+1);
        for(int j = idx+1; j < end; j++){
            ans = Math.min(ans, 1 + dfs(arr,j));
        }
        dp.put(idx, ans);
        return ans;
    }
}
