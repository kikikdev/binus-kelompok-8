/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Pesanan;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kelompok 8
 */
public class CRUDBayar {

    public Connection koneksi() throws SQLException {
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/dbRestoMenu";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

     public void Insert(Pesanan ps) throws SQLException {
        String sqlInsert = "Insert into Bayar values(?,?)";
        PreparedStatement pst = koneksi().prepareStatement(sqlInsert);
        for (int i = 0; i < ps.getJumlahPesanan(); i++) {
            pst.setString(1, ps.getNoPesan());
            pst.setString(2, ps.getListmenu()[i].getKodeMenu());
           // pst.setDouble(3, ps.getListmenu()[i].getHarga());
        }
        //pst.executeUpdate();
        pst.addBatch();
        pst.executeBatch();
    }
   

    public void Select(Pesanan p) throws SQLException {
        Statement st = koneksi().createStatement();
        String sql = "Select * from Bayar";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println("No Pesanan : " + rs.getString("NoPesanan"));
            System.out.println("Kode Menu : " + rs.getString("KodeMenu"));

        }
    }

    /* public void SelectBayar(Pesanan p) throws SQLException {
     Statement st = koneksi().createStatement();
     String sql = "Select totbayar from Bayar where NoPesanan = '" + p.getNoPesan() + "'";
     ResultSet rs = st.executeQuery(sql);
     while (rs.next()) {
     System.out.println("No Pesanan : " + rs.getString("NoPesanan"));
     /  System.out.println("total Bayar : " + rs.getDouble("totbayar"));
     }
     }*/
}
