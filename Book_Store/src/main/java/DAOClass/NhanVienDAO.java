/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOClass;
    
import Entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import Utils.jdbcHelper;
import java.sql.ResultSet;
/**
 *
 * @author Lenovo
 */
public class NhanVienDAO extends NhaSachDAO<NhanVien, String>{
    String insert_sql = "INSERT INTO NhanVien (MaNV, HoTen, GioiTinh, Sdt, DiaChi, Email, VaiTro, MatKhau) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String update_sql = "UPDATE NhanVien SET HoTen = ?, GioiTinh = ?, Sdt = ?, DiaChi = ?, Email = ?, VaiTro = ?, MatKhau = ?, Anh = ? WHERE MaNV = ?";
    String setting_update_sql = "UPDATE NhanVien SET Sdt = ?, DiaChi = ?, Email = ?, Anh = ? WHERE MaNV = ?";
    String delete_sql = "DELETE FROM NhanVien WHERE MaNV = ?";
    String select_all_sql = "SELECT * FROM NhanVien";
    String select_by_id_sql = "SELECT * FROM NhanVien WHERE MaNV = ?";

    @Override
    public void insert(NhanVien entity) {
        jdbcHelper.update(insert_sql, entity.getMaNV(), entity.getHoTen(), entity.isGioiTinh(), entity.getSdt(), entity.getDiaChi(), entity.getEmail(), entity.isVaiTro(), entity.getMatKhau());
    }

    @Override
    public void update(NhanVien entity) {
        jdbcHelper.update(update_sql, entity.getHoTen(), entity.isGioiTinh(), entity.getSdt(), entity.getDiaChi(), entity.getEmail(), entity.isVaiTro(), entity.getMatKhau(), entity.getAnh(), entity.getMaNV());
    }
    
   
    public void setting(NhanVien entity) {
        jdbcHelper.update(setting_update_sql, entity.getSdt(), entity.getDiaChi(), entity.getEmail(), entity.getAnh(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(delete_sql, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(select_by_id_sql, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setSdt(rs.getString("Sdt"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setEmail(rs.getString("Email"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setAnh(rs.getString("Anh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
