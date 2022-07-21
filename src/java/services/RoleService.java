/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.List;
import models.Role;

/**
 *
 * @author barab
 */
public class RoleService {
    public Role get(int id) throws Exception {
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(id);
        return role;
    }

    public List<Role> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll();
        return roles;
    }

    public void insert(int id, String name) throws Exception {
        Role role = new Role(id, name);
        RoleDB roleDB = new RoleDB();
        roleDB.insert(role);

    }

    public void update(int id, String name) throws Exception {
        Role role = new Role(id, name);
        RoleDB roleDB = new RoleDB();
        roleDB.update(role);

    }

    public void delete(int id) throws Exception {
        Role role = new Role();
        role.setRoleId(id);
        RoleDB roleDB = new RoleDB();
        roleDB.delete(id);
    }
}
