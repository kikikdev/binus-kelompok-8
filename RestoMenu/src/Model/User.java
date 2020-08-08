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
public abstract class User {

    protected String username;
    protected String password;
    protected String Jabatan;
    protected Double gaji;


    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public abstract double hitungGaji();

    public void setGaji(Double gaji) {
        this.gaji = hitungGaji();
    }

    public Double getGaji() {
        return gaji;
    }

}
