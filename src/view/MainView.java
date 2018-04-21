/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import feature.AutocolorCorrelogram;
import imageforgerydetection.Detector;
import imageforgerydetection.IO;
import imageforgerydetection.Praprocessor;
import imageforgerydetection.Rocchio;
import imageforgerydetection.UserFeedback;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import model.Image;

/**
 *
 * @author fikriaulia
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        selectImageButton = new javax.swing.JButton();
        detectButton = new javax.swing.JButton();
        featureSelector = new javax.swing.JComboBox<>();
        MatcherSelector = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tresholdField = new javax.swing.JTextField();
        imagePanel = new javax.swing.JScrollPane();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        blockSizeField = new javax.swing.JTextField();
        detectedImage = new javax.swing.JButton();
        relevanceFeedbackParamA = new javax.swing.JTextField();
        relevanceFeedbackParamB = new javax.swing.JTextField();
        image = new javax.swing.JTextField();
        XValue = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        YValue = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        addFeedbackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userFeedbackView = new javax.swing.JTextArea();
        relevanceFeedbackExecuteButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        relevaceFeedbackResult = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pendeteksi keaslian gambar");

        selectImageButton.setText("Pilih Gambar");
        selectImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageButtonActionPerformed(evt);
            }
        });

        detectButton.setText("Deteksi Keaslian Gambar");
        detectButton.setPreferredSize(new java.awt.Dimension(109, 32));
        detectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detectButtonActionPerformed(evt);
            }
        });

        featureSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autocolor Correlogram", "Approximate Color Correlogram" }));
        featureSelector.setToolTipText("");
        featureSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                featureSelectorActionPerformed(evt);
            }
        });

        MatcherSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple Matcher", "Relevance Feedback Matcher" }));
        MatcherSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatcherSelectorActionPerformed(evt);
            }
        });

        jLabel2.setText("batas kemiripan");

        tresholdField.setToolTipText("");
        tresholdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresholdFieldActionPerformed(evt);
            }
        });

        backButton.setText("Kembali");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("ukuran blok gambar");

        blockSizeField.setToolTipText("");
        blockSizeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockSizeFieldActionPerformed(evt);
            }
        });

        detectedImage.setText("Hasil Deteksi Terakhir");
        detectedImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detectedImageActionPerformed(evt);
            }
        });

        relevanceFeedbackParamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relevanceFeedbackParamBActionPerformed(evt);
            }
        });

        jLabel4.setText("Parameter Relevance Feedback");

        jLabel5.setText("a");

        jLabel6.setText("b");

        jLabel7.setText("X");

        jLabel8.setText("Y");

        jLabel9.setText("Gambar");

        jLabel10.setText("Feedback Pengguna");

        addFeedbackButton.setText("Tambahkan");
        addFeedbackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFeedbackButtonActionPerformed(evt);
            }
        });

        userFeedbackView.setEditable(false);
        userFeedbackView.setColumns(20);
        userFeedbackView.setRows(5);
        jScrollPane1.setViewportView(userFeedbackView);

        relevanceFeedbackExecuteButton.setText("Eksekusi");
        relevanceFeedbackExecuteButton.setActionCommand("Perbaharui Batas");
        relevanceFeedbackExecuteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relevanceFeedbackExecuteButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("Parameter hasil eksekusi");

        relevaceFeedbackResult.setEditable(false);
        relevaceFeedbackResult.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(selectImageButton)
                                .addGap(18, 18, 18)
                                .addComponent(detectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backButton)
                                .addGap(18, 18, 18)
                                .addComponent(detectedImage))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel10))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addFeedbackButton)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(YValue)
                                                .addComponent(XValue)
                                                .addComponent(image)
                                                .addComponent(relevanceFeedbackParamB)
                                                .addComponent(relevanceFeedbackParamA)
                                                .addComponent(blockSizeField, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(10, 24, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(featureSelector, 0, 0, Short.MAX_VALUE)
                                            .addComponent(MatcherSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tresholdField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(2, 2, 2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(relevanceFeedbackExecuteButton)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(relevaceFeedbackResult, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(featureSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MatcherSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tresholdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(blockSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(relevanceFeedbackParamA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(relevanceFeedbackParamB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(XValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addFeedbackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(relevanceFeedbackExecuteButton))
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectedImage)
                    .addComponent(backButton)
                    .addComponent(detectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectImageButton)
                    .addComponent(jLabel11)
                    .addComponent(relevaceFeedbackResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    JLabel jlab = new JLabel();
    java.io.File file;
    BufferedImage result;
    private void selectImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(selectImageButton) == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();

            //set icon
            jlab.setIcon(new ImageIcon(file.toString()));

            //alignment
            jlab.setHorizontalAlignment(JLabel.CENTER);

            //add jlabel to scroll pane
            imagePanel.getViewport().add(jlab);
        }
    }//GEN-LAST:event_selectImageButtonActionPerformed

    private void tresholdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresholdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tresholdFieldActionPerformed

    private void detectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detectButtonActionPerformed
        // TODO add your handling code here:
        BufferedImage originalImage = IO.FileToBufferedImage(file); //user input
        long start = System.currentTimeMillis();
//        Praprocessor.setAffineType(featureSelector.getSelectedItem().toString()); //user input
        Praprocessor.setBlockSize(Integer.parseInt(blockSizeField.getText())); //user input
        Praprocessor.setFeatureType(featureSelector.getSelectedItem().toString());
        Image image = Praprocessor.generateImage(originalImage);
        long now = System.currentTimeMillis();
        System.out.println("praproses time : "+(now - start)/1000.0);
        start = System.currentTimeMillis();
        Detector.setDetectionType(MatcherSelector.getSelectedItem().toString()); //user input
        Detector.setSimilarityTreshold(Double.parseDouble(tresholdField.getText()));//user input
        result = Detector.detect(image);
        now = System.currentTimeMillis();
        System.out.println("detection time : "+(now - start)/1000.0);
        jlab.setIcon(new ImageIcon(result));
        IO.writeImage(result, "result/015_F_result.png", "png");
    }//GEN-LAST:event_detectButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        jlab.setIcon(new ImageIcon(file.toString()));
        
        jlab.setHorizontalAlignment(JLabel.CENTER);
    }//GEN-LAST:event_backButtonActionPerformed

    private void blockSizeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockSizeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blockSizeFieldActionPerformed

    private void detectedImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detectedImageActionPerformed
        // TODO add your handling code here:
        jlab.setIcon(new ImageIcon(result));
        
        jlab.setHorizontalAlignment(JLabel.CENTER);
    }//GEN-LAST:event_detectedImageActionPerformed

    private void MatcherSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatcherSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MatcherSelectorActionPerformed

    private void featureSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featureSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_featureSelectorActionPerformed

    private void relevanceFeedbackParamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relevanceFeedbackParamBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relevanceFeedbackParamBActionPerformed
    
    ArrayList<UserFeedback> ListOfUserFeedback = new ArrayList<UserFeedback>();
    boolean isNewFeedback = true;
    private void addFeedbackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFeedbackButtonActionPerformed
        // TODO add your handling code here:
        if (isNewFeedback) userFeedbackView.setText(null);
        isNewFeedback = false;
        UserFeedback userFeedback = new UserFeedback();
        userFeedback.setX(Integer.parseInt(XValue.getText()));
        userFeedback.setY(Integer.parseInt(YValue.getText()));
        userFeedback.setIdentifier(image.getText());
        ListOfUserFeedback.add(userFeedback);
        userFeedbackView.setText(getUserFeedbackText());
    }//GEN-LAST:event_addFeedbackButtonActionPerformed

    private void relevanceFeedbackExecuteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relevanceFeedbackExecuteButtonActionPerformed
        // TODO add your handling code here:
        Rocchio rocchio = new Rocchio();
        rocchio.setA(Double.parseDouble(relevanceFeedbackParamA.getText()));
        rocchio.setB(Double.parseDouble(relevanceFeedbackParamB.getText()));
        rocchio.setInitialTreshold(Double.parseDouble(tresholdField.getText()));
        double newTreshold = rocchio.generateNewTreshold(ListOfUserFeedback);
        relevaceFeedbackResult.setText(String.format("%.2f", newTreshold));
        isNewFeedback = true;
        ListOfUserFeedback = new ArrayList<UserFeedback>();
    }//GEN-LAST:event_relevanceFeedbackExecuteButtonActionPerformed

    private String getUserFeedbackText() {
        String text = "";
        for (UserFeedback userFeedback : ListOfUserFeedback) {
            text += ("gambar : "+userFeedback.getIdentifier()+"; X : "+userFeedback.getX()+"; Y : "+userFeedback.getY())+"\n";
        }
        return text;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> MatcherSelector;
    private javax.swing.JTextField XValue;
    private javax.swing.JTextField YValue;
    private javax.swing.JButton addFeedbackButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField blockSizeField;
    private javax.swing.JButton detectButton;
    private javax.swing.JButton detectedImage;
    private javax.swing.JComboBox<String> featureSelector;
    private javax.swing.JTextField image;
    private javax.swing.JScrollPane imagePanel;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField relevaceFeedbackResult;
    private javax.swing.JButton relevanceFeedbackExecuteButton;
    private javax.swing.JTextField relevanceFeedbackParamA;
    private javax.swing.JTextField relevanceFeedbackParamB;
    private javax.swing.JButton selectImageButton;
    private javax.swing.JTextField tresholdField;
    private javax.swing.JTextArea userFeedbackView;
    // End of variables declaration//GEN-END:variables

}