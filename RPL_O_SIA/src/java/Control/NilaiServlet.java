/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ConnectionDataBase.DatabaseConnection;
import Model.Data_Nilai;
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
import javax.swing.JOptionPane;

/**
 *
 * @author SIWI
 */
public class NilaiServlet extends HttpServlet {

    boolean status = true;

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
            String nis = request.getParameter("nis");
            int semester = Integer.parseInt(request.getParameter("semester"));
            int kelas = Integer.parseInt(request.getParameter("kelas"));
            String[] kode_mata_pelajaran = new String[10];
            for (int i = 0; i < 10; i++) {
                if (kelas == 7) kode_mata_pelajaran[i] = "A"+(i+1);
                else if (kelas == 8) kode_mata_pelajaran[i] = "B"+(i+1);
                else kode_mata_pelajaran[i] = "C"+(i+1);
            }
            int tahun_ajaran = Integer.parseInt(request.getParameter("tahun_ajaran"));
            if (!CekSiswa(request.getParameter("nis"))) {
                response.sendRedirect("nilaiSiswa.jsp?error=2");
            }
            if (!CekDataNilai(semester,kelas,tahun_ajaran,nis)) {
                response.sendRedirect("nilaiSiswa.jsp?error=3");
            }
            for (int i = 0; i < 10; i++) {
//                JOptionPane.showMessageDialog(null, "as");
                String[] kode = {"A","B","C","D","E","F","G","H","I","J"};
                double nilai1 = Double.parseDouble(request.getParameter(kode[i]+0));
                double nilai2 = Double.parseDouble(request.getParameter(kode[i]+1));
                double nilai3 = Double.parseDouble(request.getParameter(kode[i]+2));
                double nilai4 = Double.parseDouble(request.getParameter(kode[i]+3));
//                JOptionPane.showMessageDialog(null, (kode_mata_pelajaran[i]));
                HitungNilai(nis, semester, kode_mata_pelajaran[i], tahun_ajaran, nilai1, nilai2, nilai3, nilai4);
            }
//                JOptionPane.showMessageDialog(null, "a");
            if (semester == 2){
                InsertDataKelas(nis, tahun_ajaran);
            }
            response.sendRedirect("homeGuru.jsp?success=1");
        } catch (Exception e) {
            response.sendRedirect("nilaiSiswa.jsp?error=1");
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

    public boolean CekSiswa(String nis) throws SQLException {
        ArrayList<Siswa> list = new ArrayList<Siswa>();
        //baca parameter
        String a = nis;
        //buat koneksi
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        //buat statement dan query
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from siswa where nis=\'" + a + "\'"
                + "");
        //execute query
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Siswa siswa = new Siswa();
            siswa.setNis(resultSet.getString("nis"));
            siswa.setNama(resultSet.getString("nama"));
            siswa.setTempat_tanggal_lahir(resultSet.getString("tempat_tanggal_lahir"));
            siswa.setAlamat(resultSet.getString("alamat"));
            list.add(siswa);
        }
        //jika data tidak ada
        if (list.isEmpty() == true) {
            System.out.println("tidak ada");
            return false;
        }
        System.out.println("ada");
        return true;

    }

    public boolean CekDataNilai(int semester, int kelas, int tahun_ajaran, String nis) throws SQLException {
        ArrayList<Data_Nilai> list = new ArrayList<Data_Nilai>();
        String a = nis;
        int b = semester;
        int c = tahun_ajaran;
        int d = 0;
        if (kelas == 7) {
            d = 1;
        } else if (kelas == 8) {
            kelas = 2;
        } else {
            kelas = 3;
        }
        //buat konesi
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from data_nilai where nis=\'" + a + "\' "
                + "and semester=" + b + " and tahun_ajaran=" + c + " and kode_mata_pelajaran=\'A" + d + "\'"
                + "");
        //execute query
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Data_Nilai data_Nilai = new Data_Nilai();
            data_Nilai.setNis(resultSet.getString("nis"));
            data_Nilai.setSemester(resultSet.getInt("semester"));
            data_Nilai.setNilai_tugas(resultSet.getDouble("nilai_tugas"));
            data_Nilai.setNilai_harian(resultSet.getDouble("nilai_harian"));
            data_Nilai.setNilai_uts(resultSet.getDouble("nilai_uts"));
            data_Nilai.setNilai_uas(resultSet.getDouble("nilai_uas"));
            data_Nilai.setNilai_semester(resultSet.getDouble("nilai_semester"));
            data_Nilai.setNilai_akhir(resultSet.getDouble("nilai_akhir"));
            data_Nilai.setTahun_ajaran(resultSet.getInt("tahun_ajaran"));
            data_Nilai.setKode_mata_pelajaran(resultSet.getString("kode_mata_pelajaran"));
            list.add(data_Nilai);
        }
        if (list.isEmpty() == false) {
            return false;
        }
        System.out.println("asd");
        return true;
    }

    public void HitungNilai(String nis, int semester, String kode_mata_pelajaran, int tahun_ajaran, double nilai_harian, double nilai_tugas, double nilai_uts, double nilai_uas) throws SQLException {
        //buat koneksi
        Connection connection = new DatabaseConnection().getConnection();
        //buat statement
        PreparedStatement statement;
        ResultSet resultSet;
        //hitung nilai semester
        double nilai_semester = (0.1 * nilai_tugas) + (0.2 * nilai_harian) + (0.3 * nilai_uts) + (0.4 * nilai_uas);
        //hitung nilai akhir
        double nilai_akhir = 0;
        if (semester == 2) {
            statement = connection.prepareStatement(""
                    + "select nilai_akhir from data_nilai where nis=\'" + nis + "\' "
                    + "and semester=1 and tahun_ajaran=" + tahun_ajaran + " "
                    + "and kode_mata_pelajaran=\'"+kode_mata_pelajaran+"\'"
                    + "");
            resultSet = statement.executeQuery();
//            if (resultSet.wasNull()==true) {
//                return;
//            }
            while (resultSet.next()) {
                System.out.println(resultSet.getDouble("nilai_akhir"));
                nilai_akhir = (resultSet.getDouble("nilai_akhir") + nilai_semester) / 2;
            }
            statement = connection.prepareStatement(""
                    + "select kkm from mata_pelajaran where "
                    + "kode_mata_pelajaran=\'"+kode_mata_pelajaran+"\'"
                    + "");
            resultSet = statement.executeQuery();
            //hitung status per mata pelajaran
            while (resultSet.next()) {
                double kkm = resultSet.getDouble("kkm");
                if (nilai_akhir <= kkm) {
                    status = false;
                }
            }
        } else {
            nilai_akhir = nilai_semester;
        }
        //input ke tabel nilai
        statement = connection.prepareStatement(""
                + "insert into data_nilai (nis, semester, kode_mata_pelajaran, tahun_ajaran"
                + ", nilai_tugas, nilai_harian, nilai_uts, nilai_uas, nilai_semester, nilai_akhir) "
                + "values (?,?,?,?,?,?,?,?,?,?)"
        );
        //set value
        statement.setString(1, nis);
        statement.setInt(2, semester);
        statement.setString(3, kode_mata_pelajaran);
        statement.setInt(4, tahun_ajaran);
        statement.setDouble(5, nilai_tugas);
        statement.setDouble(6, nilai_harian);
        statement.setDouble(7, nilai_uts);
        statement.setDouble(8, nilai_uas);
        statement.setDouble(9, nilai_semester);
        statement.setDouble(10, nilai_akhir);
        //execute query
        resultSet = statement.executeQuery();
    }
