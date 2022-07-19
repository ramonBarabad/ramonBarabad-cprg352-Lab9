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
                            <a href=${args}>Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                
            </table>
        </div>
            
    </body>
</html>
