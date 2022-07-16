/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author barab
 */
public class UserDB {
 
    public List<User> getAll(String Owner) throws Exception{        
        List<User> users  = new ArrayList<>();
        
        //TO DO
        
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
