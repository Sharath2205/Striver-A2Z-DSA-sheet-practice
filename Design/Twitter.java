package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Tweet implements Comparable<Tweet> {
    int tweetId;
    int timeStamp;

    public Tweet(int tweetId, int timeStamp) {
        this.tweetId = tweetId;
        this.timeStamp = timeStamp;
    }

    public int compareTo(Tweet that) {
        return that.timeStamp - this.timeStamp;
    }
}

class User {
    int userId;
    List<Tweet> tweets;
    Set<Integer> following;

    public User(int userId) {
        this.userId = userId;
        tweets = new LinkedList<>();
        following = new HashSet<>();
    }

    public void addTweet(Tweet t) {
        tweets.add(0, t); // Insert at head
    }

    public void addFollower(int followeeId) {
        following.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        following.remove(followeeId);
    }
}

class Twitter {

    Map<Integer, User> users;
    int timeCounter;

    public Twitter() {
        users = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        User user = users.get(userId);
        user.addTweet(new Tweet(tweetId, timeCounter++));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId))
            return new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        User user = users.get(userId);

        for (int followerId : user.following) {
            int count = 0;
            for (Tweet tweet : users.get(followerId).tweets) {
                pq.offer(tweet);
                count++;
                if (count > 10)
                    break;
            }
        }
        int count = 0;
        for (Tweet tweet : user.tweets) {
            pq.offer(tweet);
            count++;
            if (count > 10)
                break;
        }

        List<Integer> res = new ArrayList<>();

        int index = 0;

        while (!pq.isEmpty() && index < 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            index++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }

        User user = users.get(followerId);
        user.addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || !users.containsKey(followeeId))
            return;

        User user = users.get(followerId);

        user.removeFollower(followeeId);
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