package product.matching.async;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import product.matching.tweets.ReadingTweets;

public class AsyncWorks {
    
    private static final ReadingTweets readingJSONObjects = new ReadingTweets();
    
    public AsyncWorks(){
    }
    
    public void printOriginalTweetsAsynchoursly(JTextArea txtPaneOriginalTweets) {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            int count = 0;
            
            @Override
            protected Void doInBackground() throws Exception {
                readingJSONObjects.printTweetsInJTextPane(txtPaneOriginalTweets);
                return null;
            }
        };
        
        swingWorker.execute();
    }
    
    public void printModifiedTweetsAsynchoursly(JTextArea txtPaneModifiedTweets) {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                readingJSONObjects.printModifiedTweetsInJTextPane(txtPaneModifiedTweets);
                return null;
            }
        };
        
        swingWorker.execute();
    }
    
    public void printUsersInfoAsynchoursly(JTextArea txtPaneUsersInfo) {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                readingJSONObjects.printUsersInfoInJTextPane(txtPaneUsersInfo);
                return null;
            }
        };
        
        swingWorker.execute();
    }
    
    public void printSentimentResults(JTextArea txtSentimentResults) {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                readingJSONObjects.printSentimentResults(txtSentimentResults);
                return null;
            }
        };
        
        swingWorker.execute();
    }
    
}
