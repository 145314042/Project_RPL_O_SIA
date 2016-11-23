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
}
