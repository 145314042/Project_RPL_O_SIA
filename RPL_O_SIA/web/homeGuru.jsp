<%-- 
    Document   : guru
    Created on : Nov 17, 2016, 9:06:43 PM
    Author     : Lycorice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guru</title>
        <script type="text/javascript">
            <% if ("1".equals(request.getParameter("success"))) {%>
            alert("Data berhasil dimasukkan!");
            <%}%>
        </script>
    </head>
    <body>
        <h1 style="text-align: center">Menu Guru</h1>
        <form action="nilaiSiswa.jsp" style="text-align: center">
            <input type="submit" value="Nilai Siswa">
        </form>
        <br>
        <form action="home.jsp" style="text-align: center">
            <input type="submit" value="Keluar">
        </form>
        
    </body>
</html>
