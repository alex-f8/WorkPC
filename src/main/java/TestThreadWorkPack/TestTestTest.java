package TestThreadWorkPack;
//import jdk.swing.interop.SwingInterOpUtils;

//import java.lang.InterruptedException;
//import java.lang.Thread;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestTestTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
/*
        int i = 0;
        while(i <=20){
            System.out.printf("%d ", i);
            try{
                i++;
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
*/
  //      System.out.println();
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password =  "123";
        String sqlQuery = "select * from tickets where passenger_name like 'VALENTINA%'";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement sttm = con.createStatement();
        ResultSet resultSet = sttm.executeQuery(sqlQuery);
        while(resultSet.next()){
            String ticketNo = resultSet.getString(1);
            String bookRef = resultSet.getString(2);
            String ticketID = resultSet.getString(3);
            String name = resultSet.getString(4);
            String personalData = resultSet.getString(5);
            System.out.printf("%s %s \n", name, personalData);
        }
        sttm.close();
        con.close();

    }
}
