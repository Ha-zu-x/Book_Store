/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOClass;

import Entity.Kho;
import java.util.ArrayList;
import java.util.List;
import Utils.jdbcHelper;
import java.sql.ResultSet;
/**
 *
 * @author Lenovo
 */
public class KhoDAO extends NhaSachDAO<Kho, String>{
    String insert_sql = "INSERT INTO Kho(SoLo, MaSach, SoLuong) VALUES (?, ?, ?)";
    String update_sql = "UPDATE Kho SET MaSach = ?, SoLuong = ? WHERE SoLo = ?";
    String select_all_sql = "SELECT * FROM Kho";

    @Override
    public void insert(Kho entity) {
        jdbcHelper.update(insert_sql, entity.getSoLo(), entity.getMaSach(), entity.getSoLuong());
    }

    @Override
    public void update(Kho entity) {
        jdbcHelper.update(insert_sql, entity.getMaSach(), entity.getSoLuong(), entity.getSoLo());
    }
    
    @Override
    public void delete(String id) {
    }
   
    @Override
    public List<Kho> selectAll() {
        return this.selectBySql(select_all_sql);
    }
    
    @Override
    public Kho selectById(String id) {   
        return null;
    }
    
    @Override
    protected List<Kho> selectBySql(String sql, Object... args) {
        List<Kho> list = new ArrayList<Kho>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Kho entity = new Kho();
                entity.setSoLo(rs.getString("SoLo"));
                entity.setMaSach(rs.getString("MaSach"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setNgayThem(rs.getDate("NgayThem"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<Kho> selectedByKeyword(String keyword){
        String sql = "select * from Sach where MaSach like ?";
        return this.selectBySql(sql, "%" +keyword+ "%");
    }
    
     public Kho selectedByKeyword1(String keyword){
        return this.selectById(keyword);
    }
}
