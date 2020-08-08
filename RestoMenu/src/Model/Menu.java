/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Kelompok 8
 */
public class Menu {
    
  
    private String KodeMenu;
    private String NamaMenu;
    private double harga;
    


    public Menu(){
        
    }
    
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga=harga;
    }
 
    public void setKodeMenu(String KodeMenu) {
        this.KodeMenu = KodeMenu;
    }

    public String getKodeMenu() {
        return KodeMenu;
    }

    public void setNamaMenu(String NamaMenu) {
        this.NamaMenu = NamaMenu;
    }

    public String getNamaMenu() {
        return NamaMenu;
    }

    
    
       
    
}
