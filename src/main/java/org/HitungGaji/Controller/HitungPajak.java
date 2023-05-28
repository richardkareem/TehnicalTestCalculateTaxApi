package org.HitungGaji.Controller;

public class HitungPajak {
    public double hitungPajakIndo(double penghasilanBersih){
        double hasil = 0;
        double setelahDikurangin = 0;
        double setelahDikuranginLagi = 0;

        if(penghasilanBersih > 50000000){
            setelahDikurangin =  penghasilanBersih - 50000000;
            double pajak1 = 50000000 * 0.05;
            double pajak2 = setelahDikurangin * 0.1;
            return  hasil = pajak1 + pajak2;

        }else if( penghasilanBersih > 250000000 ){
            setelahDikurangin = penghasilanBersih-50000000;
            double pajak1 = 50000000 * 0.05;
            setelahDikuranginLagi = setelahDikurangin-250000000;
            double pajak2 = 250000000 * 0.1;
            double pajak3 = setelahDikuranginLagi * 0.15;
            return hasil =  pajak1 + pajak2 + pajak3;
        }else if(penghasilanBersih < 50000000){
            return  hasil = penghasilanBersih * 0.05;
        }
        return hasil;
    }

    public double hitungPajakVietnam(double penghasilanBersih){
        double hasil = 0;
        double setelahDikurangin = 0;

        if(penghasilanBersih >= 50000000){
            setelahDikurangin = penghasilanBersih - 50000000;
            double pajak1 = 50000000 * 0.025;
            double pajak2 = 0;
            if(setelahDikurangin > 50000000){
                 pajak2 = setelahDikurangin * 0.075;
            }
            hasil = pajak1 + pajak2;
        }
        return hasil;
    }
}
