class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        if(arr == null || arr.length == 0)return new int[]{};
        int n = arr.length;
        Map<Integer,Integer>frq = new HashMap();
        for(int a: arr)frq.put(a, frq.getOrDefault(a,0)+1);
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->frq.get(a)-frq.get(b));
        frq.entrySet().stream().forEach(entry->{
            pq.offer(entry.getKey());
            if(pq.size()> k)pq.poll();
        });

        int[]result = new int[k];
        int idx = 0;
        while(!pq.isEmpty()){
            result[idx++] = pq.poll();
        }
        return result;
    }
}
