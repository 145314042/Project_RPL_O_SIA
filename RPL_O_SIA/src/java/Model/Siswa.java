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
}
