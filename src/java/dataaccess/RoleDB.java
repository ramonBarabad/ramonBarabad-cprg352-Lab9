/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import java.util.List;
import models.Role;

/**
 *
 * @author barab
 */
public class RoleDB {

    public List<Role> getAll(String Owner) throws Exception {
        List<Role> roles = new ArrayList<>();

        //TO DO
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
