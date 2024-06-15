/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOClass;

import Entity.Sach;
import java.util.ArrayList;
import java.util.List;
import Utils.jdbcHelper;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class SachDAO extends NhaSachDAO<Sach, String> {

    String insert_sql = "INSERT INTO Sach (MaSach, TenSach, TacGia, GiaTien, NgayXuatBan, TheLoai) VALUES (?, ?, ?, ?, ?, ?)";
    String update_sql = "UPDATE Sach SET TenSach = ?, TacGia = ?, GiaTien = ?, NgayXuatBan = ?, TheLoai = ? WHERE MaSach = ?";
    String delete_sql = "DELETE FROM Sach WHERE MaSach = ?";
    String select_all_sql = "SELECT * FROM Sach";
    String select_by_id_sql = "SELECT * FROM Sach WHERE MaSach = ?";

    @Override
    public void insert(Sach entity) {
        jdbcHelper.update(insert_sql, entity.getMaSach(), entity.getTenSach(), entity.getTacGia(), entity.getGiaTien(), entity.getNgayXuatBan(), entity.getTheLoai());
    }

    @Override
    public void update(Sach entity) {
        jdbcHelper.update(update_sql, entity.getTenSach(), entity.getTacGia(), entity.getGiaTien(), entity.getNgayXuatBan(), entity.getTheLoai(), entity.getMaSach());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(delete_sql, id);
    }

    @Override
    public List<Sach> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    public Sach selectById(String id) {
        List<Sach> list = this.selectBySql(select_by_id_sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<Sach>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Sach entity = new Sach();
                entity.setMaSach(rs.getString("MaSach"));
                entity.setTenSach(rs.getString("TenSach"));
                entity.setTacGia(rs.getString("TacGia"));
                entity.setGiaTien(rs.getDouble("GiaTien"));
                entity.setNgayXuatBan(rs.getDate("NgayXuatBan"));
                entity.setTheLoai(rs.getString("TheLoai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<Sach> selectedByKeyword(String keyword){
        String sql = "select * from Sach where MaSach like ?";
        return this.selectBySql(sql, "%" +keyword+ "%");
    }
    
    public Sach selectedByKeyword1(String keyword){
        return this.selectById(keyword);
    }
}
