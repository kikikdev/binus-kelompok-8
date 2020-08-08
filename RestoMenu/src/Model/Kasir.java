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
public class Kasir extends User implements Pajak {

    public Kasir() {

    }

    public Kasir(String username, String password, String Jabatan) {
        this.username = username;
        this.password = password;
        this.Jabatan = Jabatan = "Kasir";
    }

    @Override
    public double hitungpajak() {
        return 2500000 * b;
    }

    @Override
    public double hitungGaji() {
        return 2500000-hitungpajak();
    }

}
