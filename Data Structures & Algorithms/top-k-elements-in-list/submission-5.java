class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        Map<Integer,Integer>frq = new HashMap();
        for(int a: arr)frq.put(a, frq.getOrDefault(a,0)+1);
        List<int[]>collection = new ArrayList<int[]>();
        for(Map.Entry<Integer,Integer>entry: frq.entrySet()){
            int key = entry.getKey(),val = entry.getValue();
            collection.add(new int[]{key,val});
        }
        collection.sort((a,b)->b[1]-a[1]);
        int[]result = new int[k];
        for(int i = 0; i < k;i++){
            result[i] = collection.get(i)[0];
        }
        return result;
    }
}
