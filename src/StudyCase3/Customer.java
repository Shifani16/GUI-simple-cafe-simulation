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
public class Customer {
    public double saldoAwal;
    private ShoppingCart cart;
    private static int nomorPesanan = 1;
    private int nomor;
    private double ongkir;

    public Customer(double saldoAwal) {
        this.saldoAwal = saldoAwal;
        this.cart = new ShoppingCart();
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public double getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoAwal(double saldoAwal) {
        this.saldoAwal = saldoAwal;
    }

    public double getOngkir() {
        return 15000;
    }
    
    public void setOngkir(double ongkir) {
        this.ongkir = ongkir;
    }

    public int nomorPesanan() {
        return nomorPesanan++;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }
    
}