//    public void InsertNilai(String nis, int tahun_ajaran, int semester, double nilai_harian,
//            double nilai_tugas, double nilai_uts, double nilai_uas, ){
//                
//    }
    //!!!!!!!!!!!!!!!!!!

    public void InsertDataKelas(String nis, int tahun_ajaran) throws SQLException {
        String kelas_awal = "";
        String kelas_akhir = "";
        //membuat koneksi
        Connection connection = new DatabaseConnection().getConnection();
        //membuat statement
        PreparedStatement statement;
        ResultSet resultSet;
        //membuat query untuk cari kelas awal
        statement = connection.prepareStatement(""
                + "select kelas_awal from kelas where nis=\'"+nis
                + "\' and tahun_ajaran="+tahun_ajaran
                + "");
        //execute query
        resultSet = statement.executeQuery();
        //set kelas awal dan kelas akhir
        while (resultSet.next()) {
            kelas_awal = resultSet.getString("kelas_awal");
        }
        String[] temp = kelas_awal.split("");
        if (status==true) {
            if (temp[0]=="9") kelas_akhir = "lulus";
            else kelas_akhir = String.valueOf(Integer.parseInt(temp[0])+1)+temp[1];
        } else kelas_akhir = kelas_awal;
        //membuat query untuk input data kelas
        statement = connection.prepareStatement(""
                + "insert into kelas(nis, tahun_ajaran, kelas_awal, kelas_akhir) "
                + "values (?,?,?,?)"
        );
        //input value
        statement.setString(1, nis);
        statement.setInt(2, tahun_ajaran + 1);
        statement.setString(3, kelas_awal);
        statement.setString(4, kelas_akhir);
        //execute query
        resultSet = statement.executeQuery();
    }
}
