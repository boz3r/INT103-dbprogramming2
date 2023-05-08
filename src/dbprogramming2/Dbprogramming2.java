package dbprogramming2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author dol
 */
public class Dbprogramming2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8889";
        String usr = "root";
        String paswd = "root";
        try {
            /*
                Load mysql driver.
            */
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded...");
            
            /*
                Connect to DB Server.
            */
            Connection conn = DriverManager.getConnection(url, usr, paswd);
            System.out.println("Database Connected...");
            
            /*
                Create SQL Statement.
            */
            Statement sm = conn.createStatement();
            sm.execute("UPDATE course SET numOfCredits= 3 WHERE CourseId= 11111");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
