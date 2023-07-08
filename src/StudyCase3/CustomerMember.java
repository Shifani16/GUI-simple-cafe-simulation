/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyCase3;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class CustomerMember extends Customer {
    private String namaMember;
    private Date tanggalRegis;
    
    public CustomerMember(String namaMember, Date tanggalRegis, double saldoAwal) {
        super(saldoAwal);
        this.namaMember = namaMember;
        this.tanggalRegis = tanggalRegis;
    }

    public String getNamaMember() {
        return namaMember;
    }

    public void setNamaMember(String namaMember) {
        this.namaMember = namaMember;
    }

    public Date getTanggalRegis() {
        return tanggalRegis;
    }

    public void setTanggalRegis(Date tanggalRegis) {
        this.tanggalRegis = tanggalRegis;
    }
}
