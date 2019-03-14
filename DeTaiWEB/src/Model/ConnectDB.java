package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lonely
 */
public class ConnectDB {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    protected void hasDriver() throws Exception{ //goi Driver
    	 try {
    	 Class.forName("com.mysql.jdbc.Driver");
    	 } catch (ClassNotFoundException ex) {
    	 throw new Exception ("Invalid Driver!!Please check this drver....");
    	 }
    	 }
    
    protected Connection openConnect() {
        try {
            if (conn == null) {//chua co ket noi
                hasDriver();//goi Driver
                String url = "jdbc:mysql://localhost:3306/danhsachcacmathang?setUnicode=true&characterEncoding=UTF-8";
                 conn = DriverManager.getConnection(url, "root", ""); //tao ket noi toi CSDL voi user va
          
//              String url = "jdbc:mysql://node9874-modelshop.kilatiron.com/danhsachcacmathang?setUnicode=true&characterEncoding=UTF-8";
//                conn = DriverManager.getConnection(url, "root", "VKApza55456");
               //
            }
        } catch (Exception e) {
            System.out.println("Error Connecton! Please check url or username and password of mysql!");
        }
        return conn;
    }

    protected Statement getStatement() {
        try {
            if (stmt == null) {
                stmt = openConnect().createStatement();
            }
        } catch (Exception e) {
            System.out.println("Please check statement");
        }
        return stmt;
    }

    protected void closeConnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (rs != null & !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            System.out.println("Please check close connect, stmt, resutlset");
        }

    }

}