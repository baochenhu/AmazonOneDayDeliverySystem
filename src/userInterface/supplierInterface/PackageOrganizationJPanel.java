/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.supplierInterface;

import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.ShipOrganization;
import business.system.EcoSystem;
import business.workqueue.OrderItemRequest;
import business.workqueue.WorkRequest;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baochenhu
 */
public class PackageOrganizationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PackageOrganizationJPanel
     */
    JPanel container;
    Organization organization;
    Enterprise enterprise;
    EcoSystem ecosystem;
    public PackageOrganizationJPanel(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
        this.container=container;
        this.organization=organization;
        this.enterprise=enterprise;
        this.ecosystem=ecosystem;
        populateTable();
    }
    
    public void populateTable(){
     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
     model.setRowCount(0);
     for(WorkRequest workRequest:organization.getWorkQueue().getWorkQueue())
     {
         OrderItemRequest orderItemRequest=(OrderItemRequest)workRequest;
         Object[] obj= new Object[3];
         obj[0]=orderItemRequest;
         obj[1]=orderItemRequest.getStatus();
         obj[2]=orderItemRequest.getFragile();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product", "Status", "FRAGILE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, 630, 203));

        jButton1.setText("Process>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 301, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setText("Package Department");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jRadioButton1.setText("FRAGILE");
        add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 302, 152, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int selectedRow = jTable1.getSelectedRow();
       if(selectedRow>=0)
       {
          OrderItemRequest orderItemRequest = (OrderItemRequest) jTable1.getValueAt(selectedRow, 0);
          orderItemRequest.setStatus("Shipping");
          orderItemRequest.setPackageDate(new Date());
          if(jRadioButton1.isSelected()){
          orderItemRequest.setFragile("FRAGILE");
          }
          for(Organization organization : enterprise.getOrganizationList())
          {
             if(organization instanceof ShipOrganization)
             {
                 ShipOrganization shipOrganization=(ShipOrganization)organization;
                 shipOrganization.getWorkQueue().createAndAddWorkRequest(orderItemRequest);
             }
          }
       }
       populateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
