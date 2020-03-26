
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Twitter {

    private static int timeStamp = 0;

    private Map<Integer,User> userMap;

    private class Tweet{
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    public class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id){
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }

        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */