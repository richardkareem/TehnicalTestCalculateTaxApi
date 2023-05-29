package org.HitungGaji.Controller;

import org.HitungGaji.Entity.EmployeeData;
import org.HitungGaji.Entity.KomponenGajiDAO;

import java.text.NumberFormat;
import java.util.Locale;

public class CountryIndonesia implements TaxCountry {
    @Override
    public double calculateTax(double penghasilanBersih) { //calculate Tax
        double hasil = 0;
        double setelahDikurangin = 0;
        double setelahDikuranginLagi = 0;
        //Locale


        if(penghasilanBersih > 50000000){
            setelahDikurangin =  penghasilanBersih - 50000000;
            double pajak1 = 50000000 * 0.05;
            double pajak2 = setelahDikurangin * 0.1;
            hasil = pajak1 + pajak2;

        }else if( penghasilanBersih > 250000000 ){
            setelahDikurangin = penghasilanBersih-50000000;
            double pajak1 = 50000000 * 0.05;
            setelahDikuranginLagi = setelahDikurangin-250000000;
            double pajak2 = 250000000 * 0.1;
            double pajak3 = setelahDikuranginLagi * 0.15;
            hasil =  pajak1 + pajak2 + pajak3;
        }else if(penghasilanBersih < 50000000){
            hasil = penghasilanBersih * 0.05;
        }
        return hasil/12;
    }


    @Override
    public double getPTKP(String martial, int childs) { //Getting PTKP
        double ptkp = 0 ;
        if (martial.equalsIgnoreCase("single")) {
            ptkp = 25000000;
        } else if (martial.equalsIgnoreCase("married")) {
            if (childs == 0) {
                ptkp = 50000000;
            } else {
                ptkp = 75000000;
            }
        }
        return ptkp;
    }

    @Override
    public double calculateSallary(EmployeeData employeeData) { // Calculate Gaji Bersih / Tahun
        double totalPenghasilan = 0;
        double totalPengeluaran = 0;
        double totalSetahun;

        for (KomponenGajiDAO komponenGaji : employeeData.getKomponenGajiDAO()) {
            if (komponenGaji.getType().equals("earning")) {
                totalPenghasilan += komponenGaji.getAmount();
            } else if (komponenGaji.getType().equals("deduction")) {
                totalPengeluaran += komponenGaji.getAmount();
            }
        }
        double hasil = (totalPenghasilan - totalPengeluaran);
        totalSetahun = hasil * 12;


        return totalSetahun;
    }

    @Override
    public String formatCurrency(double result) { //formatiing Into Local Currency
        Locale locale = new Locale.Builder().setLanguage("in").setRegion("ID").build();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        return currencyFormatter.format(result);
    }
}
