package org.HitungGaji.Controller;

public class TaxCountryFactory {
    public TaxCountry createTaxCalculator(String country){
     if(country.equalsIgnoreCase("Indonesia")){
         return new CountryIndonesia();
     }else if(country.equalsIgnoreCase("Vietnam")){
         return new CountryVietnam();
     }else{
         return null;
     }
    }

}
