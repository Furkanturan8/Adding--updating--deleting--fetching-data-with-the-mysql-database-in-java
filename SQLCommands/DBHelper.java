package SQLCommands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private String userName = "root";
    private String password = "";
    private String dbURL = "jdbc:mysql://localhost:3306/hospital";
    // genelde dbURL bu sekilde yazilir. son kisimdaki "hospital" ise veritabanindaki tablonun ismidir.
    // Siz olusturdugunuz kendi veritabaniniza gore yaziniz.

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL,userName,password);
    }

    public void showErrorMessage(SQLException exception){
        System.out.println("Error: "+exception.getMessage());
        System.out.println("Error Code: "+exception.getErrorCode());
    }

}
