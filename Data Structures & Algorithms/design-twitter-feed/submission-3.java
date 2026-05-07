class Twitter {
    private int time;
    private Map<Integer,Set<Integer>>followMap;
    private Map<Integer,List<int[]>>tweetMap;

    public Twitter() {
        this.time = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();    
    }
    
    public void postTweet(int userId, int tweetId) {
        // add userId -> (time, tweetId)
        this.tweetMap.computeIfAbsent(userId, k->new ArrayList<>()).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]>feed = new ArrayList(tweetMap.getOrDefault(userId, new ArrayList<>()));
        for(int followeeId : followMap.getOrDefault(userId, new HashSet<>())){
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }
        feed.sort((a,b)->b[0]-a[0]);
        List<Integer>result = new ArrayList<>();
        for(int i = 0; i < Math.min(10, feed.size()); i++){
            result.add(feed.get(i)[1]);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followMap.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
