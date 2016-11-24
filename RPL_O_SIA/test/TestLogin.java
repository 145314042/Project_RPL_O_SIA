
import Model.Login;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lycorice
 */
public class TestLogin {
    public static void main(String[] args) throws SQLException {
        Login login = new Login();
        System.out.println(login.login("guru", "guru"));
        System.out.println(login.login("16001", "16001"));
        System.out.println(login.login("16001a", "16001a"));
    }
}
