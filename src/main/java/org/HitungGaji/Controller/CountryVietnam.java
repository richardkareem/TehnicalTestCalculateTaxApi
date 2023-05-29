package org.HitungGaji.Controller;

import org.HitungGaji.Entity.EmployeeData;
import org.HitungGaji.Entity.KomponenGajiDAO;

import java.text.NumberFormat;
import java.util.Locale;

public class CountryVietnam implements TaxCountry {
    @Override
    public double calculateTax(double penghasilanBersih) {
        double hasil = 0;
        double setelahDikurangin = 0;

        if(penghasilanBersih >= 50000000){
            setelahDikurangin = penghasilanBersih - 50000000;
            double pajak1 = 50000000 * 0.025;
            double pajak2 = 0;
            if(setelahDikurangin > 50000000){
                pajak2 = setelahDikurangin * 0.075;
            }
            hasil = pajak1 + pajak2;
        }
        return hasil;
    }

    @Override
    public double getPTKP(String martial, int childs) {
        double ptkp=0;

        if (martial.equalsIgnoreCase("single")) {

            ptkp=15000000;
        }else{
            ptkp=30000000;
        }
        return ptkp;
    }

    @Override
    public double calculateSallary(EmployeeData employeeData) {
        double totalPenghasilan = 0;
        double totalPengeluaran = 0;
        double totalAsuransi =0;
        double  totalSetahun;


        for (KomponenGajiDAO komponenGaji : employeeData.getKomponenGajiDAO()) {
            if (komponenGaji.getType().equals("earning")) {
                totalPenghasilan += komponenGaji.getAmount();
            } else if (komponenGaji.getType().equals("deduction")) {
                totalPengeluaran += komponenGaji.getAmount();
            }else if(komponenGaji.getType().equalsIgnoreCase("insurance") || komponenGaji.getType().equalsIgnoreCase("asuransi")){
                totalAsuransi += komponenGaji.getAmount();

            }
        }
        double  hasil = (totalPenghasilan - totalPengeluaran);
        totalSetahun = hasil * 12;
        double asuransiSetahun = totalAsuransi*12;


        return totalSetahun - asuransiSetahun;
    }

    @Override
    public String formatCurrency(double result) {
        Locale locale = new Locale.Builder().setLanguage("vi").setRegion("VN").build();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        return currencyFormatter.format(result);
    }
}
