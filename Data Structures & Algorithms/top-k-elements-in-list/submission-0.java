class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        Map<Integer,Integer>frqElement = new HashMap();
        for(int a : arr)frqElement.put(a, frqElement.getOrDefault(a,0)+1);
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->frqElement.get(a)-frqElement.get(b));
        for(Integer key: frqElement.keySet()){
            pq.add(key);
            if(pq.size() > k)pq.poll();
        }
        int[]result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        return result;
    }
}
