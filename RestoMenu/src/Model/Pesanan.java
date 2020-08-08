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
public class Pesanan {

    private Menu listmenu[]; //agregasi
    private int NoMeja;
    private String NoPesan;
    private String Tgl;
    private int JumlahPesanan;
    private String Status;
    private Bayar B;

    public Pesanan(int jm) {
        B = new Bayar();
    }

    public Bayar getB() {
        return B;
    }

    public Pesanan() {
        listmenu = new Menu[100];
        JumlahPesanan = 0;
    }

    public void tambah(Menu m) {

        listmenu[JumlahPesanan] = m;
        JumlahPesanan++;
    }

    public Menu[] getListmenu() {
        return listmenu;
    }

    public int getNoMeja() {
        return NoMeja;
    }

    public void setNoMeja(int NoMeja) {
        this.NoMeja = NoMeja;
    }

    public String getTgl() {
        return Tgl;
    }

    public void setTgl(String Tgl) {
        this.Tgl = Tgl;
    }

    public String getNoPesan() {
        return NoPesan;
    }

    public void setNoPesan(String NoPesan) {
        this.NoPesan = NoPesan;
    }

    public int getJumlahPesanan() {
        return JumlahPesanan;
    }

    public void setJumlahPesanan(int JumlahPesanan) {
        this.JumlahPesanan = JumlahPesanan;

    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
