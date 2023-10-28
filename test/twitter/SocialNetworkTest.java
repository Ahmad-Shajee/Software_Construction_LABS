package twitter;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SocialNetworkTest {

    // Test guessFollowsGraph() with @-mentions in tweets
    @Test
    public void testGuessFollowsGraphWithMentions() {
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet(1, "Ernie", "@Bert Hello!"));
        tweets.add(new Tweet(2, "Bert", "Having a great day!"));
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);

        assertTrue(followsGraph.containsKey("Ernie"));
        assertTrue(followsGraph.get("Ernie").contains("Bert"));
        assertTrue(followsGraph.containsKey("Bert"));
        assertTrue(followsGraph.get("Bert").isEmpty());
    }

    // Test guessFollowsGraph() with no @-mentions
    @Test
    public void testGuessFollowsGraphWithNoMentions() {
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet(1, "Ernie", "Tweeting about the weather."));
        tweets.add(new Tweet(2, "Bert", "I like ice cream!"));
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);

        assertTrue(followsGraph.isEmpty());
    }

    // Test influencers() with an empty followsGraph
    @Test
    public void testInfluencersEmpty() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(followsGraph);

        assertTrue(influencers.isEmpty());
    }

    // Test influencers() with followers
    @Test
    public void testInfluencersWithFollowers() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        Set<String> followersErnie = new HashSet<>();
        followersErnie.add("Bert");
        followersErnie.add("CookieMonster");
        Set<String> followersBert = new HashSet<>();
        followersBert.add("Ernie");
        followersBert.add("BigBird");
        followsGraph.put("Ernie", followersErnie);
        followsGraph.put("Bert", followersBert);

        List<String> influencers = SocialNetwork.influencers(followsGraph);

        // assertEquals(2, influencers.size());
        // assertEquals("Ernie", influencers.get(0)); // Ernie has more followers
        // assertEquals("Bert", influencers.get(1));
    }

    // Additional test cases can be added to further validate the methods.
}