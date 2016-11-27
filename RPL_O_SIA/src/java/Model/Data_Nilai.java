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
public class Data_Nilai {
    static boolean statusSementara = true;
    int size = 0;
    public static Data_Nilai[] data;
    
    
    private String nis;
    private int tahun_ajaran;
    private String kode_mata_pelajaran;
    private int semester;
    private double nilai_harian;
    private double nilai_tugas;
    private double nilai_uts;
    private double nilai_uas;
    private double nilai_semester;
    private double nilai_akhir;

//    public Data_Nilai(String nis, int tahun_ajaran, String kelas, int semester, double nilai_harian, double nilai_tugas, double nilai_uts, double nilai_uas, double nilai_semester, double nilai_akhir) {
//        this.nis = nis;
//        this.tahun_ajaran = tahun_ajaran;
//        this.kelas = kelas;
//        this.semester = semester;
//        this.nilai_harian = nilai_harian;
//        this.nilai_tugas = nilai_tugas;
//        this.nilai_uts = nilai_uts;
//        this.nilai_uas = nilai_uas;
//        this.nilai_semester = nilai_semester;
//        this.nilai_akhir = nilai_akhir;
//    }

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

    public String getKode_mata_pelajaran() {
        return kode_mata_pelajaran;
    }

    public void setKode_mata_pelajaran(String kode_mata_pelajaran) {
        this.kode_mata_pelajaran = kode_mata_pelajaran;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getNilai_harian() {
        return nilai_harian;
    }

    public void setNilai_harian(double nilai_harian) {
        this.nilai_harian = nilai_harian;
    }

    public double getNilai_tugas() {
        return nilai_tugas;
    }

    public void setNilai_tugas(double nilai_tugas) {
        this.nilai_tugas = nilai_tugas;
    }

    public double getNilai_uts() {
        return nilai_uts;
    }

    public void setNilai_uts(double nilai_uts) {
        this.nilai_uts = nilai_uts;
    }

    public double getNilai_uas() {
        return nilai_uas;
    }

    public void setNilai_uas(double nilai_uas) {
        this.nilai_uas = nilai_uas;
    }

    public double getNilai_semester() {
        return nilai_semester;
    }

    public void setNilai_semester(double nilai_semester) {
        this.nilai_semester = nilai_semester;
    }

    public double getNilai_akhir() {
        return nilai_akhir;
    }

    public void setNilai_akhir(double nilai_akhir) {
        this.nilai_akhir = nilai_akhir;
    }
    
    public boolean CekDataNilai(int semester, int kelas, int tahun_ajaran, String nis) throws SQLException {
        ArrayList<Data_Nilai> list = new ArrayList<Data_Nilai>();
        String a = nis;
        int b = semester;
        int c = tahun_ajaran;
        int d = 0;
        if (kelas == 7) {
            d = 1;
        } else if (kelas == 8) {
            kelas = 2;
        } else {
            kelas = 3;
        }
        //buat konesi
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from data_nilai where nis=\'" + a + "\' "
                + "and semester=" + b + " and tahun_ajaran=" + c + " and kode_mata_pelajaran=\'A" + d + "\'"
                + "");
        //execute query
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Data_Nilai data_Nilai = new Data_Nilai();
            data_Nilai.setNis(resultSet.getString("nis"));
            data_Nilai.setSemester(resultSet.getInt("semester"));
            data_Nilai.setNilai_tugas(resultSet.getDouble("nilai_tugas"));
            data_Nilai.setNilai_harian(resultSet.getDouble("nilai_harian"));
            data_Nilai.setNilai_uts(resultSet.getDouble("nilai_uts"));
            data_Nilai.setNilai_uas(resultSet.getDouble("nilai_uas"));
            data_Nilai.setNilai_semester(resultSet.getDouble("nilai_semester"));
            data_Nilai.setNilai_akhir(resultSet.getDouble("nilai_akhir"));
            data_Nilai.setTahun_ajaran(resultSet.getInt("tahun_ajaran"));
            data_Nilai.setKode_mata_pelajaran(resultSet.getString("kode_mata_pelajaran"));
            list.add(data_Nilai);
        }
        if (list.isEmpty() == false) {
            return false;
        }
        System.out.println("asd");
        return true;
    }
    
    public static void HitungNilai(String nis, int semester, String kode_mata_pelajaran, int tahun_ajaran, double nilai_harian, double nilai_tugas, double nilai_uts, double nilai_uas) throws SQLException {
        //buat koneksi
        Connection connection = new DatabaseConnection().getConnection();
        //buat statement
        PreparedStatement statement;
        ResultSet resultSet;
        //hitung nilai semester
        double nilai_semester = (0.1 * nilai_tugas) + (0.2 * nilai_harian) + (0.3 * nilai_uts) + (0.4 * nilai_uas);
        //hitung nilai akhir
        double nilai_akhir = 0;
        if (semester == 2) {
            statement = connection.prepareStatement(""
                    + "select nilai_akhir from data_nilai where nis=\'" + nis + "\' "
                    + "and semester=1 and tahun_ajaran=" + tahun_ajaran + " "
                    + "and kode_mata_pelajaran=\'"+kode_mata_pelajaran+"\'"
                    + "");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getDouble("nilai_akhir"));
                nilai_akhir = (resultSet.getDouble("nilai_akhir") + nilai_semester) / 2;
            }
            statement = connection.prepareStatement(""
                    + "select kkm from mata_pelajaran where "
                    + "kode_mata_pelajaran=\'"+kode_mata_pelajaran+"\'"
                    + "");
            resultSet = statement.executeQuery();
            //hitung status per mata pelajaran
            while (resultSet.next()) {
                double kkm = resultSet.getDouble("kkm");
                if (nilai_akhir <= kkm) {
                    statusSementara = false;
                }
            }
        } else {
            nilai_akhir = nilai_semester;
        }
        //input ke tabel nilai
        statement = connection.prepareStatement(""
                + "insert into data_nilai (nis, semester, kode_mata_pelajaran, tahun_ajaran"
                + ", nilai_tugas, nilai_harian, nilai_uts, nilai_uas, nilai_semester, nilai_akhir) "
                + "values (?,?,?,?,?,?,?,?,?,?)"
        );
        //set value
        statement.setString(1, nis);
        statement.setInt(2, semester);
        statement.setString(3, kode_mata_pelajaran);
        statement.setInt(4, tahun_ajaran);
        statement.setDouble(5, nilai_tugas);
        statement.setDouble(6, nilai_harian);
        statement.setDouble(7, nilai_uts);
        statement.setDouble(8, nilai_uas);
        statement.setDouble(9, nilai_semester);
        statement.setDouble(10, nilai_akhir);
        //execute query
        resultSet = statement.executeQuery();
    }
    
    ////////////////////////////////////////////////////////////
    
    public int Size(String nis) throws SQLException{
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(""
                + "select nis from data_nilai where nis=\'"+nis+"\'");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            size++;
        }
        return size;
    }
    
    public void GetNilai (String nis) throws SQLException{
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(""
                + "select * from data_nilai where nis=\'"+nis+"\' "
                + "order by tahun_ajaran, semester, kode_mata_pelajaran"
                + "");
        ResultSet resultSet = statement.executeQuery();
        data = new Data_Nilai[Size(nis)];
        System.out.println(data.length);
        int i = 0;
        while (resultSet.next()) {
            data[i] = new Data_Nilai();
            data[i].setNis(nis);
            data[i].setSemester(resultSet.getInt("semester"));
            data[i].setTahun_ajaran(resultSet.getInt("tahun_ajaran"));
            data[i].setKode_mata_pelajaran(resultSet.getString("kode_mata_pelajaran"));
            data[i].setNilai_tugas(resultSet.getDouble("nilai_tugas"));
            data[i].setNilai_harian(resultSet.getDouble("nilai_harian"));
            data[i].setNilai_uts(resultSet.getDouble("nilai_uts"));
            data[i].setNilai_uas(resultSet.getDouble("nilai_uas"));
            data[i].setNilai_semester(resultSet.getDouble("nilai_semester"));
            data[i].setNilai_akhir(resultSet.getDouble("nilai_akhir"));
//            System.out.println(data[i].getKode_mata_pelajaran());
            i++;
        }
    }
}
