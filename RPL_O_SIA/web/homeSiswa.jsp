<%-- 
    Document   : siswa
    Created on : Nov 17, 2016, 9:07:06 PM
    Author     : Lycorice
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String nis = "";
            if (request.getParameter("nis") != null) {
                nis = request.getParameter("nis");
            } else {
                Cookie cookie[] = request.getCookies();
                nis = cookie[1].getValue();
            }
        %>
        <title>Menu Siswa</title>
    </head>
    <body>
        <h1>Selamat datang <%=nis%></h1>
        <form action="TampilRekapServlet">
            <!--<form action="TampilRekap.jsp">-->
            <input type="hidden" name="nis" value="<%=nis%>">
            <input type="submit" value="Tampil Rekap Nilai">
        </form>
        <form action="home.jsp">
            <%
                Cookie ck = new Cookie("nis", "");
                ck.setMaxAge(0);
                response.addCookie(ck);
            %>
            <input type="submit" value="Keluar">
        </form>
    </body>
</html>
