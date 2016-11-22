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
        new NilaiServlet().InsertDataKelas("16001", "7A", 2016);
    }
}
