
import Model.Data_Nilai;
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
public class TestData_Nilai {
    public static void main(String[] args) throws SQLException {
        Data_Nilai data = new Data_Nilai();
        //check data nilai
        System.out.println("check data nilai");
        Boolean checkDataNilai = data.CekDataNilai(1, 7, 2016, "16001");
        if (checkDataNilai==false) System.out.println("data ada");
        else if (true==checkDataNilai) System.out.println("data tidak ada");
        
        //size
//        System.out.println("\nsize");
//        int size=data.Size("16001");
//        System.out.println(size);
        
        //hitung nilai
//        System.out.println("hitung nilai");
//        data.HitungNilai("16098", 1, "A1", 2016, 90, 90, 90, 90);
        
        //get nilai
//        System.out.println("get nilai");
//        data.GetNilai("16001");
//        for (int i = 0; i < size; i++) {
//            System.out.print(data.data[i].getNis());
//            System.out.print(data.data[i].getKode_mata_pelajaran());
//            System.out.print(data.data[i].getSemester());
//            System.out.print(data.data[i].getTahun_ajaran());
//            System.out.print(data.data[i].getNilai_tugas());
//            System.out.print(data.data[i].getNilai_harian());
//            System.out.print(data.data[i].getNilai_uts());
//            System.out.print(data.data[i].getNilai_uas());
//            System.out.println(data.data[i].getNilai_semester());
//        }
    }
}
