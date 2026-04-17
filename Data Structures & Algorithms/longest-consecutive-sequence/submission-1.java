class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int n = arr.length, ans = 0;
        Map<Integer,Integer>longestSeq = new HashMap();
        for(int a : arr){
            if(!longestSeq.containsKey(a)){
                int left =  longestSeq.containsKey(a-1) ?  longestSeq.get(a-1) : 0;
                int right = longestSeq.containsKey(a+1) ?  longestSeq.get(a+1) : 0;
                int sum = left + right + 1;
                longestSeq.put(a, sum);
                ans = Math.max(ans, sum);

                longestSeq.put(a-left, sum);
                longestSeq.put(a + right, sum);
            }
        }
        return ans;
        // if(arr == null || arr.length == 0)return 0;
        // int n = arr.length, ans = 0;
        // Map<Integer,Integer>longestConsSeq = new HashMap();
        // for(int a: arr){
        //     if(!longestConsSeq.containsKey(a)){
        //         int left = longestConsSeq.containsKey(a-1) ? longestConsSeq.get(a-1) : 0;
        //         int right = longestConsSeq.containsKey(a+1) ? longestConsSeq.get(a+1): 0;
        //         int sum = left + right + 1;
        //         longestConsSeq.put(a,sum);
        //         ans = Math.max(ans,sum);

        //         longestConsSeq.put(a - left,sum);
        //         longestConsSeq.put(a + right, sum);
        //     }
        // }
        // return ans;
    }
}
