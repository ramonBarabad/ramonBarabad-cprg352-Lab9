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
    </head>
    <body>
        <h1>User Manager</h1>
        
        <div>
            <h2>Users</h2>
            <table>
                <tr>
                    <th>${samp}</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Active</th>    
                <tr/>
                <c:forEach var="users" items="${userList}">
                    <tr>
                        <td>${users.email}</td>
                        <td>${users.firstName}</td>
                        <td>${users.lastName}</td>
                        <td></td>
                        <td></td>
                    </tr>
                </c:forEach>
                
            </table>
        </div>
            
    </body>
</html>
