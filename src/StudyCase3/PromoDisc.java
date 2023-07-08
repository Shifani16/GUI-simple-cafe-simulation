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
public class PromoDisc extends Promo {

    private double hargaDiskon;
    private Map<String, Menu> menus;

    public PromoDisc(String kodePromo, Date tanggalAwal, Date tanggalAkhir, int persenPotongan, double maksPotongan, double minPembelian, String jenisPromo) {
        super(kodePromo, tanggalAwal, tanggalAkhir, persenPotongan, maksPotongan, minPembelian, jenisPromo);
    }

    @Override
    public boolean isCustomerEligible(CustomerEligible x) {
        return false;
    }

    @Override
    public boolean isMinimumPriceEligible(OrderEligible x) {
        return false;
    }

    @Override
    public boolean isShippingFeeEligible(OrderEligible x) {
        return false;
    }

    @Override
    public int compareTo(Promo o) {
        return 0;
    }
}