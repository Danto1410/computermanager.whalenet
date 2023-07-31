/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Users;
import Utils.XJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nhuta
 */
public class UserDAO extends WHALENETDAO<Users, String>{
    final String INSERT_SQL = "INSERT INTO Users(taikhoan,matkhau,vaitro) VALUES(?,?,?)";
    final String UPDATE_SQL = "UPDATE Users set matkhau = ?, vaitro = ? WHERE taikhoan = ?";
    final String DELETE_SQL = "DELETE Users WHERE taikhoan = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Users";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Users WHERE taikhoan = ?";
    @Override
    public void insert(Users entity) {
        XJDBC.update(INSERT_SQL, entity.getTaikhoan(), entity.getMatkhau(), entity.getVaitro());
    }

    @Override
    public void update(Users entity) {
        XJDBC.update(UPDATE_SQL, entity.getMatkhau(), entity.getVaitro(), entity.getTaikhoan());
    }

    @Override
    public void delete(String id) {
       XJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<Users> selectAll() {
         return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Users selectById(String id) {
        List<Users> list = selectBySql(SELECT_BY_ID_SQL, id);
         if(list.isEmpty()){
             return null;
         }
         return list.get(0);
    }

    @Override
    public List<Users> selectBySql(String sql, Object... args) {
        List<Users> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, args);
            while (rs.next()) {                
                Users entity = new Users();
                entity.setTaikhoan(rs.getString("taikhoan"));
                entity.setMatkhau(rs.getString("matkhau"));
                entity.setVaitro(rs.getBoolean("vaitro"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
