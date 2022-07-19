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

    static final String EMPTY_STRING = "";
    static final String ACTION = "action";
    static final String ACT_ADD = "add";
    static final String ACT_EDIT = "edit";
    static final String ACT_DELETE = "delete";
    static final String PAR_EMAIL = "email";

    static final String ATT_USER_LIST = "userList";
    static final String ATT_ROLE_LIST = "roleList";

    static final String VIEW_USER_EMAIL = "new_email";
    static final String VIEW_USER_ACTIVE = "new_active";
    static final String VIEW_USER_FIRSTNAME = "new_firstName";
    static final String VIEW_USER_LASTNAME = "new_lastName";
    static final String VIEW_USER_PASSWORD = "new_password";
    static final String VIEW_USER_ROLE = "new_role";

    static final String VIEW_UPDATE_EMAIL = "update_email";
    static final String VIEW_UPDATE_ACTIVE = "update_active";
    static final String VIEW_UPDATE_FIRSTNAME = "update_firstName";
    static final String VIEW_UPDATE_LASTNAME = "update_lastName";
    static final String VIEW_UPDATE_PASSWORD = "update_password";
    static final String VIEW_UPDATE_ROLE = "update_role";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = new UserService();
        RoleService roleService = new RoleService();

        List<User> userList = null;
        List<Role> roleList = null;

        try {

            String action = request.getParameter(ACTION);

            if (action != null) {
                if (action.equals(ACT_EDIT)) {
                    String email = request.getParameter(PAR_EMAIL);
                    User user = userService.get(email);
                    request.setAttribute(VIEW_UPDATE_EMAIL, user.getEmail());
                    request.setAttribute(VIEW_UPDATE_ACTIVE, user.getActive());
                    request.setAttribute(VIEW_UPDATE_FIRSTNAME, user.getFirstName());
                    request.setAttribute(VIEW_UPDATE_LASTNAME, user.getLastName());
                    request.setAttribute(VIEW_UPDATE_PASSWORD, user.getPassword());
                    request.setAttribute(VIEW_UPDATE_ROLE, user.getRole());
                } else if (action.equals(ACT_DELETE)) {
                    String email = request.getParameter(PAR_EMAIL);
                    userService.delete(email);                    
                }
            }

            userList = userService.getAll();
            roleList = roleService.getAll();
            request.setAttribute(ATT_USER_LIST, userList);
            request.setAttribute(ATT_ROLE_LIST, roleList);

        } catch (Exception ex) {
            //request.setAttribute("samp", userList.size());
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = new UserService();
        RoleService roleService = new RoleService();

        List<User> userList = null;
        List<Role> roleList = null;

        try {

            String action = request.getParameter(ACTION);

            if (action.equals(ACT_ADD)) {
                if (request.getParameter(VIEW_USER_EMAIL) != null
                        && !request.getParameter(VIEW_USER_EMAIL).equals(EMPTY_STRING)) {
                    String email = request.getParameter(VIEW_USER_EMAIL);
                    boolean active = Boolean.parseBoolean(request.getParameter(VIEW_USER_ACTIVE));
                    String firstName = request.getParameter(VIEW_USER_FIRSTNAME);
                    String lastName = request.getParameter(VIEW_USER_LASTNAME);
                    String password = request.getParameter(VIEW_USER_PASSWORD);
                    int roleId = Integer.parseInt(request.getParameter(VIEW_USER_ROLE));

                    userService.insert(email, active, firstName, lastName, password, roleId);

                }
            } else if (action.equals(ACT_EDIT)) {
                String email = request.getParameter(VIEW_UPDATE_EMAIL);
                boolean active = Boolean.parseBoolean(request.getParameter(VIEW_UPDATE_ACTIVE));
                String firstName = request.getParameter(VIEW_UPDATE_FIRSTNAME);
                String lastName = request.getParameter(VIEW_UPDATE_LASTNAME);
                String password = request.getParameter(VIEW_UPDATE_PASSWORD);
                int roleId = Integer.parseInt(request.getParameter(VIEW_UPDATE_ROLE));

                userService.update(email, active, firstName, lastName, password, roleId);
            }

            userList = userService.getAll();
            roleList = roleService.getAll();
            request.setAttribute(ATT_USER_LIST, userList);
            request.setAttribute(ATT_ROLE_LIST, roleList);

        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}
