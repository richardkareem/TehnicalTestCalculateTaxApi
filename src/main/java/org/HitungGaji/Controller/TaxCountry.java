package org.HitungGaji.Controller;

import org.HitungGaji.Entity.EmployeeData;

public interface TaxCountry {
    double calculateTax(double penghasilanBersih);
    double getPTKP(String martial, int childs);
    double calculateSallary(EmployeeData employeeData);
    String formatCurrency(double result);

}
