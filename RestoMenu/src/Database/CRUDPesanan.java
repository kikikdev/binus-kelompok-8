/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Bayar;
import Model.Pesanan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Kelompok 8
 */
public class CRUDPesanan {

    //private String sql;
    public Connection koneksi() throws SQLException {
        // Buka Koneksi// driver
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/dbRestoMenu";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public ResultSet SelectPesan(String NoPesanan) throws SQLException {
        Statement st = koneksi().createStatement();
        String sql = "select * from Pesanan where NoPesanan = '" + NoPesanan + "'";
        // execute query // extract data dari result set
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public void Insert(Pesanan ps) throws SQLException {
        String sqlInsert = "Insert into pesanan values(?,?,?,?,?)";
        PreparedStatement pst = koneksi().prepareStatement(sqlInsert);
        pst.setString(1, ps.getNoPesan());
        pst.setInt(2, ps.getNoMeja());
        pst.setString(3, ps.getTgl());
        pst.setInt(4, ps.getJumlahPesanan());
        pst.setString(5, ps.getStatus());
        pst.executeUpdate();

    }

    public void Select() throws SQLException {
        //kirim query
        Statement st = koneksi().createStatement();
        String sqlSelect = "select * from Pesanan";
        //execute query   //ectract data dari resultset
        ResultSet rs = st.executeQuery(sqlSelect);
        while (rs.next()) {
            System.out.print("Nomor Pesanan : " + rs.getString("NoPesanan"));
            System.out.print("  Nomor Meja : " + rs.getInt("NoMeja"));
            System.out.print("  Tanggal Pesanan : " + rs.getString("TanggalPesanan"));
            System.out.print("  Jumlah Pesanan : " + rs.getDouble("JumlahPesanan"));
            System.out.print("  Status : " + rs.getString("Status"));

        }
    }

    public void SelecetBayar(String Np) throws SQLException {
        //Statement st = koneksi().createStatement();
        Locale localeID = new Locale("in", "ID");
        String sql = "select SUM(mn.Harga) as Bayar from bayar byr INNER JOIN menu mn ON byr.KodeMenu = mn.KodeMenu where byr.nopesanan = ? ";
        PreparedStatement pst = koneksi().prepareStatement(sql);
        pst.setString(1, Np);
        ResultSet rs = pst.executeQuery();

        NumberFormat format = NumberFormat.getCurrencyInstance(localeID);

        while (rs.next()) {
            System.out.println("Total Bayar = " + format.format(rs.getDouble("Bayar")));
        }
    }

    public void Update(String Np, String s) throws SQLException {
        String sql = "Update pesanan set Status = ? Where NoPesanan = ? ";
        PreparedStatement pst = koneksi().prepareStatement(sql);
        pst.setString(1, s);
        pst.setString(2, Np);
        pst.executeUpdate();

    }

    public String ambilnopeasananterbesar() throws SQLException {

        Statement st = koneksi().createStatement();
        String sql = "Select max(NoPesanan) as maks from Pesanan";
        ResultSet rs = st.executeQuery(sql);

        rs.next();
        return rs.getString("maks");
    }

}
