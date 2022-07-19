<%-- 
    Document   : users
    Created on : Jul 14, 2022, 8:18:28 AM
    Author     : barab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manager</title>
        <link rel="stylesheet" href="mycss.css">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

    </head>
    <body>
        <div class="cont">
            <h2>New User</h2>
            <form action="user" method="post">
                <input type="email" name="new_email" placeholder="Email">
                <br>
                <input type="checkbox" name="new_active" value="true">Active
                <br>
                <input type="text" name="new_firstName" placeholder="First Name">
                <br>
                <input type="text" name="new_lastName" placeholder="Last Name">
                <br>
                <input type="password" name="new_password" placeholder="Password">
                <br>
                <select name="new_role" id="roles">
                    <option value="1">system admin</option>
                    <option value="2">regular user</option>
                    <option value="3">company admin</option>
                </select>
                <br>
                <div class="button-holder">
                    <input type="hidden" name="action" value="add">
                    <input id="btn_add" type="submit" value="Add">
                </div>                
            </form>
        </div>    

        <div class="cont">
            <h2>Users</h2>
            <table>
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Status</th>    
                </tr>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>
                            <c:forEach var="role" items="${roleList}">
                                <c:if test="${user.role == role.id}">
                                    ${role.name}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${user.active==true}">Active</c:when>
                                <c:otherwise>Inactive</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <!-- EDIT -->
                            <c:url value="/user" var="args">
                                <c:param name="action" value="edit" />
                                <c:param name="email" value="${user.email}" />
                            </c:url>
                            <a href=${args}>Edit</a>
                            &nbsp;
                            <!-- DELETE -->
                            <c:url value="/user" var="args">
                                <c:param name="action" value="delete" />
                                <c:param name="email" value="${user.email}" />
                            </c:url>
                            <a  class="a_delete" href=${args}>Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>

        <div class="cont">
            <h2>Update User Info</h2>
            <form action="user" method="post">
                <input class="tb-readonly" readonly="true" name="update_email" placeholder="Email" value="${update_email}"/>
                <br>
                <c:choose>
                    <c:when test="${update_active == true}">
                        <input type="checkbox" name="update_active" checked="checked" value="true" />
                    </c:when>
                    <c:otherwise>
                        <input type="checkbox" name="update_active" value="true" />
                    </c:otherwise>
                </c:choose>    
                Active
                <br>
                <input type="text" name="update_firstName" placeholder="First Name" value="${update_firstName}">
                <br>
                <input type="text" name="update_lastName" placeholder="Last Name" value="${update_lastName}">
                <br>
                <input type="hidden" name="update_password" placeholder="Password" value="${update_password}">
                <select name="update_role">
                    <c:forEach items="${roleList}" var="role">
                        <option value="${role.id}" ${role.id== update_role ? 'selected' : ''}>${role.name}</option>
                    </c:forEach>
                </select>
                <br>
               
                 <div class="button-holder">
                    <input type="hidden" name="action" value="edit">
                    <input id="btn_save" type="submit" value="Save">
                </div> 
            </form>
        </div>
    </body>
</html>
