
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Admin;
import Model.Kasir;
import Model.Pelayan;
import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kelompok 8
 */
public class CRUDUser {
    // private String sql;

    public Connection koneksi() throws SQLException {
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/dbRestoMenu";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public void Select() throws SQLException {
        //kirim query
        Statement st = koneksi().createStatement();
        String sqlSelect = "select * from user";
        //execute query   //ectract data dari resultset
        ResultSet rs = st.executeQuery(sqlSelect);
        while (rs.next()) {
            System.out.println("Username : " + rs.getString("Username"));
            System.out.println("  Password : " + rs.getString("Password"));

        }
    }

    public void Insert(Admin a) throws SQLException {
        String sqlInsert = "Insert into user values(?,?,?,?)";
        PreparedStatement pst = koneksi().prepareStatement(sqlInsert);
        pst.setString(1, a.getUsername());
        pst.setString(2, a.getPassword());
        pst.setString(3, a.getJabatan());
        pst.setDouble(4, a.getGaji());
        pst.executeUpdate();
    }

    public void Insert(Kasir k) throws SQLException {
        String sqlInsert = "Insert into user values(?,?,?,?)";
        PreparedStatement pst = koneksi().prepareStatement(sqlInsert);
        pst.setString(1, k.getUsername());
        pst.setString(2, k.getPassword());
        pst.setString(3, k.getJabatan());
        pst.setDouble(4, k.getGaji());
        pst.executeUpdate();
    }

    public void Insert(Pelayan p) throws SQLException {
        String sqlInsert = "Insert into user values(?,?,?,?)";
        PreparedStatement pst = koneksi().prepareStatement(sqlInsert);
        pst.setString(1, p.getUsername());
        pst.setString(2, p.getPassword());
        pst.setString(3, p.getJabatan());
        pst.setDouble(4, p.getGaji());
        pst.executeUpdate();
    }

    public void Update(String us, String ps) throws SQLException {
        String sql = " Update user set password=? where username = ? ";
        PreparedStatement pst = koneksi().prepareStatement(sql);
        pst.setString(1, ps);
        pst.setString(2, us);
        pst.executeUpdate();
    }

    public void Delete(Admin a) throws SQLException {
        String sqlDelete = "delete from user where Username=?";
        PreparedStatement pst = koneksi().prepareStatement(sqlDelete);
        pst.setString(1, a.getUsername());
        pst.executeUpdate();
    }

    public void Delete(Pelayan p) throws SQLException {
        String sqlDelete = "delete from user where Username=?";
        PreparedStatement pst = koneksi().prepareStatement(sqlDelete);
        pst.setString(1, p.getUsername());
        pst.executeUpdate();
    }

    public void Delete(Kasir k) throws SQLException {
        String sqlDelete = "delete from user where Username=?";
        PreparedStatement pst = koneksi().prepareStatement(sqlDelete);
        pst.setString(1, k.getUsername());
        pst.executeUpdate();
    }

    public String ambilKPterbesar() throws SQLException {
        Statement st = koneksi().createStatement();
        String sql = "Select max(KodePegawai) as maks from User";
        ResultSet rs = st.executeQuery(sql);

        rs.next();
        return rs.getString("maks");
    }

}
