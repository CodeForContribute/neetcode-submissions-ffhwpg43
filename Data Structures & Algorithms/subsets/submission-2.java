class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        if(arr == null || arr.length == 0)return new ArrayList();
        int n = arr.length;
        List<List<Integer>>result = new ArrayList();
        result.add(new ArrayList());
        for(int a: arr){
            int size = result.size();
            for(int i = 0; i < size;i++){
                List<Integer>subset = new ArrayList(result.get(i));
                subset.add(a);
                result.add(subset);
            }
        }
        return result;
    }
}
