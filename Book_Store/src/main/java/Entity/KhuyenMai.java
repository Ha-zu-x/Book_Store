/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;
import Utils.XDate;

/**
 *
 * @author Lenovo
 */
public class KhuyenMai {

    String maSach;
    java.util.Date ngayBatDau = XDate.toDate("01/01/0001", "dd/MM/yyyy");
    java.util.Date ngayKetThuc = XDate.toDate("01/01/0001", "dd/MM/yyyy");
    int phanTramGiam;

    public KhuyenMai(String maSach, int phanTramGiam) {
        this.maSach = maSach;
        this.phanTramGiam = phanTramGiam;
    }

    public KhuyenMai() {
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }
    
    
}
