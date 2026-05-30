class Solution {
    public List<List<Integer>> permute(int[] arr) {
        if(arr == null || arr.length == 0)return new ArrayList();
        int n = arr.length;
        List<List<Integer>>result = new ArrayList();
        backtrack(arr,0,result);
        return result;
    }

    private void backtrack(int[]arr, int idx, List<List<Integer>>result){
        // base case
        if(idx == arr.length){
            List<Integer>perm = new ArrayList();
            for(int a: arr)perm.add(a);
            result.add(perm);
            return;
        }
        for(int i = idx; i < arr.length; i++){
            swap(arr,idx,i);
            backtrack(arr,idx+1,result);
            swap(arr,idx,i);
        }
    }

    private void swap(int[]arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
