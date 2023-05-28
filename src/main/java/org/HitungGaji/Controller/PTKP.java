package org.HitungGaji.Controller;

public class PTKP {

    public double PTKPIndonesia(String martial, int childs){
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
    public double PTKPVietnam(String status){
        double ptkp=0;

        if (status.equalsIgnoreCase("single")) {

            ptkp=15000000;
        }else{
            ptkp=30000000;
        }
        return ptkp;
    }
}
