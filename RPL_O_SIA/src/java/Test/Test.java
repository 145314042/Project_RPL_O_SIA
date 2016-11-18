/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Control.LoginServlet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lycorice
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        System.out.println(new LoginServlet().login("guru", "guru"));
        JOptionPane.showMessageDialog(null, "");
    }
}
