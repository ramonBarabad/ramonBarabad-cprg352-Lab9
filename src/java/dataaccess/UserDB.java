/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author barab
 */
public class UserDB {
 
    public List<User> getAll() throws Exception{        
        List<User> users  = new ArrayList<>();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from user";

        try {
            ps = con.prepareStatement(sql);
            //ps.setString(l)
            rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                boolean isActive = rs.getBoolean(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String password = rs.getString(5);
                int role = rs.getInt(6);
                
                User  user = new User(email, isActive, firstName, lastName, password, role);
                users.add(user);
            }
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return users;
    }
    
    
    public User get(String email)throws Exception{
        User user = null;
        
        //TO DO
        
        return user;
    }
    
    public void insert(User newUser)throws Exception{
       //TO DO
    }
    
    public void update(User newUser)throws Exception{
       //TO DO
    }
    
    
    public void delete(String email)throws Exception{
       //TO DO
    }
    
    public void delete(User user)throws Exception{
       delete(user.getEmail());
    }
    
    
}
