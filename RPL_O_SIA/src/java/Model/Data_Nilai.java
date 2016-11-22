/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author bella
 */
public class Data_Nilai {

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
}
