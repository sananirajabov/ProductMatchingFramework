package product.matching.tweets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import product.matching.util.StringModification;

public class WritingClassifiedTweets {

    private static final String MODIFIED_TWEET_FILENAME = "modifiedTweets.txt";
    private static final String USERS_INFO_OF_TWEETS_FILENAME = "users_info.txt";

    private static final String SEPERATOR = "::";

    private final Set<String> uniqueTweets = new HashSet();

    private BufferedWriter tweetsWriter = null;
    private BufferedWriter usersInfoWriter = null;

    public WritingClassifiedTweets() {
        try {
            tweetsWriter = new BufferedWriter(new FileWriter(MODIFIED_TWEET_FILENAME));
            usersInfoWriter = new BufferedWriter(new FileWriter(USERS_INFO_OF_TWEETS_FILENAME));

            tweetsWriter.append("");
            usersInfoWriter.append("");

        } catch (IOException e) {
            System.err.println("Error Message in WritingClassifiedTweets(): " + e.getMessage());
        }
    }

    public void writeUniqueTweetsToTextFile() {
        try {
            Iterator<String> iterator = uniqueTweets.iterator();

            while (iterator.hasNext()) {
                String tweet = StringModification.removeStopWordsInTweet(iterator.next());
                tweetsWriter.append(tweet);
                tweetsWriter.newLine();
            }

        } catch (IOException ex) {
            System.err.println("Error Message in writeUniqueTweetsToTextFile(): " + ex.getMessage());
        }

    }

    public void writeUsersInfoOfTweetsToTextFile(String id, String name, String screenName) {
        try {

            usersInfoWriter.append(id + SEPERATOR + name + SEPERATOR + screenName);
            usersInfoWriter.newLine();

        } catch (IOException e) {
            System.err.println("Error Message in writeUsersInfoOfTweetsToTextFile(): " + e.getMessage());
        }
    }

    public void addUniqueTweets(String tweet) {
        uniqueTweets.add(tweet);
    }

    public void closeBufferedWriter() {
        try {
            tweetsWriter.close();
            usersInfoWriter.close();
            
        } catch (IOException e) {
            System.err.println("Error Message in closeBufferedWriter(): " + e.getMessage());
        }
    }

}
