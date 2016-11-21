/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ConnectionDataBase.DatabaseConnection;
import Model.Siswa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SIWI
 */
public class NilaiServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NilaiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NilaiServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    public boolean CekSiswa(String nis) throws SQLException{
        ArrayList<Siswa> list = new ArrayList<Siswa>();
        //baca parameter
        String a = nis;
        //buat koneksi
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        //buat statement dan query
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from siswa where username=\'"+a+"\' "
                + "");
        //execute query
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Siswa siswa = new Siswa();
            siswa.setNis(resultSet.getString("nis"));
            siswa.setNama(resultSet.getString("nama"));
            siswa.setTempat_tanggal_lahir(resultSet.getString("tempat_tanggal_lahir"));
            siswa.setAlamat(resultSet.getString("alamat"));
            list.add(siswa);
        }
        //jika data tidak ada
        if (list.isEmpty()==true){
            return false;
        }
        return true;
        
    }
    public boolean CekDataNilai(int semester, String kelas, int tahun_ajaran, String nis ) throws SQLException{
        String a = nis;
        String b = String.valueOf(semester);
        //buat konesi
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from login where username=\'"+a+"\' "
                + "and password=\'"+b+"\' and password=\'"+b+"\'"
                + "");
        return true;
    }
    public void HitungNilai(String semester, double nilai_harian, double nilai_tugas, double nilai_uts, double nilai_uas){
        
    }
    public void InsertNilai(String nis, int tahun_ajaran, String semester, double niai_akhir){
                
    }
    public void InsertDataKelas(String nis, String kelas, int tahun_ajaran){
        
    }
}