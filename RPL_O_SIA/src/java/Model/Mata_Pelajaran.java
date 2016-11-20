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
public class Mata_Pelajaran {
    String kode_pelajaran;
    double kkm;

    public Mata_Pelajaran(String kode_pelajaran, double kkm) {
        this.kode_pelajaran = kode_pelajaran;
        this.kkm = kkm;
    }

    public String getKode_pelajaran() {
        return kode_pelajaran;
    }

    public void setKode_pelajaran(String kode_pelajaran) {
        this.kode_pelajaran = kode_pelajaran;
    }

    public double getKkm() {
        return kkm;
    }

    public void setKkm(double kkm) {
        this.kkm = kkm;
    }
    
}
