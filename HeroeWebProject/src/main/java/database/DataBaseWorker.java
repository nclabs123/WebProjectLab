package database;

import java.sql.*;

public class DataBaseWorker {



    private static final String URL = "jdbc:mysql://localhost:3306/heroesdb?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    private String url;
    private String query;

    private String tableName;

    private Connection connection;
    private Statement statment;
    private ResultSet rs;


    public DataBaseWorker() {

        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }

        catch (SQLException e){
            e.printStackTrace();
        }

        this.tableName="heroes";
    }

    public DataBaseWorker (String url) {

        this.url = url;


        try {
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public DataBaseWorker (String url, String tableName) {

        this.url = url;

        try {
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

        }

        catch (SQLException e){
            e.printStackTrace();
        }

        this.tableName = tableName;
    }

    public String getUrl () {
        return url;
    }

    public String getQuery () {
        return query;
    }

    public String getTableName () {
        return tableName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setQuery (String query) {
        this.query = query;
    }

    public void setTableName (String tableName) {
        this.tableName = tableName;
    }


    public void insert (String tableName, String nameVal, String universeVal, int powerVal) {

        query = "insert into "+tableName+" (name, universe, power) values ("
                +"\""+nameVal+"\""+','
                +"\""+universeVal+"\""+','
                +"\""+powerVal+"\""+")";

        System.out.println(query);
        try {
            statment = connection.createStatement();
            statment.executeUpdate(query);
            statment.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update (String tableName, int id, String nameVal, String universeVal, int powerVal) {
        query = "update "+tableName
                +" set name = "+"\""+nameVal+"\","
                +" universe = "+"\""+universeVal+"\","
                +" power = "+"\""+powerVal+"\""+ " where id = "+id;

        System.out.println(query);

        try {
            statment = connection.createStatement();
            statment.executeUpdate(query);
            statment.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete (String tableName, int id) {
        query = "DELETE  from "+tableName+" where id = "+id;
        System.out.println(query);
        try {
            statment = connection.createStatement();
            statment.executeUpdate(query);
            statment.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
