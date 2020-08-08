/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.Pajak.a;

/**
 *
 * @author Kelompok 8
 */
public class Bayar implements Pajak {
    
    private double bayar=0;
    Pesanan p = new Pesanan();
  
    @Override
    public double hitungpajak() {
        return bayar*a;
    }
    
      public double hitungharga(int JumlahPesanan) {
        for (int i = 0; i < JumlahPesanan; i++) {
            bayar += p.getListmenu()[i].getHarga();
        }
        return bayar+hitungpajak();
    }

 
}
