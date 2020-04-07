package product.matching.tweets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class ReadingTweets {
      
    private static final String ORIGINAL_TWEETS_FILENAME = "tweets.txt";
    private static final String MODIFIED_TWEETS_FILENAME = "modifiedTweets.txt";
    private static final String USERS_INFO_FILENAME = "users_info.txt";
    private static final String SENTIMENT_FILENAME = "sentiment.txt";

    private List<String> modifiedTweetList = null;
    
    public ReadingTweets() {
        modifiedTweetList = new ArrayList<>();
    }
    
    public List<String> getJSONObjectsFromGeneratedTweetsByPython() {
        List<String> objects = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ORIGINAL_TWEETS_FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                objects.add(line);
            }

        } catch (Exception e) {
            System.err.println("Error Message in getJSONObjectsFromGeneratedTweetsByPython(): " + e.getMessage());
        }

        return objects;
    }
    
    public void printTweetsInJTextPane(JTextArea textPane) {
        String lines = "";

        try (BufferedReader br = new BufferedReader(new FileReader(ORIGINAL_TWEETS_FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                lines += line + "\n";
                textPane.setText(lines);
            }

        } catch (Exception e) {
            System.err.println("Error Message in printTweetsInJTextPane(): " + e.getMessage());
        }

    }
    
    public void printModifiedTweetsInJTextPane(JTextArea textPane) {
        String lines = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(MODIFIED_TWEETS_FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                lines += line + "\n";
                textPane.setText(lines);
            }

        } catch (Exception e) {
            System.err.println("Error Message in printModifiedTweetsInJTextPane(): " + e.getMessage());
        }
    }
    
    public void printUsersInfoInJTextPane(JTextArea textPane) {
        String format = "%1$-20s %2$-20s %3$-20s";
        String lines = String.format(format, "ID", "Username", "Fullname") + "\n";
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_INFO_FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split("::");
                lines += String.format(format, split[0], split[1], split[2]) + "\n";
                textPane.setText(lines);
            }

        } catch (Exception e) {
            System.err.println("Error Message in printUsersInfoInJTextPane(): " + e.getMessage());
        }
    }
    
    public void printSentimentResults(JTextArea textArea){
        String format = "%1$-5s %2$-15s %3$-15s %4$-15s";
        String lines = String.format(format, "Type", "Word", "Positive", "Negative") + "\n";

        try (BufferedReader br = new BufferedReader(new FileReader(SENTIMENT_FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split("::");
                lines += String.format(format, split[0], split[1], split[2], split[3]) + "\n";
                textArea.setText(lines);
            }

        } catch (IOException e) {
            System.err.println("Error Message in printSentimentResults(): " + e.getMessage());
        }
    }
    
    public List<String> getModifiedTweetList() {
        try (BufferedReader br = new BufferedReader(new FileReader(MODIFIED_TWEETS_FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                
                for (String word : split) {
                    if (word.equalsIgnoreCase("Iphone")) continue;
                    if (word.equalsIgnoreCase("X")) continue;
                    if (word.equalsIgnoreCase("")) continue;
                    if (word.contains("?") 
                            || word.contains(".")
                            || word.contains(",")
                            || word.contains("/")
                            || word.contains("|")
                            || word.contains("\"")
                            || word.contains("!") 
                            || word.contains("-") 
                            || word.contains(":")
                            || word.contains(";")) continue;
                    if (word.length() == 1) continue;
                    if (wordContainsNum(word)) continue;
                    
                    modifiedTweetList.add(word);
                }
            }

        } catch (Exception e) {
            System.err.println("Error Message in getModifiedTweetList(): " + e.getMessage());
            e.printStackTrace();
        }
        
        return modifiedTweetList;
    }
    
    private boolean wordContainsNum(String word){
        if (word.contains("0")) return true;
        if (word.contains("1")) return true;
        if (word.contains("2")) return true;
        if (word.contains("3")) return true;
        if (word.contains("4")) return true;
        if (word.contains("5")) return true;
        if (word.contains("6")) return true;
        if (word.contains("7")) return true;
        if (word.contains("8")) return true;
        if (word.contains("9")) return true;
        
        return false;
    }
    
}
