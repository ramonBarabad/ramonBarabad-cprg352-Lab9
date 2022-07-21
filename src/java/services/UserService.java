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
import models.User;

/**
 *
 * @author barab
 */
public class UserService {

    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }

    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }

    public void insert(String email, boolean active, String firstName,
            String lastName, String password, int role) throws Exception {
        
        Role userRole = new RoleDB().get(role);
        User user = new User(email, active, firstName, lastName, password);
        user.setRole(userRole);        
        UserDB userDB = new UserDB();
        userDB.insert(user);

    }

    public void update(String email, boolean active, String firstName,
            String lastName, String password, int role) throws Exception {
        Role userRole = new RoleDB().get(role);
        User user = new User(email, active, firstName, lastName, password);
        user.setRole(userRole);
        UserDB userDB = new UserDB();
        userDB.update(user);

    }

    public void delete(String email) throws Exception {
        User user = new UserDB().get(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
