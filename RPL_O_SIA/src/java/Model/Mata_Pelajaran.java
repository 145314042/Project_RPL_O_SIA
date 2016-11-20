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
    String kode_makul;
    double kkm;

    public Mata_Pelajaran(String kode_makul, double kkm) {
        this.kode_makul = kode_makul;
        this.kkm = kkm;
    }

    public String getKode_makul() {
        return kode_makul;
    }

    public void setKode_makul(String kode_makul) {
        this.kode_makul = kode_makul;
    }

    public double getKkm() {
        return kkm;
    }

    public void setKkm(double kkm) {
        this.kkm = kkm;
    }
    
}
