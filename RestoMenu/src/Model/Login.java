package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login {

    public Connection koneksi() throws SQLException {
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/dbRestoMenu";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public String checkLogin(String user,String pass) throws SQLException {
        //kirim query
        Statement st = koneksi().createStatement();
        String sql = "select Jabatan from user where username='"+user+"' and password= '"+pass+"' ";
        // execute query // extract data dari result set
        ResultSet rs = st.executeQuery(sql);

        if(rs.next()) {
            return rs.getString("Jabatan");
        }
        return "";
    }
}