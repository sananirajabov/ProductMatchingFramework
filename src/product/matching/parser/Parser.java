package product.matching.parser;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import product.matching.tweets.ReadingTweets;
import product.matching.tweets.WritingClassifiedTweets;
import product.matching.util.StringModification;

public class Parser {

    private ReadingTweets readingJSONObjects = null;
    private WritingClassifiedTweets writingClassifiedTweets = null;
    
    private JSONParser jsonParser = null;
    private JSONObject jsonObject = null;
    private JSONObject jsonUserObject = null;
    private Object object = null;
    private Object userObject = null;
    
    private static final String USER = "user";
    private static final String USER_ID_STR = "id_str";
    private static final String USER_NAME = "name";
    private static final String USER_SCREEN_NAME = "screen_name";
    private static final String USER_TEXT = "text";

    public Parser() {
        jsonParser = new JSONParser();
        readingJSONObjects = new ReadingTweets();
        writingClassifiedTweets = new WritingClassifiedTweets();
    }

    public void parseJSON() {
        try {
            List<String> listOfJSONObjects = readingJSONObjects.getJSONObjectsFromGeneratedTweetsByPython();
            
            for (int i = 0; i < listOfJSONObjects.size(); i++) {
                object = jsonParser.parse(listOfJSONObjects.get(i));
                jsonObject = (JSONObject) object;
                userObject = (Object) jsonObject.get(USER);
                jsonUserObject = (JSONObject) userObject;

                String id = StringModification.modifyString((String) jsonUserObject.get(USER_ID_STR)).trim();
                String name = StringModification.modifyString((String) jsonUserObject.get(USER_NAME)).trim();
                String screenName = StringModification.modifyString((String) jsonUserObject.get(USER_SCREEN_NAME)).trim();
                String tweet = StringModification.modifyString((String) jsonObject.get(USER_TEXT)).trim();

                writingClassifiedTweets.addUniqueTweets(tweet);
                writingClassifiedTweets.writeUsersInfoOfTweetsToTextFile(id, name, screenName);
            }
            
            writingClassifiedTweets.writeUniqueTweetsToTextFile();
            writingClassifiedTweets.closeBufferedWriter();

        } catch (ParseException e) {
            System.err.println("Error Message: " + e.getMessage());
        }
    }
    
    public static String[] parseSentiWordNetByWordAndScores(String line) {
        String[] split = line.split("\t");
        
        String sentiWord = split[4].split("#")[0];
        String type = split[0];
        String positiveScore = split[2];
        String negativeScore = split[3];
        
        String[] parsedLine = {type, sentiWord, positiveScore, negativeScore};
        
        return parsedLine;
    }
    
}
