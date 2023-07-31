/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Staff;
import Model.Users;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhuta
 */
public class StaffDAO extends WHALENETDAO<Staff, String>{
    final String INSERT_SQL = "INSERT INTO Staff(manv,tennv,gioitinh,sdt,email,luong,hinh) VALUES(?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Staff set tennv = ?, gioitinh = ?, sdt = ?, email = ?, luong = ?, hinh = ? WHERE manv = ?";
    final String DELETE_SQL = "DELETE Staff WHERE manv = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Staff";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Staff WHERE manv = ?";
    @Override
    public void insert(Staff entity) {
        XJDBC.update(INSERT_SQL, entity.getManv(), entity.getTennv(), entity.isGioitinh(), entity.getSdt(), entity.getEmail(), entity.getLuong(), entity.getHinh());
    }

    @Override
    public void update(Staff entity) {
         XJDBC.update(UPDATE_SQL, entity.getTennv(), entity.isGioitinh(), entity.getSdt(), entity.getEmail(), entity.getLuong(), entity.getHinh(), entity.getManv());
    }

    @Override
    public void delete(String id) {
         XJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<Staff> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Staff selectById(String id) {
         List<Staff> list = selectBySql(SELECT_BY_ID_SQL, id);
         if(list.isEmpty()){
             return null;
         }
         return list.get(0);
    }

    @Override
    public List<Staff> selectBySql(String sql, Object... args) {
       List<Staff> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, args);
            while (rs.next()) {                
                Staff entity = new Staff();
                entity.setManv(rs.getString("manv"));
                entity.setTennv(rs.getString("tennv"));
                entity.setGioitinh(rs.getBoolean("gioitinh"));
                entity.setSdt(rs.getString("sdt"));
                entity.setEmail(rs.getString("email"));
                entity.setLuong(rs.getFloat("luong"));
                entity.setHinh(rs.getString("hinh"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
