<%-- 
    Document   : TampilRekap
    Created on : Nov 24, 2016, 4:06:42 PM
    Author     : Lycorice
--%>

<%@page import="Model.Data_Nilai"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="ConnectionDataBase.DatabaseConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String nis = request.getParameter("nis");
    String nama = null;
    Connection conn = new DatabaseConnection().getConnection();
    PreparedStatement pStatement = conn.prepareStatement(""
            + "select nama from siswa where nis=\'" + nis + "\'");
    ResultSet rSet = pStatement.executeQuery();
    while (rSet.next()) {
        nama = rSet.getString("nama");
    }
    String[] daftarMataPelajaran = {
        "Ilmu Pengetahuan Alam", "Ilmu Pengetahuan Sosial",
        "Matematika", "Agama dan Budi Pekerti",
        "Bahasa Indonesia", "Bahasa Inggris",
        "Pancasila & Kewarganegaraan", "Pendidikan Jasmani & Kesehatan",
        "Prakarya", "Seni Budaya"
    };
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <h1>Rekap Nilai</h1>
            NIS  : <%=nis%>
            <br>
            Nama : <%=nama%>
            <br>
            <br>
            <!--tampil tabel-->
            <%Data_Nilai data_Nilai = new Data_Nilai();
            data_Nilai.GetNilai(nis);
            for (int i = 0; i < (data_Nilai.Size(nis) / 10); i++) {
                String[] temp = data_Nilai.data[0 + (i * 10)].getKode_mata_pelajaran().split("");
                String kelas = null;
//                JOptionPane.showMessageDialog(null, temp[0]);
                if (temp[0].equals("A")) {
                    kelas = "7";
                } else if (temp[0].equals("B")) {
                    kelas = "8";
                } else {
                    kelas = "9";
                }%>
                Tahun Ajaran : <%=data_Nilai.data[0 + (i * 10)].getTahun_ajaran()%>
                <br>
                Kelas : <%=kelas%>
                <br>
                Semester : <%=data_Nilai.data[0 + (i * 10)].getSemester()%>
                <br>

                <table border="1">
                <tr>
                <th>Mata Pelajaran</th>

                <th>Nilai Tugas</th>
                <th>Nilai Harian</th>
                <th>Nilai UTS</th>
                <th>Nilai UAS</th>
                <th>Nilai Semester</th>
                </tr>
                <%for (int j = (0 + (i * 10)); j < (10 * (i + 1)); j++) {
                    String mapel = null;
                    String[] kode = data_Nilai.data[j].getKode_mata_pelajaran().split("");
                    if ("0".equals(kode[1])) {
                        mapel = daftarMataPelajaran[0];
                    }
                    if ("1".equals(kode[1])) {
                        mapel = daftarMataPelajaran[1];
                    }
                    if ("2".equals(kode[1])) {
                        mapel = daftarMataPelajaran[2];
                    }
                    if ("3".equals(kode[1])) {
                        mapel = daftarMataPelajaran[3];
                    }
                    if ("4".equals(kode[1])) {
                        mapel = daftarMataPelajaran[4];
                    }
                    if ("5".equals(kode[1])) {
                        mapel = daftarMataPelajaran[5];
                    }
                    if ("6".equals(kode[1])) {
                        mapel = daftarMataPelajaran[6];
                    }
                    if ("7".equals(kode[1])) {
                        mapel = daftarMataPelajaran[7];
                    }
                    if ("8".equals(kode[1])) {
                        mapel = daftarMataPelajaran[8];
                    }
                    if ("9".equals(kode[1])) {
                        mapel = daftarMataPelajaran[9];
                    }

                    out.println("<tr>");
                    out.println("<th>" + mapel + "</th>");
                    out.println("<td>" + data_Nilai.data[j].getNilai_tugas() + "</td>");
                    out.println("<td>" + data_Nilai.data[j].getNilai_harian() + "</td>");
                    out.println("<td>" + data_Nilai.data[j].getNilai_uts() + "</td>");
                    out.println("<td>" + data_Nilai.data[j].getNilai_uas() + "</td>");
                    out.println("<td>" + data_Nilai.data[j].getNilai_semester() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }%>
            <form action ="homeSiswa.jsp" method="post">
            <input type="hidden" name="nis" value="<%+nis%>">
            <input type="submit" value="Home\">
            
            </form>
            </body>
</html>
