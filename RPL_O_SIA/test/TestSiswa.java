
import Model.Siswa;
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
public class TestSiswa {
    public static void main(String[] args) throws SQLException {
        Siswa data = new Siswa();
        
        //cek siswa
        boolean siswa = data.CekSiswa("16001");
        if (siswa) System.out.println("data ada");
        else System.out.println("data tidak ada");
        
        //get nama siswa
        System.out.println(data.getNamaSiswa("16001"));
    }
}
