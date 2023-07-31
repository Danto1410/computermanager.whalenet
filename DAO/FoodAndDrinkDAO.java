/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.FoodAndDrink;
import Model.Users;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author nhuta
 */
public class FoodAndDrinkDAO extends WHALENETDAO<FoodAndDrink, String>{
    final String INSERT_SQL = "INSERT INTO FoodAndDrink(id,tensp,gia,soluongcon,hinh) VALUES(?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE FoodAndDrink SET tensp = ?, gia = ?, soluongcon = ?, hinh = ? WHERE id = ?";
    final String DELETE_SQL = "DELETE FoodAndDrink WHERE id = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM FoodAndDrink";
    final String SELECT_BY_ID_SQL = "SELECT * FROM FoodAndDrink WHERE id = ?";
    @Override
    public void insert(FoodAndDrink entity) {
        XJDBC.update(INSERT_SQL, entity.getId(), entity.getTensp(), entity.getGia(), entity.getSoluongcon(), entity.getHinh());
    }

    @Override
    public void update(FoodAndDrink entity) {
        XJDBC.update(UPDATE_SQL, entity.getTensp(), entity.getGia(), entity.getSoluongcon(), entity.getHinh(), entity.getId());
    }

    @Override
    public void delete(String id) {
        XJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<FoodAndDrink> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public FoodAndDrink selectById(String id) {
       List<FoodAndDrink> list = selectBySql(SELECT_BY_ID_SQL, id);
         if(list.isEmpty()){
             return null;
         }
         return list.get(0);
    }

    @Override
    public List<FoodAndDrink> selectBySql(String sql, Object... args) {
         List<FoodAndDrink> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, args);
            while (rs.next()) {                
                FoodAndDrink entity = new FoodAndDrink();
                entity.setId(rs.getString("id"));
                entity.setTensp(rs.getString("tensp"));
                entity.setGia(rs.getFloat("gia"));
                entity.setSoluongcon(rs.getInt("soluongcon"));
                entity.setHinh(rs.getString("hinh"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    

}
