package org.HitungGaji.Entity;


import java.util.List;

public class EmployeeData {


    private EmployeeDAO employeeDAO;
    private List<KomponenGajiDAO> komponenGajiDAO;

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<KomponenGajiDAO> getKomponenGajiDAO() {
        return komponenGajiDAO;
    }

    public void setKomponenGajiDAO(List<KomponenGajiDAO> komponenGajiDAO) {
        this.komponenGajiDAO = komponenGajiDAO;
    }
}
