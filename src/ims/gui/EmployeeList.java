/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ims.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ims.dal.Employee_ManagementDAL;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
/**
 *
 * @author NAT
 */
public class EmployeeList extends javax.swing.JFrame {
    
    Employee_ManagementDAL con;
    private int flag = 0;
    /** Creates new form EmployeeList */
    public EmployeeList() {
        initComponents();
        setInfoDialog();
        con = new Employee_ManagementDAL();
        showData();
        Keylistener();
        ShowTT();
    }
    
    public void ShowTT (){
        jLabel1.setText("Hiện có "+jTableEmployee.getRowCount()+" nhân viên!");
    }
       
    //Tắt chương trình bằng ESC
    public void Keylistener(){
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát chương trình?","Thông báo!",2)==0)                        
                        dispose();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });      
    }
    
    public  void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);        
        setResizable(false);
    }
    
    //Load data lên jTable
    public void showData() {
        String[] columnNames = {"Mã NV", "Dân tộc", "Quốc tịch", "Tỉnh thành", "Tôn giáo", "Họ lót",
            "Tên NV", "Biệt danh", "Ngày sinh", "Tuổi", "Giới tính", "Nơi sinh", "Số CMND",
            "Ngày cấp CMND", "Nơi cấp", "Tình trạng hôn nhân", "Đc thường trú", "Đc tạm trú", "Đc khẩn cấp", "Người thân","Image"};

        //Chua du lieu tu sql do vao jtable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTableEmployee.setModel(model);
        jTableEmployee.setAutoResizeMode(jTableEmployee.AUTO_RESIZE_OFF);
             
        String MaNV = "";
        String MaDT = "";
        String MaQT = "";
        String MaTT = "";
        String MaTG = "";
        String HoLotEml = "";
        String TenEml = "";
        String BietDanh = "";
        String NgaySinh = "";
        String Tuoi = "";
        String GioiTinh = "";
        String NoiSinh = "";
        String SoCMND = "";
        String NgayCapCMND = "";
        String NoiCap = "";
        String StatusHonNhan = "";
        String DiaChiThuongtru = "";
        String DiaChiTamTru = "";
        String DiaChiKhanCap = "";
        String TenNguoiThan = "";
        String Image = "";

        ResultSet rs = con.getData("SELECT * FROM Employee");
        try {
            while (rs.next()) {
                MaNV = rs.getString("MaNV");
                MaDT = rs.getString("MaDT");
                MaQT = rs.getString("MaQT");
                MaTT = rs.getString("MaTT");
                MaTG = rs.getString("MaTG");
                HoLotEml = rs.getString("HoLotEml");
                TenEml = rs.getString("TenEml");
                BietDanh = rs.getString("BietDanh");
                NgaySinh = rs.getString("NgaySinh");
                Tuoi = rs.getString("Tuoi");
                GioiTinh = rs.getString("GioiTinh");
                NoiSinh = rs.getString("NoiSinh");
                SoCMND = rs.getString("SoCMND");
                NgayCapCMND = rs.getString("NgayCapCMND");
                NoiCap = rs.getString("NoiCap");
                StatusHonNhan = rs.getString("StatusHonNhan");
                DiaChiThuongtru = rs.getString("DiaChiThuongtru");
                DiaChiTamTru = rs.getString("DiaChiTamTru");
                DiaChiKhanCap = rs.getString("DiaChiKhanCap");
                TenNguoiThan = rs.getString("TenNguoiThan");
                Image = rs.getString("Image");
                
                model.addRow(new Object[]{MaNV, MaDT, MaQT, MaTT, MaTG, HoLotEml, TenEml, BietDanh, NgaySinh, Tuoi, GioiTinh,
                    NoiSinh, SoCMND, NgayCapCMND, NoiCap, StatusHonNhan, DiaChiThuongtru, DiaChiTamTru, DiaChiKhanCap, TenNguoiThan, Image});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee_ManagementDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btNew = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        btNew.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ims/images/add-icon.png"))); // NOI18N
        btNew.setFocusable(false);
        btNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btNew);
        jToolBar1.add(jSeparator1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ims/images/Edit.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ims/images/X.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator3);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ims/images/Load.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator4);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Exit");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 25));

        jTableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã ", "Họ", "Tên", "Ngày sinh", "Nơi sinh"
            }
        ));
        jScrollPane1.setViewportView(jTableEmployee);
        if (jTableEmployee.getColumnModel().getColumnCount() > 0) {
            jTableEmployee.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableEmployee.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 820, 450));

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        Employee emGui= new Employee();
        emGui.setVisible(true);
    }//GEN-LAST:event_btNewActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát chương trình?","Thông báo!",2)==0)
            this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Employee emGui= new Employee();
        emGui.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Employee emGui= new Employee();
        emGui.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new EmployeeList().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát chương trình?","Thông báo!",2)==0)
            this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNew;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTable jTableEmployee;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
