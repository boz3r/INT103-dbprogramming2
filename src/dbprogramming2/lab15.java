package dbprogramming2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dol
 */
public class lab15 {

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
            ResultSet rs = sm.executeQuery("select * from mydb2.student");
            ResultSetMetaData rsm = rs.getMetaData();

            for (int i = 1; i <= rsm.getColumnCount(); i++) {
                System.out.printf("%-12s\t", rsm.getColumnName(i));
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    System.out.printf("%-12s\t", rs.getObject(i));
                }
                System.out.println();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
