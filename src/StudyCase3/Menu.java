/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyCase3;

/**
 *
 * @author ASUS
 */
public class Menu {
    public String namaMenu;
    public double hargaMenu;
    public String IDMenu;
    private int totalQty;
    private double totalHarga;

    public Menu(String IDMenu, String namaMenu, double hargaMenu) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.IDMenu = IDMenu;
    }


    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public double getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(double hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public String getIDMenu() {
        return IDMenu;
    }

    public void setIDMenu(String IDMenu) {
        this.IDMenu = IDMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }
}

