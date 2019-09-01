package UserManagement;

import java.sql.*;

public class JDBCConnections {
    static String JDBC_DRIVER;  
    static String DB_URL;
    static String DB_URL2;
    
    static String USER;
    static String PASS;
    
    Connection conn;
    Statement stmt;
    public ResultSet rs;
    
    public JDBCConnections(String query,String databaseName)
    {
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/userdetails?zeroDateTimeBehavior=convertToNull";
        DB_URL2 = "jdbc:mysql://localhost:3306/hoteldetails?zeroDateTimeBehavior=convertToNull";
        USER = "Shubham";
        PASS = "qwerty123#";
        conn = null;
        stmt = null;
        if(databaseName.equals("userdetails"))
        {
            System.out.println("Data") ;
            try{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(query);
            }
            catch(Exception e)
            {
                System.out.println(e);
                
            }
        }
        else if(databaseName.equals("hoteldetails"))
        {
            try{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL2,USER,PASS);
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(query);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[])
    {
    }
}
 
