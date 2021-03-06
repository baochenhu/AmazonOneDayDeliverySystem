/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.customer;

import business.customer.Customer;
import business.customer.Invoicement;
import business.customer.Location;
import business.customer.Order;
import business.customer.OrderItem;
import business.customer.Payment;
import business.customer.Tax;
import business.enterprise.AmazonEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import business.network.Network;
import business.organization.AmazonFinanceOrganization;
import business.organization.InventoryOrganization;
import business.organization.Organization;
import business.product.Category;
import business.product.Product;
import business.system.EcoSystem;
import business.workqueue.OrderItemRequest;
import business.workqueue.WorkQueue;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baochenhu
 */
public class CheckoutJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CheckoutJPanel
     */
    Payment payment;
    Order order;
    Customer customer;
    JPanel container;
    Enterprise enterprise;
    EcoSystem ecoSystem;
    double totalAmount;
    public CheckoutJPanel(Order order,Customer customer,JPanel container,Enterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
        this.order=order;
        this.customer=customer;
        this.container=container;
        this.enterprise=enterprise;
        this.ecoSystem=ecoSystem;
        
        populateTable();
        calculateSubAndTax();
    }
    
    private void calculateSubAndTax(){
      float subTotal = order.calSubTotal();
      Tax tax = new Tax(customer.getLocation(),subTotal);
      double taxNum = tax.calculateTax();
      jTextField1.setText(subTotal+"");
      jTextField2.setText(taxNum+"");
      totalAmount=subTotal+taxNum;
      jTextField3.setText(totalAmount+"");
      Location location = customer.getLocation();
      jTextArea1.setText(location.getCountry()+"\n"+location.getState()+"\n"+
               location.getCity()+"\n"+location.getStreet());
    }
    
    
    public void populateTable(){
      DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
      model.setRowCount(0);
      for(OrderItem orderItem: order.getOrderItems())
      {
         Object[] obj=new Object[3];
         obj[0]=orderItem;
         obj[1]=orderItem.getProduct().getPrice();
         obj[2]=orderItem.getQuantity();
         model.addRow(obj);
      }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Place the Order>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 437, 221, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductName", "ProductPrice", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 54, 602, 123));

        jLabel1.setText("Order Item:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 20, 92, 22));

        jLabel2.setText("SubTotal:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 195, -1, -1));

        jLabel3.setText("Tax:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 229, -1, -1));

        jLabel4.setText("Total:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 263, -1, -1));

        jLabel5.setText("Payment method:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 301, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Credit", "Debit" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 297, 263, -1));

        jLabel6.setText("Shipping Address:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 342, -1, -1));

        jButton2.setText("Goto the Homepage>>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 217, -1));

        jTextField1.setEnabled(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 189, 263, -1));

        jTextField2.setEnabled(false);
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 223, 263, -1));

        jTextField3.setEnabled(false);
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 257, 263, -1));

        jButton3.setText("<<Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 484, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 342, 255, -1));

        jButton4.setText("Send Invoicement to Email>>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 210, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       container.remove(this);
       CardLayout cl=(CardLayout) container.getLayout();
       cl.previous(container);
    }//GEN-LAST:event_jButton3ActionPerformed
   //Task 1: add a payment to the customer Account
    public void addPaymentToFinancialAccount(){
       payment = new Payment();
       payment.setPayment(totalAmount);
       payment.setDate(new Date());
       payment.setOrder(order);
       customer.getFinancialAccount().addPayment(payment);
       
    }
    //Task 2: create and add the according invoicement to the Finance Organization
    Invoicement invoicement;
    public void createAndAddInvoiment(){
       invoicement= new Invoicement();
       invoicement.setCustomer(customer);
       invoicement.setOrder(order);
       invoicement.setPayment(payment);
       //cast to Amazon
       AmazonEnterprise amazonEnterprise=(AmazonEnterprise)enterprise;
       //get the Finance Organization and add the invoicement
       for(Organization organization:amazonEnterprise.getOrganizationList()){
          if(organization instanceof AmazonFinanceOrganization){
             AmazonFinanceOrganization amazonFinanceOrganization= (AmazonFinanceOrganization)organization;
             amazonFinanceOrganization.getInvoicementHistory().addInvoicement(invoicement);
          }   
       }
    }
    //Task 3:place the OrderItem Request to According Enterprise Organziation
    private void dispatchOrderItem(){
        for(Network network:ecoSystem.getNetworks())
       {
          for(Enterprise enterprise:network.getEnterpriseList())
          {
              for(OrderItem orderItem: order.getOrderItems())
              {
                 if(enterprise.equals(orderItem.getProduct().getSupplyEnterprise())){
                    SupplierEnterprise supplierEnterprise=(SupplierEnterprise) orderItem.getProduct().getSupplyEnterprise();
                    OrderItemRequest orderItemRequest=new OrderItemRequest();
                    orderItemRequest.setOrderItem(orderItem);
                    orderItemRequest.setStatus("Inventory");
                   
                    for(Organization organization:supplierEnterprise.getOrganizationList())
                    {   
                        if(organization instanceof InventoryOrganization)
                        {
                           orderItemRequest.setSender(customer);
                           orderItemRequest.setReceiver(organization);
                           orderItemRequest.setBeginDate(new Date());
                           InventoryOrganization inventoryOrganization=(InventoryOrganization)organization;
                           WorkQueue workQueue=inventoryOrganization.getWorkQueue();
                           workQueue.createAndAddWorkRequest(orderItemRequest);
                           customer.getWorkQueue().createAndAddWorkRequest(orderItemRequest);
                        }
                    
                    }
                 }
              }  
          }
       }
    
    
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addPaymentToFinancialAccount();
        createAndAddInvoiment();
        dispatchOrderItem();
        customer.getOrderDirectory().add(order);
        JOptionPane.showMessageDialog(null, "Congralations!! YOUR ORDR HAS BEEN PLACED");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      container.remove(this);
       CardLayout cl=(CardLayout) container.getLayout();
       cl.first(container);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       EmailJPanel emailJPanel=new EmailJPanel(container, invoicement);
       container.add(emailJPanel,"emailJPanel");
        CardLayout cl=(CardLayout) container.getLayout();
        cl.next(container);
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
