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

/**
 *
 * @author bella
 */
public class Kelas {
    String nis;
    int tahun_ajaran;
    String kelas_awal;
    String kelas_akhir;

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public int getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(int tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }

    public String getKelas_awal() {
        return kelas_awal;
    }

    public void setKelas_awal(String kelas_awal) {
        this.kelas_awal = kelas_awal;
    }

    public String getKelas_akhir() {
        return kelas_akhir;
    }

    public void setKelas_akhir(String kelas_akhir) {
        this.kelas_akhir = kelas_akhir;
    }
    
    public void InsertDataKelas(String nis, int tahun_ajaran) throws SQLException {
        String kelas_awal = "";
        String kelas_akhir = "";
        //membuat koneksi
        Connection connection = new DatabaseConnection().getConnection();
        //membuat statement
        PreparedStatement statement;
        ResultSet resultSet;
        //membuat query untuk cari kelas awal
        statement = connection.prepareStatement(""
                + "select kelas_awal from kelas where nis=\'"+nis
                + "\' and tahun_ajaran="+tahun_ajaran
                + "");
        //execute query
        resultSet = statement.executeQuery();
        //set kelas awal dan kelas akhir
        while (resultSet.next()) {
            kelas_awal = resultSet.getString("kelas_awal");
        }
        String[] temp = kelas_awal.split("");
        if (new Data_Nilai().statusSementara==true) {
            if (temp[0]=="9") kelas_akhir = "lulus";
            else kelas_akhir = String.valueOf(Integer.parseInt(temp[0])+1)+temp[1];
        } else kelas_akhir = kelas_awal;
        //membuat query untuk input data kelas
        statement = connection.prepareStatement(""
                + "insert into kelas(nis, tahun_ajaran, kelas_awal, kelas_akhir) "
                + "values (?,?,?,?)"
        );
        //input value
        statement.setString(1, nis);
        statement.setInt(2, tahun_ajaran + 1);
        statement.setString(3, kelas_awal);
        statement.setString(4, kelas_akhir);
        //execute query
        resultSet = statement.executeQuery();
    }
}
