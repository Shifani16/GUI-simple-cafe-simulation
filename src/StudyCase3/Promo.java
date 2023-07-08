/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyCase3;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public abstract class Promo implements Applicable, Comparable<Promo>{
    private String kodePromo;
    private Date tanggalAwal;
    private Date tanggalAkhir;
    private int persenPotongan;
    private double maksPotongan;
    private double minPembelian;
    private String jenisPromo;
    private double hargaDiskon;
    private boolean isApplied;

    public Promo(String kodePromo, Date tanggalAwal, Date tanggalAkhir, int persenPotongan, double maksPotongan, double minPembelian, String jenisPromo) {
        this.kodePromo = kodePromo;
        this.tanggalAwal = tanggalAwal;
        this.tanggalAkhir = tanggalAkhir;
        this.persenPotongan = persenPotongan;
        this.maksPotongan = maksPotongan;
        this.minPembelian = minPembelian;
        this.jenisPromo = jenisPromo;
    }

    public void setJenisPromo(String jenisPromo) {
        this.jenisPromo = jenisPromo;
    }
    
    public String getJenisPromo() {
        return jenisPromo;
    }

    public Promo(String kodePromo, double hargaDiskon) {
        this.kodePromo = kodePromo;
        this.hargaDiskon = hargaDiskon;
    }

    public Promo(String kodePromo, boolean isApplied) {
        this.kodePromo = kodePromo;
        this.isApplied = isApplied;
    }
   

    public void setKodePromo(String kodePromo) {
        this.kodePromo = kodePromo;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    
    public Date getTanggalAwal() {
        return tanggalAwal;
    }
    
    public void setTanggalAwal(Date tanggalAwal) {
        this.tanggalAwal = tanggalAwal;
    }

    public Date getTanggalAkhir() {
        return tanggalAkhir;
    }
    
    public void setTanggalAkhir(Date tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public int getPersenPotongan() {
        return persenPotongan;
    }
    
    public void setPersenPotongan(int persenPotongan) {
        this.persenPotongan = persenPotongan;
    }

    public double getMaksPotongan() {
        return maksPotongan;
    }
    
    public void setMaksPotongan(double maksPotongan) {
        this.maksPotongan = maksPotongan;
    }

    public double getMinPembelian() {
        return minPembelian;
    }
    
    public void setMinPembelian(double minPembelian) {
        this.minPembelian = minPembelian;
    }

    public double getHargaDiskon() {
        return hargaDiskon;
    }

    public void setHargaDiskon(double hargaDiskon) {
        this.hargaDiskon = hargaDiskon;
    }

    public void isApplicable(String kodePromo) {
        this.kodePromo = kodePromo;
    }

    public boolean alreadyApplicable() {
        return true;
    }
}



