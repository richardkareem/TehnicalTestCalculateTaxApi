package org.HitungGaji.Entity;




//@Entity
public class EmployeeDAO {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    private Long id;

    private String name;
    private String sex;
    private String martialStatus;
    private int childs;
    private String country;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public int getChilds() {
        return childs;
    }

    public void setChilds(int childs) {
        this.childs = childs;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
