package dbprogramming2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author dol
 */
public class lab8 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8889/mydb2";
        String usr = "root";
        String paswd = "root";
        try {
            /*
                Load mysql driver.
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded.");

            /*
                Connect to DB Server.
             */
            Connection conn = DriverManager.getConnection(url, usr, paswd);
            System.out.println("Database Connected...");

            /*
                Create SQL Statement.
             */
            Statement sm = conn.createStatement();
            ResultSet resultSet = sm.executeQuery("select * from mydb2.student");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getString(3)
                        + " " + resultSet.getString(4)
                        + " " + resultSet.getString(5));

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
