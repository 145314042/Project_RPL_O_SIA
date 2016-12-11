
import Model.Kelas;
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
public class TestKelas {
    public static void main(String[] args) throws SQLException {
        System.out.println("insert data kelas");
        new Kelas().InsertDataKelas("16002", 2016);
    }
}
