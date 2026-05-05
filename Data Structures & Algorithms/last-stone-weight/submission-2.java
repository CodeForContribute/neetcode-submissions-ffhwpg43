class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0)return 0;
        int n = stones.length;
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone: stones)pq.add(stone);
        while(pq.size() > 1){
            int first = pq.poll(), second = pq.poll();
            if(first-second != 0)pq.add(first-second);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
