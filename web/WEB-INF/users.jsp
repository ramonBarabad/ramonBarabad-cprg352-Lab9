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
            <h2>User</h2>
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
                                <c:when test="${user.active}">
                                    <c:set var="Yes" value="true" />Active
                                </c:when>
                                <c:otherwise>
                                    <c:set var="No" value="false" />Inactive  
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                
            </table>
        </div>
            
    </body>
</html>
