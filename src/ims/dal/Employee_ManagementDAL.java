/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Demon
 */
public class Employee_ManagementDAL {
    
    Connection con;
   
    //Ham ket noi
    public Employee_ManagementDAL(){
         try {                
            String URL = "jdbc:sqlserver://DESKTOP-LVM1F93:1433;databaseName=Employee_Management;user=sa;password=123456";
            con = DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            Logger.getLogger(Employee_ManagementDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    //Viết hàm lấy dữ liệu từ database
    public ResultSet getData(String stringSQL){
        ResultSet rs = null;
        Statement state;
        try {
            state = con.createStatement();
            rs = state.executeQuery(stringSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Employee_ManagementDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //Viết hàm insert dữ liệu
    public int EMPLOYEE_Insert (String[] stringSQL){
        int row = 0;
        String insert = "INSERT INTO Employee(MaNV, MaDT, MaQT, MaTT, MaTG, HoLotEml, TenEml, BietDanh, NgaySinh"
                + ",Tuoi ,GioiTinh, NoiSinh,SoCMND, NgayCapCMND, NoiCap, StatusHonNhan, DiaChiThuongtru, DiaChiTamTru"
                + ", DiaChiKhanCap, TenNguoiThan, Image) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stament;
        try {
            stament = con.prepareCall(insert);          
            stament.setString(1,stringSQL[0]);
            stament.setString(2,stringSQL[1]);
            stament.setString(3,stringSQL[2]);
            stament.setString(4,stringSQL[3]);
            stament.setString(5,stringSQL[4]);
            stament.setString(6,stringSQL[5]);
            stament.setString(7,stringSQL[6]);
            stament.setString(8,stringSQL[7]);
            stament.setString(9,stringSQL[8]);
            stament.setString(10,stringSQL[9]);
            stament.setString(11,stringSQL[10]);
            stament.setString(12,stringSQL[11]);
            stament.setString(13,stringSQL[12]);
            stament.setString(14,stringSQL[13]);
            stament.setString(15,stringSQL[14]);
            stament.setString(16,stringSQL[15]);
            stament.setString(17,stringSQL[16]);
            stament.setString(18,stringSQL[17]);
            stament.setString(19,stringSQL[18]);
            stament.setString(20,stringSQL[19]);
            stament.setString(21,stringSQL[20]);
            row = stament.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Employee_ManagementDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    //Viết hàm update dữ liệu
    public int EMPLOYEE_update (String[] stringSQL){
        int row = 0;
        String update = "UPDATE EMPLOYEE SET MaDT=?, MaQT=? ,MaTT=?, MaTG=?, HoLotEml=?, TenEml=?, BietDanh=?, "
                + "NgaySinh=?,Tuoi=? ,GioiTinh=?, NoiSinh=?, SoCMND=? , NgayCapCMND=?, NoiCap=?, StatusHonNhan=?, "
                + "DiaChiThuongtru=?, DiaChiTamTru=?, DiaChiKhanCap=?, TenNguoiThan=?, Image=? WHERE MaNV=?";
        PreparedStatement stament;
        try {
            stament = con.prepareCall(update);
            stament.setString(1,stringSQL[0]);
            stament.setString(2,stringSQL[1]);
            stament.setString(3,stringSQL[2]);
            stament.setString(4,stringSQL[3]);
            stament.setString(5,stringSQL[4]);
            stament.setString(6,stringSQL[5]);
            stament.setString(7,stringSQL[6]);
            stament.setString(8,stringSQL[7]);
            stament.setString(9,stringSQL[8]);
            stament.setString(10,stringSQL[9]);
            stament.setString(11,stringSQL[10]);
            stament.setString(12,stringSQL[11]);
            stament.setString(13,stringSQL[12]);
            stament.setString(14,stringSQL[13]);
            stament.setString(15,stringSQL[14]);
            stament.setString(16,stringSQL[15]);
            stament.setString(17,stringSQL[16]);
            stament.setString(18,stringSQL[17]);
            stament.setString(19,stringSQL[18]);
            stament.setString(20,stringSQL[19]);
            stament.setString(21,stringSQL[20]);          
            row = stament.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Employee_ManagementDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    //Viết hàm delete
     public int EMPLOYEE_delete (String[] stringSQL){
        int row = 0;
        String delete = "DELETE FROM Employee WHERE MaNV=?";
        PreparedStatement stament;
        try {
            stament = con.prepareCall(delete);
            
            stament.setString(1,stringSQL[0]);
            
            row = stament.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Employee_ManagementDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
