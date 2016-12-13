
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
        //insert data kelas
//        System.out.println("insert data kelas");
//        new Kelas().InsertDataKelas("16002", 2016);
        
        //cek tahun ajaran
        System.out.println("cek tahun ajaran");
        if (new Kelas().cekTahunAjaran("16001", 2016)==true) System.out.println("ada");
        else System.out.println("tidak ada");
        if (new Kelas().cekTahunAjaran("16001", 2019)==true) System.out.println("ada");
        else System.out.println("tidak ada");
    }
}
