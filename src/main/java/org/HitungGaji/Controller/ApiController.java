package org.HitungGaji.Controller;

import org.HitungGaji.Entity.EmployeeData;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.Locale;


@RestController
public class ApiController {


//    private PerhitunganPTKP perhitunganPTKP;
//
//    private TarifPajak tarifPajak;

    private HitungGajiSetahun hitungGajiSetahun = new HitungGajiSetahun();
    private PTKP ptkp = new PTKP();
    private HitungPajak hitungPajak =  new HitungPajak();

    @PostMapping("/hitungpajak")
    public String
    hitungPajakApi(@RequestBody EmployeeData employeeData) {
        String result = "";
        if(employeeData.getEmployeeDAO().getCountry().equalsIgnoreCase("Indonesia")){

            //get ptkp Country
            double ptkpIndonesia = ptkp.PTKPIndonesia(employeeData.getEmployeeDAO().getMartialStatus(), employeeData.getEmployeeDAO().getChilds()); //75000000
            boolean isPtkp = ptkpIndonesia>0;
            //check ptkp
            if(isPtkp){
                //calculate pajakNetto
                double pajakNetto = hitungGajiSetahun.calculateGajiBersihIndonesia(employeeData) - ptkpIndonesia;
                double totalPajakBulanan = hitungPajak.hitungPajakIndo(pajakNetto) / 12;
                //currency format into Rupiah
                Locale locale = new Locale.Builder().setLanguage("in").setRegion("ID").build();
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                result = String.valueOf("Pajak Mu Sebluan Adalah: " + currencyFormatter.format(totalPajakBulanan));
                return result;
            }else{
                return "Martial Status Salah Input atau belum diisi";
            }


        }else if(employeeData.getEmployeeDAO().getCountry().equalsIgnoreCase("Vietnam")){

            //get ptkp Country
            double ptkpVietnam = ptkp.PTKPVietnam(employeeData.getEmployeeDAO().getMartialStatus());
            boolean isPtkp = ptkpVietnam>0;
            //check ptkp
            if(isPtkp){
                //calculate pajakNetto
                double pajakNetto = hitungGajiSetahun.calculateGajiBersihVietnam(employeeData)-ptkpVietnam;
                double pajakBulanan = hitungPajak.hitungPajakVietnam(pajakNetto)/12;
                //currecy format into VND
                Locale locale = new Locale.Builder().setLanguage("vi").setRegion("VN").build();
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
//                System.out.println(currencyFormatter.format(pajakBulanan));
                result = String.valueOf("Pajak Mu Sebulan adalah : "+currencyFormatter.format(pajakBulanan));
                return result;
            }else{
                return "Martial Status Salah Input atau belum diisi";
            }

        }else{
            result = "Anda Bukan Karyawan dari Indonesia Ataupun Vietnam";
            return result;
        }

    }






}
