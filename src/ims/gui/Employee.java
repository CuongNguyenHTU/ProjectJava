/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.gui;

import ims.dal.Employee_ManagementDAL;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import ims.gui.EmployeeList;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author NAT
 */
public class Employee extends javax.swing.JFrame{
    
    Employee_ManagementDAL con;
    private int flag = 0;
    String filename = null;
    byte[] person_image = null;
    /**
     * Creates new form Employee
     */

    public Employee() {
        initComponents();
        //stateButton(true);
        setInfoDialog();
        con = new Employee_ManagementDAL();
        showData();
        HideTextBox(false);
        LoadDataCB();
    }
    
    //Viết hàm ẩn textfield
    public void HideTextBox (boolean a){
        jtfTuoi.setEnabled(a);    
    }
    
    //Load data lên jTable
    public void showData() {
        String[] columnNames = {"Mã NV", "Dân tộc", "Quốc tịch", "Tỉnh thành", "Tôn giáo", "Họ lót",
            "Tên NV", "Biệt danh", "Ngày sinh", "Tuổi", "Giới tính", "Nơi sinh", "Số CMND",
            "Ngày cấp CMND", "Nơi cấp", "Tình trạng hôn nhân", "Đc thường trú", "Đc tạm trú", "Đc khẩn cấp", "Người thân","Image"};

        //Chua du lieu tu sql do vao jtable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable1.setModel(model);

        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);

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
    
