<%-- 
    Document   : shoppinglist
    Created on : Feb 13, 2020, 1:41:26 PM
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} <a href="ShoppingList?logout=true">Logout</a>
        
        <h2>List</h2>
        <form action="ShoppingList?addOrDelete=true" METHOD="POST">
            Add Item: <input type="text" name="toAdd"><input type="submit" value="add">
        </form>
    
        <form action="ShoppingList?addOrDelete=false" METHOD="POST">
            <c:forEach var="item" items="${items}">
                ${item}<input type="radio" name="anItem" value="${item}">
                <br>
            </c:forEach>
                <input type="submit" value="Delete">
        </form>
    
    </body>
</html>
