/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.enterpriseAdminRole;

import business.customer.Location;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import userInterface.MapVisual.MapJFrame;

/**
 *
 * @author baochenhu
 */
public class ManageEnterpriseLocationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseLocationJPanel
     */
    JPanel container;
    Enterprise enterprise;
    public ManageEnterpriseLocationJPanel(JPanel container,Enterprise enterprise) {
        initComponents();
        this.container=container;
        this.enterprise=enterprise;
    }
    
       public  double[] sendGet(String url,String param)
    {
        String result="";
        double[] longAndLat=new double[2];
       //  double resultInt=0;
        BufferedReader in=null;
        try{
          String urlName=url+"?"+param;
          URL realUrl=new URL(urlName);
          URLConnection conn=realUrl.openConnection();
          conn.setRequestProperty("accept", "*/*");
          conn.setRequestProperty("connection", "Keep-Alive");
          conn.setRequestProperty("user-agent", "Mozilla/4.0)");
          conn.connect();
//          Map<String,List<String>> map=conn.getHeaderFields();
//          for(String key:map.keySet()){
//              System.out.println(key+"--->"+map.get(key));
//          }
          InputStream inputStream=conn.getInputStream();
          JsonReader jsonReader=Json.createReader(inputStream);
          JsonObject obj=jsonReader.readObject();
         
        JsonArray results=obj.getJsonArray("results");
         for(JsonObject r:results.getValuesAs(JsonObject.class)){
             JsonNumber jn=r.getJsonObject("geometry").getJsonObject("location").getJsonNumber("lat");
             JsonNumber jn1=r.getJsonObject("geometry").getJsonObject("location").getJsonNumber("lng");
             longAndLat[0]=jn.doubleValue();
             longAndLat[1]=jn1.doubleValue();
             
            // System.out.println(jn.toString());
            //  System.out.println(jn1.toString());
            // System.out.println(r.getJsonString("formatted_address"));
         } }catch(Exception e){
           System.out.println("Exception");
           e.printStackTrace();
        }finally
        {
           try
           {
             if(in!=null)
             {
                in.close();
             }
           }
           catch(IOException ex)
           {
              ex.printStackTrace();
           }
        
        }
       return longAndLat;
     //  return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("GLOBE");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("USA");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Massatussates");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Boston");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Malden");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Quincy");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("California");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Los Angeles");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("San Francisco");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        jScrollPane2.setViewportView(jScrollPane1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 0, 185, 516));

        jButton1.setText("Create Location");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 159, 257, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 86, 257, -1));

        jTextField3.setEnabled(false);
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 415, 129, -1));

        jLabel2.setText("Your Location is:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 230, 109, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane3.setViewportView(jTextArea1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 273, -1, -1));

        jButton3.setText("Grap L&L FROM INTERNET>>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 449, -1, -1));

        jLabel3.setText("Longtitude:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 375, -1, -1));

        jLabel4.setText("Latitude:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 421, -1, -1));

        jTextField2.setEnabled(false);
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 369, 129, -1));

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 449, -1, -1));

        jLabel1.setText("Street Address:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 32, -1, -1));

        jButton4.setText("View>>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 484, 298, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Location location=new Location();
        DefaultTreeModel model =  (DefaultTreeModel) jTree1.getModel();
        TreePath[] treepath=jTree1.getSelectionPaths();
        DefaultMutableTreeNode last=(DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        TreeNode[] path=last.getPath();
        location.setCountry(path[1].toString());
        location.setState(path[2].toString());
        location.setCity(path[3].toString());
        location.setStreet(jTextField1.getText());
        jTextArea1.setText(location.getCountry()+"\n"+location.getState()+"\n"+
            location.getCity()+"\n"+location.getStreet());
        ((SupplierEnterprise)enterprise).setLocation(location);
        // location.setCountry(TOOL_TIP_TEXT_KEY);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        container.remove(this);
        CardLayout cl=(CardLayout) container.getLayout();
        cl.previous(container);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MapJFrame mapJFrame=new MapJFrame(((SupplierEnterprise)enterprise).getLocation().getLatitude(),  ((SupplierEnterprise)enterprise).getLocation().getLongtitude());
        mapJFrame.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed
  
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
       SupplierEnterprise supplierEnterprise=(SupplierEnterprise)enterprise;
       String street=supplierEnterprise.getLocation().getStreet();
       String city=supplierEnterprise.getLocation().getCity();
       String state=supplierEnterprise.getLocation().getState();
       String country=supplierEnterprise.getLocation().getCountry();
       
       String location=URLEncoder.encode(street+" "+city+" "+state+" "+country);
       double[] ll=sendGet("http://maps.googleapis.com/maps/api/geocode/json", "address="+location+"&sensor=false");
       jTextField2.setText(ll[0]+"");
       jTextField3.setText(ll[1]+"");
       supplierEnterprise.getLocation().setLatitude(ll[0]);
       supplierEnterprise.getLocation().setLongtitude(ll[1]);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Network has problem");
       
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}