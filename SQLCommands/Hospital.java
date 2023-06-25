package SQLCommands;

import java.sql.*;
import java.util.ArrayList;

public class Hospital {
    private int id;
    private String name;
    private String tcno;
    private String password;
    private String type;

    public Hospital(int id, String name, String tcno, String password, String type) {
        this.id = id;
        this.name = name;
        this.tcno = tcno;
        this.password = password;
        this.type = type;
    }
    public Hospital(){  }

    public static void deleteData() throws SQLException {
        DBHelper helper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet ;

        try{
            connection = helper.getConnection();
            String sql_query = "DELETE FROM user WHERE id = ? ";

            statement = connection.prepareStatement(sql_query);
            statement.setInt(1,15);
            statement.executeUpdate();
            System.out.println("Kayıt Silindi");

        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }finally {
            connection.close();
            statement.close();
        }
    }
    public static void updateData() throws SQLException {
        DBHelper helper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet ;

        try{
            connection = helper.getConnection();
            String sql_query = "UPDATE user SET tcno = ?, name = ?, password=? WHERE id = ?  ";

            statement = connection.prepareStatement(sql_query);

            statement.setString(1,"457803");
            statement.setString(2,"Deniz Karayel");
            statement.setString(3,"Istanbul34");
            statement.setInt(4,1);
            statement.executeUpdate();
            System.out.println("Kayıt Güncellendi");

        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }finally {
            connection.close();
            statement.close();
        }
    }

    public static void addData() throws SQLException{
        DBHelper helper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet ;

        try{
            connection = helper.getConnection(); // baglanti kuruldu
            String sql_query = "INSERT INTO user (id,tcno,password,name,type) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql_query); // gonderilecek sorgu bu baglantiya gidecek. (hospital)
                statement.setInt(1,15); // bunlar soru isareti yerine gelecekler
                statement.setString(2,"1234599");
                statement.setString(3,"abc123");
                statement.setString(4,"Mehmet");
                statement.setString(5,"Doktor");

            statement.executeUpdate();
            System.out.println("Kayıt Eklendi");


        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }finally {
            connection.close();
        }


    }
    public static void selectHospital() throws SQLException {
        ArrayList<Hospital> hospitalList = new ArrayList<>();
        DBHelper helper = new DBHelper();
        Connection connection = null;
        Statement statement = null; // statement = cumlecik,ifade. Bununla biz sql cumlecigimizle islemleri yapacagiz.
        ResultSet resultSet ;  // resultSet= sonuclar toplulugu. Sorgunun sonucunda gelen datalari javada, resultSet olarak karsilanir.

        Hospital obj ;
        try{
            connection = helper.getConnection(); // baglanti kuruldu
            statement = connection.createStatement(); // gonderilecek sorgu bu baglantiya gidecek. (hospital)
            resultSet = statement.executeQuery("SELECT * FROM user WHERE type = 'doktor' "); //bu ifadeyi(statement) execute edip calistiracak ve bunu resultSet'e atayacak.

            //resultSetteki datalari yazdirmak icin asagidaki kodlar gereklidir.
            while(resultSet.next()){ // next() geziyor.
                obj = new Hospital(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("tcno"),resultSet.getString("password"),resultSet.getString("type"));
                hospitalList.add(obj);  // datalarimizi arrayListe atadik
            }
            System.out.println("TOPLAM VERI : "+hospitalList.size()); // verilerimin sayisini kontrol ettim
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }finally {
            connection.close();
        }
        for(int i=0 ; i<hospitalList.size(); i++){
            System.out.print(hospitalList.get(i).getId());
            System.out.print(" "+hospitalList.get(i).getName());
            System.out.print(" "+hospitalList.get(i).getPassword());
            System.out.print(" "+hospitalList.get(i).getTcno());
            System.out.println(" "+hospitalList.get(i).getType());
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
