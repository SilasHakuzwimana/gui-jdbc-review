import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connector {
    String url="jdbc:mysql://localhost:3306/sias";
    String user="root";
    String password="";
    public Connection getConnection(){
      Connection con=null;
      try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(url, user, password);
        System.out.println("Connected!!!!");
      }catch(SQLException ex){
        ex.printStackTrace();
      }catch(ClassNotFoundException ex){
        ex.printStackTrace();
      }   
      return con;
    } 
//    public static void main(String[] args) {
//        Connector con=new Connector();
//        con.getConnection();
//    }
}
