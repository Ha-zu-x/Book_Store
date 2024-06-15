/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tam
 */
public class TestJdbcHelper {

    public static void main(String[] args) throws SQLException {
        String sql3 = "select * from NhanVien";
        ResultSet rs = jdbcHelper.query(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("MaNV"));
            System.out.println(rs.getString("HoTen"));
            System.out.println(rs.getString("GioiTinh"));
            System.out.println(rs.getString("Sdt"));
            System.out.println(rs.getString("DiaChi"));
            System.out.println(rs.getString("Email"));
            System.out.println(rs.getString("VaiTro"));
            System.out.println(rs.getString("MatKhau"));
        }
    }
}
