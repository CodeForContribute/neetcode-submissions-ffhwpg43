class Solution {
    public boolean hasDuplicate(int[] arr) {
        // if(arr == null || arr.length == 0)return false;
        // Set<Integer>unq = new HashSet();
        // for(int a: arr)unq.add(a);
        // return unq.size() < arr.length;
        if(arr == null || arr.length == 0)return false;
        Set<Integer>unq = new HashSet();
        for(int a: arr)unq.add(a);
        return unq.size() < arr.length;
    }
}