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
public class HoaDon {
    int maHD;
    String maNV;
    java.util.Date  ngayXuat  = XDate.toDate("01/01/0001", "dd/MM/yyyy");
    double tongGiaTri;

    public HoaDon(int maHD, String maNV, double tongGiaTri) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.tongGiaTri = tongGiaTri;
    }

    public HoaDon() {
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public double getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(double tongGiaTri) {
        this.tongGiaTri = tongGiaTri;
    }
    
    
}
