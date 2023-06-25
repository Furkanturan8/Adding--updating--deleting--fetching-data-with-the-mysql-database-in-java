package SQLCommands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    static Hospital hospital;
    public static void main(String[] args) throws SQLException {
        // *** sql select ifadelerin calistirilmasi ***

         hospital.selectHospital(); // hospital veritabanimizi getirmek icin
        // hospital.addData(); // hospital veritabanina veri eklenir.
        // hospital.updateData();
        // hospital.deleteData();
        //hospital.selectHospital();
    }
}