/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Control.LoginServlet;
import Control.NilaiServlet;
import Model.Data_Nilai;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lycorice
 */
public class Test {
    public static void main(String[] args) throws SQLException {
//        new NilaiServlet().InsertDataKelas("16001", "7A", 2016);
//        new NilaiServlet().HitungNilai("16001", 1, "A1", 2016, 90, 90, 90, 10);
        new NilaiServlet().CekDataNilai(1, 7, 2016, "16001");
        new NilaiServlet().CekSiswa("16001");
    }
}
