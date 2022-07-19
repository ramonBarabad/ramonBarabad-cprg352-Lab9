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

/**
 *
 * @author barab
 */
public class RoleDB {

    public List<Role> getAll() throws Exception {
        List<Role> roles = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from role";

        try {
            ps = con.prepareStatement(sql);
            //ps.setString(l)
            rs = ps.executeQuery();
            while (rs.next()) {
                int roleID = rs.getInt(1);
                String roleName = rs.getString(2);
                Role role = new Role(roleID, roleName);
                roles.add(role);
            }
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return roles;
    }

    public Role get(int id) throws Exception {
        Role role = null;

        //TO DO
        return role;
    }

    public void insert(Role newRole) throws Exception {
        //TO DO
    }

    public void update(Role role) throws Exception {
        //TO DO
    }

    public void delete(int roleId) throws Exception {
        //TO DO
    }

    public void delete(Role role) throws Exception {
        delete(role.getId());
    }
}
