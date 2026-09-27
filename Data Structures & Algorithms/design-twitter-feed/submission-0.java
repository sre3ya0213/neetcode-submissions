class Twitter {

    class Tweet {
        int id;
        int timestamp;

        public Tweet(int id , int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    int curTime;
    Map<Integer,List<Tweet>> tweets;
    Map<Integer,Set<Integer>> following; 

    public Twitter() {
        curTime = 0;
        tweets = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        curTime++;
        List<Tweet> ids = tweets.getOrDefault(userId,new ArrayList<>());
        ids.add(new Tweet(tweetId,curTime));
        tweets.put(userId,ids);
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.timestamp,b.timestamp));
        Set<Integer> userIds = new HashSet<>(following.getOrDefault(userId,new HashSet<>()));
        userIds.add(userId);
        List<Integer> res = new ArrayList<>();

        for(int id : userIds) {
            List<Tweet> tts = tweets.getOrDefault(id,new ArrayList<>());
            for(int i=0;i<tts.size();i++) {
                minHeap.offer(tts.get(i));
                if(minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        while(!minHeap.isEmpty()) {
            Tweet tweet = minHeap.poll();
            res.add(tweet.id);
        }
        Collections.reverse(res);
        return res;  
        
        
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> ids = following.getOrDefault(followerId,new HashSet<>());
        ids.add(followeeId);
        following.put(followerId,ids);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> ids = following.getOrDefault(followerId,new HashSet<>());
        ids.remove(followeeId);
        following.put(followerId,ids);
    }
}
