<%-- 
    Document   : guru
    Created on : Nov 17, 2016, 9:06:43 PM
    Author     : Lycorice
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guru</title>
    </head>
    <body>
        <h1 style="text-align: center">Menu Guru</h1>
        <form action="" style="text-align: center">
            <%JOptionPane.showMessageDialog(null, request.getAttribute("username"));%>
            <input type="">
        </form>
    </body>
</html>
