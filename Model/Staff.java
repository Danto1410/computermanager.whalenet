/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nhuta
 */
public class Staff {
    private String manv;
    private String tennv;
    private boolean gioitinh;
    private String sdt;
    private String email;
    private float luong;
    private String hinh;

    public Staff() {
    }

    public Staff(String manv, String tennv, boolean gioitinh, String sdt, String email, float luong, String hinh) {
        this.manv = manv;
        this.tennv = tennv;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.email = email;
        this.luong = luong;
        this.hinh = hinh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
