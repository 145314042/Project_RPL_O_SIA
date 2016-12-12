/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Data_Nilai;
import Model.Kelas;
import Model.Siswa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        boolean stat=true;
        String[] kode_mata_pelajaran = new String[10];
        double[] nilai1 = new double[10];
        double[] nilai2 = new double[10];
        double[] nilai3 = new double[10];
        double[] nilai4 = new double[10];
        String nis = request.getParameter("nis");
        int semester = 0;
        int kelas;
        int tahun_ajaran = 0;
        int cd=0;
        try {
            nis = request.getParameter("nis");
            semester = Integer.parseInt(request.getParameter("semester"));
            kelas = Integer.parseInt(request.getParameter("kelas"));
            tahun_ajaran = Integer.parseInt(request.getParameter("tahun_ajaran"));
            for (int i = 0; i < 10; i++) {
                if (kelas == 7) kode_mata_pelajaran[i] = "A"+(i);
                else if (kelas == 8) kode_mata_pelajaran[i] = "B"+(i);
                else kode_mata_pelajaran[i] = "C"+(i);
            }
            //1 nis
            if (new Siswa().CekSiswa(request.getParameter("nis"))==false) {
                stat = false;
                cd = 2;
            }
            //2 tahun ajaran
            //otw
            //3 kelas
            if (new Data_Nilai().CekDataNilai(semester,kelas,tahun_ajaran,nis)==false) {
                cd = 3;
                stat = false;
            }
            for (int i = 0; i < 10; i++) {
                String[] kode = {"A","B","C","D","E","F","G","H","I","J"};
                nilai1[i] = Double.parseDouble(request.getParameter(kode[i]+0));
                nilai2[i] = Double.parseDouble(request.getParameter(kode[i]+1));
                nilai3[i] = Double.parseDouble(request.getParameter(kode[i]+2));
                nilai4[i] = Double.parseDouble(request.getParameter(kode[i]+3));
                if (nilai1[i]<=0||nilai1[i]>=100){cd=4;stat = false;}
                if (nilai2[i]<=0||nilai2[i]>=100){cd=4;stat = false;}
                if (nilai3[i]<=0||nilai3[i]>=100){cd=4;stat = false;}
                if (nilai4[i]<=0||nilai4[i]>=100){cd=4;stat = false;}
            }
        } catch (NumberFormatException e) {
            cd=1;
            stat=false;
        } catch (Exception ex){
            cd=1;
            stat=false;
        }finally {
            if (stat==false) response.sendRedirect("nilaiSiswa.jsp?error="+cd);
            if (stat==true){
                //4
                for (int i = 0; i < 10; i++) {
                    new Data_Nilai().HitungNilai(nis, semester, kode_mata_pelajaran[i], tahun_ajaran, nilai1[i], nilai2[i], nilai3[i], nilai4[i]);
                }
                if (semester == 2){
                    new Kelas().InsertDataKelas(nis, tahun_ajaran);
                }
                response.sendRedirect("homeGuru.jsp?success=1");
            }
            out.close();
        }
            //5
            
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
            Logger.getLogger(NilaiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NilaiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
