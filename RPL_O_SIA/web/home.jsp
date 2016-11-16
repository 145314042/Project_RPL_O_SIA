<%-- 
    Document   : home
    Created on : Nov 16, 2016, 11:09:01 AM
    Author     : Lycorice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIA</title>
    </head>
    <body>
        <h1 style="text-align: center">SIA</h1>
        <form action="LoginServlet" method="post" style="text-align: center;">
            <label>Username : </label><input type="text" name="username">
            <br>
            <label>Password : </label><input type="password" name="password">
            <br>
            <input type="submit" value="Masuk">
        </form>
    </body>
</html>
