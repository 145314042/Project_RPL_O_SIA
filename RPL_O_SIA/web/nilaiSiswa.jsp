<%-- 
    Document   : nilaiSiswa
    Created on : Nov 18, 2016, 2:47:19 PM
    Author     : Lycorice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nilai Siswa</title>
        <script type="text/javascript">
            <% if ("1".equals(request.getParameter("error"))) {%>
            alert("Data anda masukkan salah!");
            <%}%>
            <% if ("2".equals(request.getParameter("error"))) {%>
            alert("NIS tidak ditemukan!");
            <%}%>
            <% if ("3".equals(request.getParameter("error"))) {%>
            alert("Data sudah ada!");
            <%}%>
            <% if ("4".equals(request.getParameter("error"))) {%>
            alert("Data nilai salah!");
            <%}%>

        </script>
    </head>
    <body>
        <h1></h1>
        <h1 style="text-align: center">INPUT NILAI SISWA</h1>
        <form action="NilaiServlet" method="POST" style="text-align: left;">
            <table style="text-align: left; ">
                <tr>
                    <th>
                        NIS
                    </th>
                    <td>
                        : 
                    </td>
                    <td> 
                        <input type="text" name="nis">
                    </td>
                </tr>
                <tr>
                    <th>
                        Tahun Ajaran
                    </th>
                    <td>
                        : 
                    </td>
                    <td> 
                        <input type="text" name="tahun_ajaran">
                    </td>
                </tr>
                <tr>
                    <th>
                        Kelas
                    </th>
                    <td>
                        : 
                    </td>
                    <td> 
                        <input type="text" name="kelas">
                    </td>
                </tr>
                <tr>
                    <th>
                        Semester
                    </th>
                    <td>
                        : 
                    </td>
                    <td>
                        <select name="semester">
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                    </td>
                </tr>
            </table>

            <br>
            NILAI
            <%
                String[] daftarMataPelajaran = {
                    "Ilmu Pengetahuan Alam", "Ilmu Pengetahuan Sosial",
                    "Matematika", "Agama dan Budi Pekerti",
                    "Bahasa Indonesia", "Bahasa Inggris",
                    "Pancasila & Kewarganegaraan", "Pendidikan Jasmani & Kesehatan",
                    "Prakarya", "Seni Budaya"
                };
                String[] kode = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            %>
            <table border="1" style="text-align: left;">
                <tr>
                    <th>Mata Pelajaran</th>
                    <th>Nilai Tugas</th>
                    <th>Nilai Harian</th>
                    <th>Nilai UTS</th>
                    <th>Nilai UAS</th>
                </tr>
                <%
                    for (int i = 0; i < daftarMataPelajaran.length; i++) {
                %>
                <tr>
                    <th><%=daftarMataPelajaran[i]%></th>
                    <td><input type="text" name="<%out.print(kode[i] + "0");%>"></td>
                    <td><input type="text" name="<%out.print(kode[i] + "1");%>"></td>
                    <td><input type="text" name="<%out.print(kode[i] + "2");%>"></td>
                    <td><input type="text" name="<%out.print(kode[i] + "3");%>"></td>
                </tr>
                <input type="hidden" name="<%out.print("kode" + i);%>" value="<%out.print(kode[i]);%>">
                <%}
                %>
            </table>
            <br>
            <input type="submit" value="Simpan">
        </form>
        <form action="homeGuru.jsp">
            <input type="submit" value="kembali">
        </form>
    </body>
</html>
