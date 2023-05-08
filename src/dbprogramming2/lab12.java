package dbprogramming2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dol
 */
public class lab12 {

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
            String sql = "insert into student(studentID, firstname, lastname, email, deptID) "
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "49999");            
            ps.setString(2, "chips");
            ps.setString(3, "slayer");
            ps.setString(4, "netcat@gmail.com");
            ps.setString(5, "IT");
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(lab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
