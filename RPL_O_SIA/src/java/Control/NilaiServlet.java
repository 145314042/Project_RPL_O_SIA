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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String nis = request.getParameter("nis");
            int semester = Integer.parseInt(request.getParameter("semester"));
            int kelas = Integer.parseInt(request.getParameter("kelas"));
            String[] kode_mata_pelajaran = new String[10];
            for (int i = 0; i < 10; i++) {
                if (kelas == 7) kode_mata_pelajaran[i] = "A"+(i);
                else if (kelas == 8) kode_mata_pelajaran[i] = "B"+(i);
                else kode_mata_pelajaran[i] = "C"+(i);
            }
            int tahun_ajaran = Integer.parseInt(request.getParameter("tahun_ajaran"));
            //1
            if (!new Siswa().CekSiswa(request.getParameter("nis"))) {
                response.sendRedirect("nilaiSiswa.jsp?error=2");
            }
            //2
            if (!new Data_Nilai().CekDataNilai(semester,kelas,tahun_ajaran,nis)) {
                response.sendRedirect("nilaiSiswa.jsp?error=3");
            }
            //3
            for (int i = 0; i < 10; i++) {
                String[] kode = {"A","B","C","D","E","F","G","H","I","J"};
                double nilai1 = Double.parseDouble(request.getParameter(kode[i]+0));
                double nilai2 = Double.parseDouble(request.getParameter(kode[i]+1));
                double nilai3 = Double.parseDouble(request.getParameter(kode[i]+2));
                double nilai4 = Double.parseDouble(request.getParameter(kode[i]+3));
                if (nilai1<=0||nilai1>=100)response.sendRedirect("nilaiSiswa.jsp?error=4");
                if (nilai2<=0||nilai2>=100)response.sendRedirect("nilaiSiswa.jsp?error=4");
                if (nilai3<=0||nilai3>=100)response.sendRedirect("nilaiSiswa.jsp?error=4");
                if (nilai4<=0||nilai4>=100)response.sendRedirect("nilaiSiswa.jsp?error=4");
                new Data_Nilai().HitungNilai(nis, semester, kode_mata_pelajaran[i], tahun_ajaran, nilai1, nilai2, nilai3, nilai4);
            }
            //4
            if (semester == 2){
                new Kelas().InsertDataKelas(nis, tahun_ajaran);
            }
            //5
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

}
