package com.nixuan.leetCode.LeetCode301_400;

import java.util.*;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/19 9:28
 **/
public class LeetCode0355_设计推特 {

    Map<Integer, LinkedList<Tweet>> userTweet;
    Map<Integer, Set<Integer>> follows;
    Integer displayNum;
    Integer time;

    private static class Tweet{
        Integer userId;
        Integer tweetId;
        Integer timestamp;

        public Tweet(Integer userId,Integer tweetId,Integer timestamp){
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
    /** Initialize your data structure here. */
    public LeetCode0355_设计推特() {
        userTweet = new HashMap<>();
        follows = new HashMap<>();
        displayNum = 10;
        time = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userTweet.containsKey(userId)){
            userTweet.put(userId,new LinkedList<>());
            follows.put(userId,new HashSet<>());
            follows.get(userId).add(userId);
        }
        userTweet.get(userId).addFirst(new Tweet(userId,tweetId,time++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> res = new LinkedList<>();
        if (!userTweet.containsKey(userId)){
            return new LinkedList<>();
        }
        for (Integer id:follows.get(userId)) {
            int len = Math.min(displayNum,userTweet.get(id).size());
            for (int i = 0; i < len; i++) {
                res.add(userTweet.get(id).get(i));
            }
        }
        Collections.sort(res, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.timestamp - o1.timestamp;
            }
        });
        List<Integer> feed = new LinkedList<>();
        int len = Math.min(displayNum,res.size());
        for (int i = 0; i < len; i++) {
            feed.add(res.get(i).tweetId);
        }
        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId){
        if (!follows.containsKey(followerId)){
            userTweet.put(followerId,new LinkedList<>());
            follows.put(followerId,new HashSet<>());
            follows.get(followerId).add(followerId);
        }
        if (!follows.containsKey(followeeId)){
            userTweet.put(followeeId,new LinkedList<>());
            follows.put(followeeId,new HashSet<>());
            follows.get(followeeId).add(followeeId);
        }
        follows.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && follows.containsKey(followerId) && follows.get(followerId).contains(followeeId)){
            follows.get(followerId).remove(followeeId);
        }
    }

}
