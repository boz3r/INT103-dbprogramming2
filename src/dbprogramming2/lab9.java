package dbprogramming2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author dol
 */
public class lab9 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8889/mydb2";
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
            String sql = "insert into student(studentID, firstname, lastname, email, deptID) "
                    + "values('1234', 'phatcharadol', 'thangplub', 'maibok@gmail.com', 'IT')";
            sm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
