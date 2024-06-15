/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOClass;

import Utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ThongKeDAO {
     public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    public List<Object[]> getDoanhThuSach() {
        String sql = "{CALL ThongKeDoanhThuSach}";
        String[] cols = {"MaSach", "GiaTien", "SoLuongBanRa", "TongDoanhThu"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDoanhThuThang() {
        String sql = "{CALL ThongKeDoanhThuThang}";
        String[] cols = {"Thang", "Nam", "TongDoanhThu"};
        return this.getListOfArray(sql, cols);
    }
}
