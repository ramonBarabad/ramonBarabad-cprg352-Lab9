/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author barab
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
         
        List<User> userList = null;
        List<Role> roleList = null;
        
        try {
            
            userList = userService.getAll();
            roleList = roleService.getAll();
                 
            
                      
            
            
            
            request.setAttribute("userList", userList);
            request.setAttribute("roleList", roleList);
            
        } catch (Exception ex) {
            //request.setAttribute("samp", userList.size());
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
