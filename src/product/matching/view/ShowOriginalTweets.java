package product.matching.view;

import javax.swing.UIManager;
import product.matching.async.AsyncWorks;

public class ShowOriginalTweets extends javax.swing.JFrame {

    private final AsyncWorks asyncWorks = new AsyncWorks();

    public ShowOriginalTweets() {
        initComponents();
        asyncWorks.printOriginalTweetsAsynchoursly(txtPaneOriginalTweets);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        btnModifyUsersInfo = new javax.swing.JButton();
        btnModifyTweets = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPaneOriginalTweets = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnModifyUsersInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModifyUsersInfo.setText("Modify Users Info");
        btnModifyUsersInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyUsersInfoActionPerformed(evt);
            }
        });

        btnModifyTweets.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModifyTweets.setText("Modify Tweets");
        btnModifyTweets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyTweetsActionPerformed(evt);
            }
        });

        txtPaneOriginalTweets.setEditable(false);
        txtPaneOriginalTweets.setColumns(20);
        txtPaneOriginalTweets.setRows(5);
        jScrollPane1.setViewportView(txtPaneOriginalTweets);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(btnModifyTweets, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModifyUsersInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifyUsersInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifyTweets, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainPage mainPage = new MainPage();
        mainPage.show();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnModifyUsersInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyUsersInfoActionPerformed
        ShowUsersInfo usersInfo = new ShowUsersInfo();
        usersInfo.show();
        this.dispose();
    }//GEN-LAST:event_btnModifyUsersInfoActionPerformed

    private void btnModifyTweetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyTweetsActionPerformed
        ShowModifiedTweets modifiedTweets = new ShowModifiedTweets();
        modifiedTweets.show();
        this.dispose();
    }//GEN-LAST:event_btnModifyTweetsActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowOriginalTweets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowOriginalTweets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowOriginalTweets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowOriginalTweets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowOriginalTweets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModifyTweets;
    private javax.swing.JButton btnModifyUsersInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtPaneOriginalTweets;
    // End of variables declaration//GEN-END:variables
}
