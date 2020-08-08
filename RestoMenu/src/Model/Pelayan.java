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
public class Pelayan extends User implements Pajak{
   public Pelayan(){
   }
   public Pelayan(String username, String password, String Jabatan){
       this.username=username;
       this.password=password;
       this.Jabatan=Jabatan="Pelayan";
    }
 
   public Pelayan(String password){
      this.password=password;
  }  

   
    @Override
    public double hitungpajak() {
    return 2000000*b;  
    }
    @Override
    public double hitungGaji() {
        return 2000000-hitungpajak();
    }


}
