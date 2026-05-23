class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        // bucket sort
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        Map<Integer,Integer>cnt = new HashMap();
        List<Integer>[]frq = new List[n+1];
        for(int i = 0; i <= n;i++){
            frq[i] = new ArrayList();
        }
        for(int a: arr){
            cnt.put(a, cnt.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer,Integer>e:cnt.entrySet()){
            int key = e.getKey(), keyFrq = e.getValue();
            frq[keyFrq].add(key);
        }

        int[]result = new int[k];
        int idx = 0;
        for(int i = frq.length-1; i > 0 && idx < k; i--){
            for(int ele : frq[i]){
                result[idx++] = ele;
                if(idx == k)return result;
            }
        }
        return result;
    }
}
