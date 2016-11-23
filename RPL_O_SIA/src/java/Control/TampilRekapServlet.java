/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ConnectionDataBase.DatabaseConnection;
import Model.Data_Nilai;
import Model.Kelas;
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
public class TampilRekapServlet extends HttpServlet {
    int size = 0;
    Data_Nilai[] data;

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
            String nama = null;
            Connection conn = new DatabaseConnection().getConnection();
            PreparedStatement pStatement = conn.prepareStatement(""
                    + "select nama from siswa where nis=\'"+nis+"\'");
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()){
                nama = rSet.getString("nama");
            }
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
            out.println("NIS  : "+nis);
            out.println("<br>");
            out.println("Nama : "+nama);
            out.println("<br>");
            out.println("<br>");
            //tampil tabel
            GetNilai(nis);
//            JOptionPane.showMessageDialog(null, size);
            for (int i = 0; i < (size/10); i++) {
                String[] temp = data[0+(i*10)].getKode_mata_pelajaran().split("");
                String kelas=null;
//                JOptionPane.showMessageDialog(null, temp[0]);
                if (temp[0].equals("A"))kelas="7";
                else if (temp[0].equals("B"))kelas="8";
                else kelas="9";
                out.println("Tahun Ajaran : "+data[0+(i*10)].getTahun_ajaran());
                out.println("<br>");
                out.println("Kelas : "+kelas);
                out.println("<br>");
                out.println("Semester : "+data[0+(i*10)].getSemester());
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
                for (int j = (0+(i*10)); j < (10*(i+1)); j++) {
                    String mapel=null;
                    String[] kode=data[j].getKode_mata_pelajaran().split("");
                    if ("0".equals(kode[1])) mapel=daftarMataPelajaran[0];
                    if ("1".equals(kode[1])) mapel=daftarMataPelajaran[1];
                    if ("2".equals(kode[1])) mapel=daftarMataPelajaran[2];
                    if ("3".equals(kode[1])) mapel=daftarMataPelajaran[3];
                    if ("4".equals(kode[1])) mapel=daftarMataPelajaran[4];
                    if ("5".equals(kode[1])) mapel=daftarMataPelajaran[5];
                    if ("6".equals(kode[1])) mapel=daftarMataPelajaran[6];
                    if ("7".equals(kode[1])) mapel=daftarMataPelajaran[7];
                    if ("8".equals(kode[1])) mapel=daftarMataPelajaran[8];
                    if ("9".equals(kode[1])) mapel=daftarMataPelajaran[9];

                    out.println("<tr>");
                    out.println("<th>"+mapel+"</th>");
                    out.println("<td>"+data[j].getNilai_tugas()+"</td>");
                    out.println("<td>"+data[j].getNilai_harian()+"</td>");
                    out.println("<td>"+data[j].getNilai_uts()+"</td>");
                    out.println("<td>"+data[j].getNilai_uas()+"</td>");
                    out.println("<td>"+data[j].getNilai_semester()+"</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
            out.println("<form action =\"homeSiswa.jsp\" method=\"post\">");
            out.println("<input type=\"hidden\" name=\"nis\" value=\""+nis+"\">");
            out.println("<input type=\"submit\" value=\"Home\">");
            out.println("</form>");
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
            Logger.getLogger(TampilRekapServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TampilRekapServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public int Size(String nis) throws SQLException{
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(""
                + "select nis from data_nilai where nis=\'"+nis+"\'");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            size++;
        }
//        size = resultSet.getFetchSize();
        return size;
    }
    
    public void GetNilai (String nis) throws SQLException{
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from data_nilai where nis=\'"+nis+"\' "
                + "order by tahun_ajaran, semester, kode_mata_pelajaran"
                + "");
        ResultSet resultSet = statement.executeQuery();
        data = new Data_Nilai[Size(nis)];
        System.out.println(data.length);
        int i = 0;
        while (resultSet.next()) {
            data[i] = new Data_Nilai();
            data[i].setNis(nis);
            data[i].setSemester(resultSet.getInt("semester"));
            data[i].setTahun_ajaran(resultSet.getInt("tahun_ajaran"));
            data[i].setKode_mata_pelajaran(resultSet.getString("kode_mata_pelajaran"));
            data[i].setNilai_tugas(resultSet.getDouble("nilai_tugas"));
            data[i].setNilai_harian(resultSet.getDouble("nilai_harian"));
            data[i].setNilai_uts(resultSet.getDouble("nilai_uts"));
            data[i].setNilai_uas(resultSet.getDouble("nilai_uas"));
            data[i].setNilai_semester(resultSet.getDouble("nilai_semester"));
            data[i].setNilai_akhir(resultSet.getDouble("nilai_akhir"));
//            System.out.println(data[i].getKode_mata_pelajaran());
            i++;
        }
    }
}
