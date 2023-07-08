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
public class PromoCashBack extends Promo {

    public PromoCashBack(String kodePromo, Date tanggalAwal, Date tanggalAkhir, int persenPotongan, double maksPotongan, double minPembelian, String jenisPromo) {
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
