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
public class FoodAndDrink {
    private String id;
    private String tensp;
    private float gia;
    private int soluongcon;
    private String hinh;

    public FoodAndDrink() {
    }

    public FoodAndDrink(String id, String tensp, float gia, int soluongcon, String hinh) {
        this.id = id;
        this.tensp = tensp;
        this.gia = gia;
        this.soluongcon = soluongcon;
        this.hinh = hinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoluongcon() {
        return soluongcon;
    }

    public void setSoluongcon(int soluongcon) {
        this.soluongcon = soluongcon;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
}
