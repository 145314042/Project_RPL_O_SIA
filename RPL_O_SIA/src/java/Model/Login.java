/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ConnectionDataBase.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lycorice
 */
public class Login {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(String username, String password) throws SQLException {
        ArrayList<Login> list = new ArrayList<Login>();
        //baca parameter
        String a = username, b = password;
        //buat koneksi
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        //buat statement dan query
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from login where username=\'"+a+"\' "
                + "and password=\'"+b+"\'"
        );
        ResultSet resultSet = statement.executeQuery();
        //set value ArrayList
        while (resultSet.next()){
            Login login = new Login();
            login.setUsername(resultSet.getString("username"));
            login.setPassword(resultSet.getString("password"));
            list.add(login);
        }
        //jika data
        //data ada
        if (!list.isEmpty()) {
            for (Login login : list) {
                //jika data = guru
                if ("guru".equals(login.getUsername())) 
                    return "homeGuru.jsp";
                //jika data selain guru
                else return "homeSiswa.jsp";
            }
        }
        //data tidak ada
        else return "home.jsp?error=1";
        return null;
    }

    
}
