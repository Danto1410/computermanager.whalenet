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
public class Users {
    private String taikhoan;
    private String matkhau;
    private Boolean vaitro;

    public Users() {
    }

    public Users(String taikhoan, String matkhau, Boolean vaitro) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Boolean getVaitro() {
        return vaitro;
    }

    public void setVaitro(Boolean vaitro) {
        this.vaitro = vaitro;
    }


}
