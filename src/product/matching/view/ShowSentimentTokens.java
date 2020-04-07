package product.matching.view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import product.matching.async.AsyncWorks;
import product.matching.sentiment.SentimentAnalysis;

public class ShowSentimentTokens extends javax.swing.JFrame {

    private final AsyncWorks asyncWorks = new AsyncWorks();
//    private final SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
    
    public ShowSentimentTokens() {
        initComponents();
//        sentimentAnalysis.writeToTextSentimentResults();
        asyncWorks.printSentimentResults(txtSentimentTokens);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        btnFindSentiment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSentimentTokens = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnFindSentiment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFindSentiment.setText("Find Sentiment");
        btnFindSentiment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindSentimentActionPerformed(evt);
            }
        });

        txtSentimentTokens.setEditable(false);
        txtSentimentTokens.setColumns(20);
        txtSentimentTokens.setRows(5);
        jScrollPane1.setViewportView(txtSentimentTokens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFindSentiment, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFindSentiment, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ShowModifiedTweets tweets = new ShowModifiedTweets();
        tweets.show();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnFindSentimentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindSentimentActionPerformed
        String condition = "";
        
        if (SentimentAnalysis.findSentiment() > 0) condition = "Positive";
        else if (SentimentAnalysis.findSentiment() < 0) condition = "Negative";
        else condition = "Neutral";
        
        JOptionPane.showMessageDialog(this, String.format("%.2f%% " + condition, SentimentAnalysis.findSentiment()));
    }//GEN-LAST:event_btnFindSentimentActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowSentimentTokens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowSentimentTokens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowSentimentTokens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowSentimentTokens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowSentimentTokens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFindSentiment;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtSentimentTokens;
    // End of variables declaration//GEN-END:variables
}
