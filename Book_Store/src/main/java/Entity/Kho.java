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
public class Kho {
    String soLo;
    String maSach;
    int soLuong;
    java.util.Date ngayThem  = XDate.toDate("01/01/0001", "dd/MM/yyyy");

    public Kho(String soLo, String maSach, int soLuong) {
        this.soLo = soLo;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public Kho() {
    }

    public String getSoLo() {
        return soLo;
    }

    public void setSoLo(String soLo) {
        this.soLo = soLo;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }
    
    
}
