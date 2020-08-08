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
public class Admin extends User {
    public Admin(){
        
    }

    public Admin(String username, String password,String Jabatan){
       this.username=username;
       this.password=password;
       this.Jabatan=Jabatan="Admin";
    }

    @Override
    public double hitungGaji() {
       return 3000000;
    }  
  
}