    //Viết hàm Load data lên Combobox
    public void LoadDataCB() {
        try {
            ResultSet rsDanToc = con.getData("SELECT * from DanToc");
            ResultSet rsQuocTich = con.getData("SELECT * from QuocTich");
            ResultSet rsNoiCap = con.getData("SELECT * from TinhThanh");
            ResultSet rsTinhThanh = con.getData("SELECT * from TinhThanh");
            ResultSet rsTonGiao = con.getData("SELECT * from TonGiao");
            ResultSet rsSex = con.getData("SELECT * from GioiTinh");
            ResultSet rsStatusHonNhan = con.getData("SELECT * from HonNhan");
            while (rsDanToc.next()) {
                this.jcbDantoc.addItem(rsDanToc.getString("MaDT"));
            }
            while (rsQuocTich.next()) {
                this.jcbQuocTich.addItem(rsQuocTich.getString("MaQT"));
            }
            while (rsNoiCap.next()) {
                this.jcbNoiCap.addItem(rsNoiCap.getString("MaTT"));
            }
            while (rsTinhThanh.next()) {
                this.jcbTinhThanh.addItem(rsTinhThanh.getString("MaTT"));
            }
            while (rsTonGiao.next()) {
                this.jcbTonGiao.addItem(rsTonGiao.getString("MaTG"));
            }
            while (rsSex.next()) {
                this.jcbSex.addItem(rsSex.getString("GioiTinh"));
            }
            while (rsStatusHonNhan.next()) {
                this.jcbStatusHonNhan.addItem(rsStatusHonNhan.getString("StatusHonNhan"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Thông báo lỗi", 1);
        }
    }
    
    //Viết hàm insert
    public void insertData() {       
        String[] stringSQL = {jtfMaNV.getText(), jcbDantoc.getSelectedItem().toString(), jcbQuocTich.getSelectedItem().toString(),
            jcbTinhThanh.getSelectedItem().toString(), jcbTonGiao.getSelectedItem().toString(), jtfHoLot.getText(),
            jtfTen.getText(), jtfBietDanh.getText(), jtfNgaySinh.getText(), jtfTuoi.getText(), jcbSex.getSelectedItem().toString(), jtfNoiSinh.getText(),
            jtfCMND.getText(), jtfNgayCap.getText(), jcbNoiCap.getSelectedItem().toString(),
            jcbStatusHonNhan.getSelectedItem().toString(),
            jtfDCThuongtru.getText(), jtfDCTamtru.getText(), jtfDCKhancap.getText(), jtfNguoithan.getText(), path.getText()};
        int insert = con.EMPLOYEE_Insert(stringSQL);
        if (insert > 0) {
            JOptionPane.showMessageDialog(this, "Thêm Employee thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Employee không thành công!");
        }
        showData();
    }
  
    //Viết hàm update data
    public void updateData() {
        String[] stringSQL = {jcbDantoc.getSelectedItem().toString(), jcbQuocTich.getSelectedItem().toString(),
            jcbTinhThanh.getSelectedItem().toString(), jcbTonGiao.getSelectedItem().toString(), jtfHoLot.getText(),
            jtfTen.getText(), jtfBietDanh.getText(), jtfNgaySinh.getText(), jtfTuoi.getText(), jcbSex.getSelectedItem().toString(), jtfNoiSinh.getText(),
            jtfCMND.getText(), jtfNgayCap.getText(), jcbNoiCap.getSelectedItem().toString(),
            jcbStatusHonNhan.getSelectedItem().toString(),
            jtfDCThuongtru.getText(), jtfDCTamtru.getText(), jtfDCKhancap.getText(), jtfNguoithan.getText(), path.getText() ,jtfMaNV.getText()};
        int update = con.EMPLOYEE_update(stringSQL);
        if (update > 0) {
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa không thành công!");
        }
        showData();
    }
    
    //Viết hàm delete
    public void deleteData() {
        String[] stringSQL = {jtfMaNV.getText()};

        int delete = con.EMPLOYEE_delete(stringSQL);

        if (delete > 0) {
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa không thành công!");
        }
        showData();
    }
    
    public  void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);        
        setResizable(false);
    }
    
    
    public void ReFresh() {
        jtfMaNV.setText("");
        jtfHoLot.setText("");
        jtfTen.setText("");
        jtfBietDanh.setText("");
        jtfNgaySinh.setText("");
        jtfTuoi.setText("");
        jtfNoiSinh.setText("");
        jtfCMND.setText("");
        jtfNgayCap.setText("");
        jtfDCThuongtru.setText("");
        jtfDCTamtru.setText("");
        jtfDCKhancap.setText("");
        jtfNguoithan.setText("");
    }
    //Lấy dữ liệu từ jTable ứng với từng thuộc tính trên UI
    public void getSelectedData(){
        int selectRow = jTable1.getSelectedRow();
        jtfMaNV.setText(jTable1.getValueAt(selectRow,0).toString());       
        jcbDantoc.setSelectedItem(jTable1.getValueAt(selectRow,1));
        jcbQuocTich.setSelectedItem(jTable1.getValueAt(selectRow,2));
        jcbTinhThanh.setSelectedItem(jTable1.getValueAt(selectRow,3));
        jcbTonGiao.setSelectedItem(jTable1.getValueAt(selectRow,4));
        jtfHoLot.setText(jTable1.getValueAt(selectRow,5).toString());
        jtfTen.setText(jTable1.getValueAt(selectRow,6).toString());
        jtfBietDanh.setText(jTable1.getValueAt(selectRow,7).toString());
        jtfNgaySinh.setText(jTable1.getValueAt(selectRow,8).toString());
        jtfTuoi.setText(jTable1.getValueAt(selectRow,9).toString());
        jcbSex.setSelectedItem(jTable1.getValueAt(selectRow,10));
        jtfNoiSinh.setText(jTable1.getValueAt(selectRow,11).toString());
        jtfCMND.setText(jTable1.getValueAt(selectRow,12).toString());
        jtfNgayCap.setText(jTable1.getValueAt(selectRow,13).toString());
        jcbNoiCap.setSelectedItem(jTable1.getValueAt(selectRow,14));
        jcbStatusHonNhan.setSelectedItem(jTable1.getValueAt(selectRow,15));
        jtfDCThuongtru.setText(jTable1.getValueAt(selectRow,16).toString());
        jtfDCTamtru.setText(jTable1.getValueAt(selectRow,17).toString());
        jtfDCKhancap.setText(jTable1.getValueAt(selectRow,18).toString());
        jtfNguoithan.setText(jTable1.getValueAt(selectRow, 19).toString());
        path.setText(jTable1.getValueAt(selectRow, 20).toString());
    }
//    public void stateButton(boolean value){
//        
//        btNew.setVisible(value);
//        btEdit.setVisible(value);
//        btDelete.setVisible(value);
//        btPrint.setVisible(value);
//        btClose.setVisible(value);
//        btSave.setVisible(!value);
//        btCancel.setVisible(!value);
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNew = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfHoLot = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfNgaySinh = new javax.swing.JTextField();
        jtfTen = new javax.swing.JTextField();
        jtfTuoi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbSex = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcbTinhThanh = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfBietDanh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcbDantoc = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jtfDCThuongtru = new javax.swing.JTextField();
        jtfDCTamtru = new javax.swing.JTextField();
        jtfDCKhancap = new javax.swing.JTextField();
        jtfNguoithan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jtfNgayCap = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jcbNoiCap = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcbQuocTich = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jcbTonGiao = new javax.swing.JComboBox<>();
        jcbStatusHonNhan = new javax.swing.JComboBox<>();
        jtfNoiSinh = new javax.swing.JTextField();
        jtfCMND = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfMaNV = new javax.swing.JTextField();
        jlb_Image = new javax.swing.JLabel();
        path = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btChoose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee_Management");

        btNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNew.setText("Insert");
        btNew.setPreferredSize(new java.awt.Dimension(75, 23));
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEdit.setText("Update");
        btEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btDelete.setText("Delete");
        btDelete.setPreferredSize(new java.awt.Dimension(75, 23));
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btPrint.setText("Refresh");
        btPrint.setPreferredSize(new java.awt.Dimension(75, 23));
        btPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintActionPerformed(evt);
            }
        });

        btClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btClose.setText("Exit");
        btClose.setPreferredSize(new java.awt.Dimension(75, 23));
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        btSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSave.setText("Save");
        btSave.setPreferredSize(new java.awt.Dimension(75, 23));
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btCancel.setText("Cancel");
        btCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Họ Lót");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tuổi");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Giới Tính");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nơi Sinh");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Quê Quán");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Số CMND");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Ngày Cấp");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tên");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Ngày Sinh");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Biệt Danh");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Status Hôn Nhân");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Dân Tộc");

        jcbDantoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDantocActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Địa Chỉ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Thường Trú");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tạm Trú");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Khẩn Cấp");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Người Thân");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Nơi Cấp");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Quốc Tịch");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tôn Giáo");

        jcbStatusHonNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStatusHonNhanActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Mã NV");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Path");

        btChoose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btChoose.setText("Choose");
        btChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 221, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfNguoithan, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jcbDantoc, javax.swing.GroupLayout.Alignment.TRAILING, 0, 363, Short.MAX_VALUE)
                                                    .addComponent(jcbStatusHonNhan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jtfHoLot)
                                                    .addComponent(jtfTen, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtfTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jcbTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtfCMND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jtfNoiSinh, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jcbSex, javax.swing.GroupLayout.Alignment.LEADING, 0, 174, Short.MAX_VALUE)
                                                        .addComponent(jtfNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel10))
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jtfNgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel2)
                                            .addComponent(jlb_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbNoiCap, 0, 190, Short.MAX_VALUE)
                                    .addComponent(jtfBietDanh)
                                    .addComponent(jcbQuocTich, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbTonGiao, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(path, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btChoose))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jtfDCTamtru, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfDCThuongtru)
                            .addComponent(jtfDCKhancap))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfHoLot, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jtfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jtfBietDanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTuoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcbSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jcbTinhThanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btChoose)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jlb_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jcbNoiCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jtfNgayCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbQuocTich)
                            .addComponent(jcbStatusHonNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jcbDantoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jcbTonGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jtfDCThuongtru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jtfDCTamtru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jtfDCKhancap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jtfNguoithan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        //stateButton(false);
        HideTextBox(true);
        btSave.setEnabled(true);
        flag = 1;
        btNew.setEnabled(false);
        btEdit.setEnabled(false);
        btDelete.setEnabled(false);
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        //stateButton(true);
        if (flag == 1) {
            insertData();
            btNew.setEnabled(true);
            btEdit.setEnabled(true);
            btDelete.setEnabled(true);
        }else if(flag == 2){
            updateData();
            btNew.setEnabled(true);
            btEdit.setEnabled(true);
            btDelete.setEnabled(true); 
        }else{
            if(this.jtfMaNV.getText().length() == 0)
                JOptionPane.showMessageDialog(null,"Bạn cần chọn Mã nhân viên để xóa","Thông báo lỗi!", 1);
            else
            {
                if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo!", 2)==0)
                    deleteData();
            }         
            btNew.setEnabled(true);
            btEdit.setEnabled(true);
            btDelete.setEnabled(true);
        }
        HideTextBox(false);
        btSave.setEnabled(false);
    }//GEN-LAST:event_btSaveActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        //stateButton(false);
        HideTextBox(true);
        btSave.setEnabled(true);
        flag = 2;
        btNew.setEnabled(false);
        btEdit.setEnabled(false);
        btDelete.setEnabled(false);
    }//GEN-LAST:event_btEditActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
         //stateButton(true);// TODO add your handling code here:
        HideTextBox(false);
        btSave.setEnabled(false);
        flag = 4;
        btNew.setEnabled(true);
        btEdit.setEnabled(true);
        btDelete.setEnabled(true);
    }//GEN-LAST:event_btCancelActionPerformed

    private void jcbDantocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDantocActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcbDantocActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    private void jcbStatusHonNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStatusHonNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbStatusHonNhanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        getSelectedData();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        HideTextBox(true);
        btSave.setEnabled(true);
        flag = 3;
        btNew.setEnabled(false);
        btEdit.setEnabled(false);
        btDelete.setEnabled(false);
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        // TODO add your handling code here:
        ReFresh();
    }//GEN-LAST:event_btPrintActionPerformed

    private void btChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChooseActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        path.setText(filename);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(jlb_Image.getWidth(), jlb_Image.getHeight(),Image.SCALE_SMOOTH));
        jlb_Image.setIcon(imageIcon);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum;(readNum = fis.read(buf))!= -1;){
                bos.write(buf, 0, readNum);
            }
            person_image = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btChooseActionPerformed

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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btChoose;
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btPrint;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbDantoc;
    private javax.swing.JComboBox<String> jcbNoiCap;
    private javax.swing.JComboBox<String> jcbQuocTich;
    private javax.swing.JComboBox<String> jcbSex;
    private javax.swing.JComboBox<String> jcbStatusHonNhan;
    private javax.swing.JComboBox<String> jcbTinhThanh;
    private javax.swing.JComboBox<String> jcbTonGiao;
    private javax.swing.JLabel jlb_Image;
    private javax.swing.JTextField jtfBietDanh;
    private javax.swing.JTextField jtfCMND;
    private javax.swing.JTextField jtfDCKhancap;
    private javax.swing.JTextField jtfDCTamtru;
    private javax.swing.JTextField jtfDCThuongtru;
    private javax.swing.JTextField jtfHoLot;
    private javax.swing.JTextField jtfMaNV;
    private javax.swing.JTextField jtfNgayCap;
    private javax.swing.JTextField jtfNgaySinh;
    private javax.swing.JTextField jtfNguoithan;
    private javax.swing.JTextField jtfNoiSinh;
    private javax.swing.JTextField jtfTen;
    private javax.swing.JTextField jtfTuoi;
    private javax.swing.JTextField path;
    // End of variables declaration//GEN-END:variables

    
}
