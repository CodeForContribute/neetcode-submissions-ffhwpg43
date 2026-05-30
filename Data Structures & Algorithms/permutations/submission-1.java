class Solution {
    public List<List<Integer>> permute(int[] arr) {
        if(arr == null || arr.length == 0)return new ArrayList();
        int n = arr.length;
        List<List<Integer>>result = new ArrayList();
        backtrack(arr, new ArrayList(),result,0);
        return result;   
    }

    private void backtrack(int[]arr, List<Integer>cur, List<List<Integer>>result, int mask){
        if(cur.size() == arr.length){
            result.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if((mask & ( 1 << i)) == 0){
                cur.add(arr[i]);
                backtrack(arr,cur,result,mask | (1 << i));
                cur.remove(cur.size()-1);
            }
        }
    }
}
