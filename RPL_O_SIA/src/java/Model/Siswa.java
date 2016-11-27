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
 * @author bella
 */
public class Siswa {

    String nis;
    private String nama;
    private String tempat_tanggal_lahir;
    private String alamat;

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat_tanggal_lahir() {
        return tempat_tanggal_lahir;
    }

    public void setTempat_tanggal_lahir(String tempat_tanggal_lahir) {
        this.tempat_tanggal_lahir = tempat_tanggal_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public boolean CekSiswa(String nis) throws SQLException {
        ArrayList<Siswa> list = new ArrayList<Siswa>();
        //baca parameter
        String a = nis;
        //buat koneksi
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        //buat statement dan query
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from siswa where nis=\'" + a + "\'"
                + "");
        //execute query
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Siswa siswa = new Siswa();
            siswa.setNis(resultSet.getString("nis"));
            siswa.setNama(resultSet.getString("nama"));
            siswa.setTempat_tanggal_lahir(resultSet.getString("tempat_tanggal_lahir"));
            siswa.setAlamat(resultSet.getString("alamat"));
            list.add(siswa);
        }
        //jika data tidak ada
        if (list.isEmpty() == true) {
            System.out.println("tidak ada");
            return false;
        }
        System.out.println("ada");
        return true;

    }

    public String getNamaSiswa(String nis) throws SQLException {
        String namaSiswa = null;
        //buat koneksi
        Connection conn = new DatabaseConnection().getConnection();
        //buat statement dan query
        PreparedStatement pStatement = conn.prepareStatement(""
                + "select nama from siswa where nis=\'" + nis + "\'");
        //execute query
        ResultSet rSet = pStatement.executeQuery();
        while (rSet.next()) {
            namaSiswa = rSet.getString("nama");
        }
        //mengembalikan nama siswa
        return namaSiswa;
    }
}
