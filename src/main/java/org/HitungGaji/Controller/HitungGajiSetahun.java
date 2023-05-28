package org.HitungGaji.Controller;

import org.HitungGaji.Entity.EmployeeData;
import org.HitungGaji.Entity.KomponenGajiDAO;

public class HitungGajiSetahun {

    public double calculateGajiBersihIndonesia (EmployeeData employeeData){
        double totalPenghasilan = 0;
        double totalPengeluaran = 0;
        double  totalSetahun;

        for (KomponenGajiDAO komponenGaji : employeeData.getKomponenGajiDAO()) {
            if (komponenGaji.getType().equals("earning")) {
                totalPenghasilan += komponenGaji.getAmount();
            } else if (komponenGaji.getType().equals("deduction")) {
                totalPengeluaran += komponenGaji.getAmount();
            }
        }
        double  hasil =  (totalPenghasilan - totalPengeluaran);
        totalSetahun = hasil * 12;


        return totalSetahun;
    }
    public double calculateGajiBersihVietnam(EmployeeData employeeData){
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
}
