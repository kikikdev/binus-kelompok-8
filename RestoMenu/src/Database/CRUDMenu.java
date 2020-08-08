/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Kelompok 8
 */
public class CRUDMenu {

    /**
     *
     * @return @throws SQLException
     */
    public Connection koneksi() throws SQLException {
        // Buka Koneksi// driver
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/dbRestoMenu";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public ResultSet SelectMenu(String KodeMenu) throws SQLException {
        Statement st = koneksi().createStatement();
        String sql = "select * from Menu where Kodemenu = '" + KodeMenu + "'";
        // execute query // extract data dari result set
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public void Select() throws SQLException {
        //kirim query
        Statement st = koneksi().createStatement();
        String sqlSelect = "select * from Menu";
        //execute query   //ectract data dari resultset
        ResultSet rs = st.executeQuery(sqlSelect);
        while (rs.next()) {
            System.out.print("Kode Menu : " + rs.getString("KodeMenu"));
            System.out.print("  Nama Menu : " + rs.getString("NamaMenu"));
            System.out.println("  Harga : " + rs.getDouble("Harga"));

        }
    }

    public void Insert(Menu m) throws SQLException {
        String sqlInsert = "insert into Menu values(?,?,?)";
        PreparedStatement pst = koneksi().prepareStatement(sqlInsert);
        pst.setString(1, m.getKodeMenu());
        pst.setString(2, m.getNamaMenu());
        pst.setDouble(3, m.getHarga());
        pst.executeUpdate();

    }

    public void Update(String kd, String nm, double h) throws SQLException {
        String sql = "Update Menu  set NamaMenu = ?, Harga = ? where kodemenu=?";
        PreparedStatement pst = koneksi().prepareStatement(sql);
        pst.setString(1, nm);
        pst.setDouble(2, h);
        pst.setString(3, kd);
        pst.executeUpdate();

    }

    public void Delete(Menu m) throws SQLException {
        String sql = "delete from Menu where KodeMenu = ?";
        PreparedStatement pst = koneksi().prepareStatement(sql);
        pst.setString(1, m.getKodeMenu());
        pst.executeUpdate();
    }

}
