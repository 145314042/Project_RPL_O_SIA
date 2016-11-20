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
        <title>nilaisiswa</title>
    </head>
    <body>
        <h1></h1>
         <h1 style="text-align: center">INPUT NILAI SISWA</h1>
        <form action="NilaiServlet" method="post" style="text-align: left;">
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
             <table border="1" style="text-align: left;background-color: white;">
                        <tr>
                            <th>Mata Pelajaran</th>
                            <th>Nilai Tugas</th>
                            <th>Nilai Harian</th>
                            <th>Nilai UTS</th>
                            <th>Nilai UAS</th>
                        </tr>
                        <tr>
                            <th>
                                Ilmu Pengetahuan Alam
                            </th>
                            <td>
                                <input type="text" name="a1" value="">
                            </td>
                            <td>
                                <input type="text" name="a2" value="">
                            </td>
                            <td>
                                <input type="text" name="a3" value="">
                            </td>
                            <td>
                                <input type="text" name="a4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Ilmu Pengetahuan Sosial
                            </th>
                            <td>
                                <input type="text" name="b1" value="">
                            </td>
                            <td>
                                <input type="text" name="b2" value="">
                            </td>
                            <td>
                                <input type="text" name="b3" value="">
                            </td>
                            <td>
                                <input type="text" name="b4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Matematika
                            </th>
                            <td>
                                <input type="text" name="c1" value="">
                            </td>
                            <td>
                                <input type="text" name="c2" value="">
                            </td>
                            <td>
                                <input type="text" name="c3" value="">
                            </td>
                            <td>
                                <input type="text" name="c4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Agama dan Budi Pekerti
                            </th>
                            <td>
                                <input type="text" name="d1" value="">
                            </td>
                            <td>
                                <input type="text" name="d2" value="">
                            </td>
                            <td>
                                <input type="text" name="d3" value="">
                            </td>
                            <td>
                                <input type="text" name="d4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Bahasa Indonesia
                            </th>
                            <td>
                                <input type="text" name="e1" value="">
                            </td>
                            <td>
                                <input type="text" name="e2" value="">
                            </td>
                            <td>
                                <input type="text" name="e3" value="">
                            </td>
                            <td>
                                <input type="text" name="e4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Bahasa Inggris
                            </th>
                            <td>
                                <input type="text" name="f1" value="">
                            </td>
                            <td>
                                <input type="text" name="f2" value="">
                            </td>
                            <td>
                                <input type="text" name="f3" value="">
                            </td>
                            <td>
                                <input type="text" name="f4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Pancasila dan Kewarganegaraan
                            </th>
                            <td>
                                <input type="text" name="g1" value="">
                            </td>
                            <td>
                                <input type="text" name="g2" value="">
                            </td>
                            <td>
                                <input type="text" name="g3" value="">
                            </td>
                            <td>
                                <input type="text" name="g4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Pendidikan Jasmani dan Kesehatan
                            </th>
                            <td>
                                <input type="text" name="h1" value="">
                            </td>
                            <td>
                                <input type="text" name="h2" value="">
                            </td>
                            <td>
                                <input type="text" name="h3" value="">
                            </td>
                            <td>
                                <input type="text" name="h4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Prakarya
                            </th>
                            <td>
                                <input type="text" name="i1" value="">
                            </td>
                            <td>
                                <input type="text" name="i2" value="">
                            </td>
                            <td>
                                <input type="text" name="i3" value="">
                            </td>
                            <td>
                                <input type="text" name="i4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Seni Budaya
                            <td>
                                <input type="text" name="j1" value="">
                            </td>
                            <td>
                                <input type="text" name="j2" value="">
                            </td>
                            <td>
                                <input type="text" name="j3" value="">
                            </td>
                            <td>
                                <input type="text" name="j4" value="">
                            </td>
                    </table>
            <br>
            <input type="submit" value="Simpan">
        </form>
    </body>
</html>
