class Solution {
    public boolean hasDuplicate(int[] arr) {
        if(arr == null || arr.length == 0)return false;
        int n = arr.length;
        Set<Integer>seen = new HashSet();
        for(int a: arr){
            if(seen.contains(a))return true;
            seen.add(a);
        }
        return false;
    }
}