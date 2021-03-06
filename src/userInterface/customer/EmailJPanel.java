/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.customer;

import business.customer.Invoicement;
import emailservice.SimpleSender;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author baochenhu
 */
public class EmailJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmailJPanel
     */
    JPanel container;
    Invoicement invoicement;
    public EmailJPanel(JPanel container,Invoicement invoicement) {
        initComponents();
        this.container=container;
        this.invoicement=invoicement;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("To:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 170, 83, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 164, 333, -1));

        jLabel2.setText("From:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 272, -1, 25));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 270, 333, -1));

        jButton1.setText("Send>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 367, -1, -1));

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 367, -1, -1));

        jLabel3.setFont(new java.awt.Font("Malayalam MN", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 51));
        jLabel3.setText("Send Invoicement via e-mail");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 68, 305, 45));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // new Thread(new Runnable() {

        // @Override
      //   public void run() {
         //if(invoicement!=null){
      //   String smtpServer="smtp.gmail.com";
         String to=jTextField1.getText();
         String from=jTextField2.getText();
         String subject="Invoicement";
         String body=invoicement.getCustomer().getCustomerName()+invoicement.getPayment().getPayment();
      //   System.out.println("good");
         SimpleSender simpleSender=new SimpleSender();
           System.out.println("aa");
         simpleSender.Send(to, from, subject,body);
      //}else{
          JOptionPane.showMessageDialog(null, "Sending Email Succeed");
      //}
     //    }
   //  });
             
//      if(invoicement!=null){
//      String smtpServer="smtp.gmail.com";
//      String to=jTextField1.getText();
//      String from=jTextField2.getText();
//      String subject="Invoicement";
//      String body=invoicement.getCustomer().getCustomerName()+invoicement.getPayment().getPayment();
//      System.out.println("good");
//      SimpleSender.Email(smtpServer,to,from,subject,body);
//      }else{
//          JOptionPane.showMessageDialog(null, "Sending Email Fails");
//      }
//      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       container.remove(this);
       CardLayout cl=(CardLayout) container.getLayout();
       cl.previous(container);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
