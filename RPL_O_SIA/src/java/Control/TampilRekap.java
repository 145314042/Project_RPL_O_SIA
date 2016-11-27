/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ConnectionDataBase.DatabaseConnection;
import Model.Data_Nilai;
import Model.Kelas;
import Model.Siswa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Lycorice
 */
public class TampilRekap extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String nis = request.getParameter("nis");
            String nama = new Siswa().getNamaSiswa(nis);
            
            String[] daftarMataPelajaran = {
                "Ilmu Pengetahuan Alam", "Ilmu Pengetahuan Sosial",
                "Matematika", "Agama dan Budi Pekerti",
                "Bahasa Indonesia", "Bahasa Inggris",
                "Pancasila & Kewarganegaraan", "Pendidikan Jasmani & Kesehatan",
                "Prakarya", "Seni Budaya"
            };
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tampil Rekap</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Rekap Nilai</h1>");
            out.println("NIS  : " + nis);
            out.println("<br>");
            out.println("Nama : " + nama);
            out.println("<form action=\"homeSiswa.jsp\" method=\"POST\">\n"
                    + "<input type=\"hidden\" name=\"nis\" value=\"" + nis + "\">\n"
                    + "<input type=\"submit\" value=\"Kembali\">\n"
                    + "</form>");
            out.println("<br>");
            out.println("<br>");
            //tampil tabel
            Data_Nilai data_Nilai = new Data_Nilai();
            data_Nilai.GetNilai(nis);

            for (int i = 0; i < (data_Nilai.Size(nis) / 10); i++) {
                String[] temp = data_Nilai.data[0 + (i * 10)].getKode_mata_pelajaran().split("");
                String kelas = null;

                if (temp[0].equals("A")) {
                    kelas = "7";
                } else if (temp[0].equals("B")) {
                    kelas = "8";
                } else {
                    kelas = "9";
                }
                out.println("Tahun Ajaran : " + data_Nilai.data[0 + (i * 10)].getTahun_ajaran());
                out.println("<br>");
                out.println("Kelas : " + kelas);
                out.println("<br>");
                out.println("Semester : " + data_Nilai.data[0 + (i * 10)].getSemester());
                out.println("<br>");

                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Mata Pelajaran</th>");

                out.println("<th>Nilai Tugas</th>");
                out.println("<th>Nilai Harian</th>");
                out.println("<th>Nilai UTS</th>");
                out.println("<th>Nilai UAS</th>");
                out.println("<th>Nilai Semester</th>");
                out.println("</tr>");
                for (int j = (0 + (i * 10)); j < (10 * (i + 1)); j++) {
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
            }
            
            System.out.println("");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TampilRekap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TampilRekap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
