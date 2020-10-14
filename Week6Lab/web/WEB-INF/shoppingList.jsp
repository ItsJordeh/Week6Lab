<%-- 
    Document   : shoppingList
    Created on : 14-Oct-2020, 12:22:49 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <h2>Welcome ${username}!</h2>
        
        <form action="ShoppingList" method="post">
            <h3> Add item to list</h3>
            <input type="text" name ="item">
            <input type="hidden" name ="action" value="add">
            <input type="submit" name="action" value="Add item">
        </form>
        ${error}
        <br><br>
        <form action="ShoppingList" method="post">
            <table>
                <c:forEach var="item" items ="${itemsList}">
                    
                       
                    <input type="radio" name ="radioList" value ="${item}" > ${item}<br>
                        
                        
                    </tr>
                </c:forEach> 
            </table>
            
            <input type="hidden" name ="action" value="delete"><br><br>
            <input type="submit" value="Delete item">
        </form>

        <br>
        <form action="ShoppingList" method="post">
            <input type="hidden" name ="action" value="logout">
            <input type="submit" value="Log out">
            
            
        </form>
        
    </body>
</html>
