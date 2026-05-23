class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        Map<Integer,Integer>frq = new HashMap();
        for(int a: arr)frq.put(a, frq.getOrDefault(a,0)+1);
        List<int[]>collection = new ArrayList<int[]>();
        for(Map.Entry<Integer,Integer>entry: frq.entrySet()){
            int key = entry.getKey(),val = entry.getValue();
            collection.add(new int[]{val,key});
        }
        collection.sort((a,b)->b[0]-a[0]);
        int[]result = new int[k];
        for(int i = 0; i < k;i++){
            result[i] = collection.get(i)[1];
        }
        return result;
    }
}
