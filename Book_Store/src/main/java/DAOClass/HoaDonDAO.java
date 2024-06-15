/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOClass;

import Entity.HoaDon;
import Utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class HoaDonDAO extends NhaSachDAO<HoaDon, String>{
    String insert_sql = "INSERT INTO HoaDon(MaHD, MaNV, TongGiaTri) VALUES (?, ?, ?)";
    String select_all_sql = "SELECT * FROM HoaDon";
    
    @Override
    public void insert(HoaDon entity) {
        jdbcHelper.update(insert_sql, entity.getMaHD(), entity.getMaNV(), entity.getNgayXuat(), entity.getTongGiaTri());
    }

    @Override
    public void update(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(select_all_sql);    }

    @Override
    public HoaDon selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
                try {
                    ResultSet rs = jdbcHelper.query(sql, args);
                    while (rs.next()) {
                        HoaDon entity = new HoaDon();
                        entity.setMaHD(rs.getInt("MaHD"));
                        entity.setMaNV(rs.getString("MaNV"));
                        entity.setNgayXuat(rs.getDate("NgayXuat"));
                        entity.setTongGiaTri(rs.getDouble("TongGiaTri"));
                        list.add(entity);
                    }
                    rs.getStatement().getConnection().close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return list;    
    }
    public List<HoaDon> selectedByKeyword(String keyword){
         int keyword1 = Integer.parseInt(keyword);
        String sql = "SELECT * FROM HoaDon WHERE MaHD = ?";
        return this.selectBySql(sql,keyword1);
    }
    
}
