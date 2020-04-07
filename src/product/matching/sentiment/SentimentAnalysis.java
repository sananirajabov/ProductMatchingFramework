package product.matching.sentiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import product.matching.tweets.ReadingTweets;
import product.matching.parser.Parser;

public class SentimentAnalysis {
    
    private static final String SENTIWORDNET_FILENAME = "SentiWordNet_3.0.0.txt";
    private static final String SENTIMENT_FILENAME = "sentiment.txt";
    private static final String SEPERATOR = "::";

    private BufferedReader sentimentWordNetBufferedReader = null;
    private BufferedWriter sentimentBufferedWriter = null;
    private List<String> modifiedTweets = null;
    
    public SentimentAnalysis() {
        try {
            sentimentWordNetBufferedReader = new BufferedReader(new FileReader(SENTIWORDNET_FILENAME));
            sentimentBufferedWriter = new BufferedWriter(new FileWriter(SENTIMENT_FILENAME));
            modifiedTweets = new ReadingTweets().getModifiedTweetList();
        } catch (IOException e) {
            System.err.println("Error: SentimentAnalysis(): " + e.getMessage());
        }
    }
    
    public void writeToTextSentimentResults() {
        try {
            String line;
            int count = 0;
            sentimentBufferedWriter.append("");
            
            while ((line = sentimentWordNetBufferedReader.readLine()) != null) {
                ++count;
                
                if (count > 27) {
                    String type = Parser.parseSentiWordNetByWordAndScores(line)[0];
                    String sentiWord = Parser.parseSentiWordNetByWordAndScores(line)[1];
                    String pos = Parser.parseSentiWordNetByWordAndScores(line)[2];
                    String neg = Parser.parseSentiWordNetByWordAndScores(line)[3];
                    
                    for (int i = 0; i < modifiedTweets.size(); i++) {
                        if (sentiWord.equalsIgnoreCase(modifiedTweets.get(i))) {
                            sentimentBufferedWriter.append(type + SEPERATOR + sentiWord + SEPERATOR + pos + SEPERATOR + neg);
                            sentimentBufferedWriter.newLine();
                        }
                    }
                }
            }
            
            sentimentWordNetBufferedReader.close();
            sentimentBufferedWriter.close();
            
        } catch (IOException e) {
            System.err.println("Error: readSentiWordNet(): " + e.getMessage());
        }
    }
    
    public static Double findSentiment() {
        Double positive = 0.0D;
        Double negative = 0.0D;
        Double polarity = 0.0D;
        
        try (BufferedReader br = new BufferedReader(new FileReader(SENTIMENT_FILENAME));){
            String line;
            
            while((line = br.readLine()) != null) {
                String[] split = line.split(SEPERATOR);
                positive += Double.parseDouble(split[2]);
                negative += Double.parseDouble(split[3]);
            }
            
            polarity = 100 / (positive - negative);
            
        } catch (IOException e) {
            System.err.println("Error Message in findSentiment(): " + e.getMessage());
        }
        
        return polarity;
    }
    
}
