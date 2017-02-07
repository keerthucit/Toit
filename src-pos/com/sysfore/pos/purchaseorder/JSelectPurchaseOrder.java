//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2009 Openbravo, S.L.
//    http://www.openbravo.com/product/pos
//
//    This file is part of Openbravo POS.
//
//    Openbravo POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Openbravo POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.
package com.sysfore.pos.purchaseorder;

import com.openbravo.basic.BasicException;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.customers.DataLogicCustomers;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppUser;
import com.openbravo.pos.forms.DataLogicSystem;
import com.openbravo.pos.ticket.RetailTicketInfo;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Properties;

public class JSelectPurchaseOrder extends JDialog {
private java.util.List<PurchasePojo> list=null;
    private static DataLogicSystem m_dlSystem;
    private String primaryid=null;
    AppUser appUser = null;
    private String hiddenname;
    public javax.swing.JDialog dEdior = null;
    private Properties dbp = new Properties();
    //static DataLogicReceipts dlReceipts = null;
    private DataLogicCustomers dlCustomers = null;
    private AppView m_app;
    public String[] strings = {""};
    public DefaultListModel model = null;
   // public java.util.List<DiscountRateinfo> list = null;
    public boolean updateMode = false;
    public JPanel parent = null;
    static RetailTicketInfo tinfoLocal = null;
    public static JPurchaseInvoice purchaseInvoice;
    static Component parentLocal = null;
    int x = 530;
    int y = 270;
    int width = 320;
    int height = 100;

    private JSelectPurchaseOrder(Frame frame, boolean b) {
        super(frame, b);
        setBounds(x, y, width, height);

    }

    private JSelectPurchaseOrder(Dialog dialog, boolean b) {
        super(dialog, b);
        setBounds(x, y, width, height);
    }

    public static void showMessage(Component parent, DataLogicCustomers dlCustomers, AppView m_App, JPurchaseInvoice jpurchase) throws BasicException {
      //  tinfoLocal = tinfo;
        parentLocal = parent;
        purchaseInvoice = jpurchase;
        m_dlSystem = (DataLogicSystem) m_App.getBean("com.openbravo.pos.forms.DataLogicSystem");
       // dlReceipts = (DataLogicReceipts) m_App.getBean("com.openbravo.pos.sales.DataLogicReceipts");
        dlCustomers = (DataLogicCustomers) m_App.getBean("com.openbravo.pos.customers.DataLogicCustomers");
        showMessage(parent, dlCustomers);
    }

    private static void showMessage(Component parent, DataLogicCustomers dlCustomers) {

        Window window = getWindow(parent);
        JSelectPurchaseOrder myMsg;
        if (window instanceof Frame) {
            myMsg = new JSelectPurchaseOrder((Frame) window, true);
        } else {
            myMsg = new JSelectPurchaseOrder((Dialog) window, true);
        }
        myMsg.init(dlCustomers);

    }

    public void init(DataLogicCustomers dlCustomers) {

        initComponents();
        Window window = getWindow(parent);
        try {
             jPOCombo.addItem("");
        list =dlCustomers.getPurchaseOrder();
              for(PurchasePojo dis:list)
               {
                   primaryid=dis.getId();
                   System.out.println(dis.getDocumentno());  
                  jPOCombo.addItem(dis.getDocumentno());  
               }
               // jPOCombo.setSelectedIndex(-1);
              
          }
      catch(Exception e)
      {
        System.out.println("Exception"); 
      }
       
       
        setTitle("Purchase Order");
        setVisible(true);
        File file = new File(System.getProperty("user.home") + "/openbravopos.properties");
        AppConfig ap = new AppConfig(file);
        ap.load();
        //setBounds(180, 100, 200, 200);
    }
        
        
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPOCombo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 200));

        jPanel1.setMaximumSize(new java.awt.Dimension(200, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 300));
        jPanel1.setLayout(null);

        jLabel1.setText("Purchase Order");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 30, 120, 14);

        jPOCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPOComboActionPerformed(evt);
            }
        });
        jPanel1.add(jPOCombo);
        jPOCombo.setBounds(150, 30, 150, 20);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(70, 70, 75, 23);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(160, 70, 75, 23);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void jPOComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPOComboActionPerformed
        // TODO add your handling code here:
         
         
    }//GEN-LAST:event_jPOComboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      String DocNo= jPOCombo.getSelectedItem().toString();
  // purchaseInvoice.clearProducts();
  // purchaseInvoice.clearAddresses();
        System.out.println("jPOCombo.getSelectedIndex()-1).getId()"+list.get(jPOCombo.getSelectedIndex()-1).getDocumentno());
      String poid = list.get(jPOCombo.getSelectedIndex()-1).getId();
        purchaseInvoice.PIAction(poid);
       this.dispose();       
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox jPOCombo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

  

    

    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

   

    private void closeDialog() {
        this.dispose();
    }
}
