package dbprogramming2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dol
 */
public class lab11 {
        public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8889/mydb2";
        String usr = "root";
        String paswd = "root";
        try {
            /*
                Load mysql driver.
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, usr, paswd);
            Statement sm = conn.createStatement();
            String sql = "delete from student where studentID='1234'";
            sm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
