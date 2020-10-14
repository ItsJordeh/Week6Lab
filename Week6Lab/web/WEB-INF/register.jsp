<%-- 
    Document   : register
    Created on : 14-Oct-2020, 12:22:30 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        ${thing}
        <form method="post" action="ShoppingList">
            <b>Username: </b> 
            <input type="text" name="username" >
            <input type="hidden" name="action" value="register"><br>
            <input type ="submit" value ="Register name">
        </form>
        ${error}
    </body>
</html>
