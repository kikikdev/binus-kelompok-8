/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restomenu;

import Database.CRUDBayar;
import Database.CRUDMenu;

import Database.CRUDPesanan;
import Database.CRUDUser;
import Model.*;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RestoMenu {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws SQLException {

        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        String resultLogin;
        int pilihan = 0;

        Admin a = new Admin();
        Pelayan p = new Pelayan();
        Kasir k = new Kasir();
        Menu m = new Menu();
        Pesanan ps = new Pesanan();
        CRUDMenu dm = new CRUDMenu();
        CRUDPesanan dp = new CRUDPesanan();
        CRUDUser du = new CRUDUser();
        CRUDBayar db = new CRUDBayar();

        // show login page
        resultLogin = loginPage();

        do {
            switch (resultLogin) {
                case "admin":
                    do {
                        System.out.println("------------------");
                        System.out.println("Menu Admin");
                        System.out.println("------------------");
                        System.out.println("1. Lihat data menu ");
                        System.out.println("2. Tambah data menu ");
                        System.out.println("3. Perbarui data menu");
                        System.out.println("4. Hapus data menu");
                        System.out.println("0. Keluar dari Program");
                        System.out.print("Pilihan Anda : ");
                        pilihan = sc.nextInt();
                        switch (pilihan) {
                            case 1: //select
                                System.out.println("------------------");
                                System.out.println("Menu");
                                System.out.println("------------------");
                                dm.Select();
                                break;
                            case 2: //insert
                                System.out.print("Kode Menu: ");
                                m.setKodeMenu(scString.nextLine());
                                System.out.print("Nama Menu :");
                                m.setNamaMenu(scString.nextLine());
                                System.out.print("Harga :");
                                m.setHarga(sc.nextDouble());
                                dm.Insert(m);
                                break;
                            case 3: //update
                                dm.Select();
                                System.out.print("Kode menu yang akan di update: ");
                                m.setKodeMenu(scString.nextLine());
                                System.out.print("Nama Menu :");
                                m.setNamaMenu(scString.nextLine());
                                System.out.print("Harga:");
                                m.setHarga(sc.nextDouble());
                                dm.Update(m.getKodeMenu(), m.getNamaMenu(), m.getHarga());
                                break;
                            case 4: //delete
                                dm.Select();
                                System.out.print("Kode menu yang akan di hapus: ");
                                m.setKodeMenu(scString.nextLine());
                                dm.Delete(m);
                                break;
                            case 0:
                                break;
                        }
                    } while (pilihan != 0);
                    break;

                case "pelayan":
                    do {
                        System.out.println("------------------");
                        System.out.println("Menu Pelayan");
                        System.out.println("------------------");
                        System.out.println("1. Lihat data menu  ");
                        System.out.println("2. Tambah data Pesanan ");
                        System.out.println("0. Keluar dari Program");
                        System.out.print("Pilihan Anda : ");
                        pilihan = sc.nextInt();
                        switch (pilihan) {
                            case 1: //select
                                System.out.println("------------------");
                                System.out.println("Menu");
                                System.out.println("------------------");
                                dm.Select();
                                break;
                            case 2: //insert
                                int NoPesananInt;
                                int pil = 0;
                                int j = 0;

                                System.out.print("Nomor Meja :");
                                ps.setNoMeja(sc.nextInt());
                                ps.setStatus("belumbayar");
                                String Nopes = dp.ambilnopeasananterbesar();
                                int NoInt = Integer.valueOf(Nopes) + 1;
                                Nopes = String.valueOf(NoInt);
                                ps.setNoPesan(Nopes);
                                do {
                                    dm.Select();
                                    System.out.print("Kode menu yang akan di beli: ");
                                    String km = scString.nextLine();
                                    j++;
                                    ps.tambah(m);
                                    m.setKodeMenu(km);
                                    ResultSet rs1 = dm.SelectMenu(km);
                                    ResultSet rs2 = dp.SelectPesan(ps.getNoPesan());
                                    if (rs1.next() == true && rs2.next() == true) {
                                        m.setHarga(rs1.getDouble("Harga"));
                                        ps.setJumlahPesanan(rs2.getInt("JumlahPesanan"));
                                        ps.tambah(m);
                                    }
                                    db.Insert(ps);
                                    System.out.print("Beli lagi ? (1|Y 2|N) ");
                                    pil = sc.nextInt();
                                    if (pil == 2) {
                                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                        Date date = new Date();
                                        ps.setTgl(df.format(date));
                                        ps.setJumlahPesanan(j);
                                        dp.Insert(ps);
                                    }
                                } while (pil != 2);
                                break;
                            case 0:
                                break;
                        }
                    } while (pilihan != 0);
                    break;

                case "kasir":
                    do {
                        System.out.println("------------------");
                        System.out.println("Menu Kasir");
                        System.out.println("------------------");
                        System.out.println("1. Lihat Total Bayar");
                        System.out.println("2. Perbarui data pesanan");
                        System.out.println("0. Keluar dari Program");
                        System.out.print("Pilihan Anda : ");
                        pilihan = sc.nextInt();

                        switch (pilihan) {
                            case 1://select

                                System.out.print("NoPesanan : ");
                                String np = scString.nextLine();
                                dp.SelecetBayar(np);

                                break;
                            case 2: //update
                                System.out.print("No Pesanan yang akan di update: ");
                                ps.setNoPesan(scString.nextLine());
                                System.out.print("Status Pesanan : ");
                                ps.setStatus(scString.nextLine());
                                dp.Update(ps.getNoPesan(), ps.getStatus());
                                break;
                            case 0:
                                break;
                        }
                    } while (pilihan != 0);
                    break;
            }
        } while (resultLogin != "" && pilihan > 0 && pilihan < 5);
    }

    public static String loginPage() throws SQLException{
        // result login return role
        Scanner scString = new Scanner(System.in);
        String username, password;
        String result = "";
        Login login = new Login();

        System.out.println("------------------");
        System.out.println("Login Page");
        System.out.println("------------------");
        System.out.print("Username : ");
        username = scString.nextLine();
        System.out.print("password : ");
        password = scString.nextLine();
        result = login.checkLogin(username, password);
        if(result != ""){
            System.out.println("Selamat Datang "+username);
            return result;
        } else {
            System.out.println("Login gagal, password salah");
            return "";
        }
    }

}
