/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOClass;

import Entity.KhuyenMai;
import Utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class KhuyenMaiDAO extends NhaSachDAO<KhuyenMai, String> {

    String insert_sql = "INSERT INTO KhuyenMai (MaSach, NgayKetThuc, PhanTramGiam) VALUES (?, ?, ?)";
    String select_by_id_sql = "SELECT * FROM KhuyenMai WHERE MaSach = ?";
    String select_by_date = "SELECT * FROM KhuyenMai WHERE NgayKetThuc <= CURDATE() and  MaSach = ?";

    @Override
    public void insert(KhuyenMai entity) {
        jdbcHelper.update(insert_sql, entity.getMaSach(), entity.getNgayKetThuc(), entity.getPhanTramGiam());
    }

    @Override
    public void update(KhuyenMai entity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<KhuyenMai> selectAll() {

        return null;

    }

    @Override
    public KhuyenMai selectById(String id) {
        List<KhuyenMai> list = this.selectBySql(select_by_id_sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public KhuyenMai selectById_Date(String id) {
        List<KhuyenMai> list = this.selectBySql(select_by_date, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<KhuyenMai>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhuyenMai entity = new KhuyenMai();
                entity.setMaSach(rs.getString("MaSach"));
                entity.setNgayBatDau(rs.getDate("NgayBatDau"));
                entity.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                entity.setPhanTramGiam(rs.getInt("PhanTramGiam"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhuyenMai> selectedByKeyword(String keyword) {
        String sql = "select * from KhuyenMai where MaSach like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public KhuyenMai selectedByKeyword1(String keyword) {
        return this.selectById(keyword);
    }
}
