package org.HitungGaji.Entity;


//@Entity
public class KomponenGajiDAO {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    private long id;
    private String name;
    private String type;
    private double amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
