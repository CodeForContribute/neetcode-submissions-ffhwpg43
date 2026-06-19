class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)return false;
        Map<Integer,Integer>cnt = new HashMap();
        for(int a: hand)cnt.put(a, cnt.getOrDefault(a,0)+1);
        Arrays.sort(hand);

        for(int a : hand){
            if(cnt.get(a) > 0){
                for(int val = a; val < a + groupSize; val++){
                    if(cnt.getOrDefault(val,0) == 0)return false;
                    cnt.put(val,cnt.get(val)-1);
                }
            }
        }
        return true;
    }
}
