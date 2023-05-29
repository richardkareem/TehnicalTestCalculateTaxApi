package org.HitungGaji.Controller;

import org.HitungGaji.Entity.EmployeeData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTaxController {
    TaxCountryFactory taxCountryFactory = new TaxCountryFactory();

    @PostMapping("/hitungpajak")
    public String hitungPajakApi(@RequestBody EmployeeData employeeData){

        int childs = employeeData.getEmployeeDAO().getChilds();
        String marital = employeeData.getEmployeeDAO().getMartialStatus();
        String country = employeeData.getEmployeeDAO().getCountry();

        TaxCountry taxCountry = taxCountryFactory.createTaxCalculator(country);
        // Indonesia & Vietnam
        if(taxCountry != null){
            double ptkp = taxCountry.getPTKP(marital, childs);
            double gajiBersihSetahun = taxCountry.calculateSallary(employeeData) - ptkp;
            double calculateSallary = taxCountry.calculateTax(gajiBersihSetahun);
            // Currency Format
            return String.valueOf(taxCountry.formatCurrency(calculateSallary));
        }
        //If Country Not Present
        return "Negara Tidak Terdaftar";
    }
}
