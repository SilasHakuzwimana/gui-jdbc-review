
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in); 
      System.out.println("Enter ID");
      int id=sc.nextInt();
      System.out.println("Enter FN"); 
      String firstname=sc.nextLine();
      firstname=sc.nextLine();
      System.out.println("Enter LN");
      String lastname=sc.nextLine();
      System.out.println("Enter Gender");
      String gender=sc.nextLine();
      
      
      Register reg=new Register();
      reg.insert(id, firstname, lastname, gender);
      reg.getData();
    }
  public long insert(int id,String firstname,String lastname,String gender){
      long output=0;
      try{
        Connection conn=null;
        Connector connector=new Connector();
        conn=connector.getConnection();
        PreparedStatement ps=null;
        String query="INSERT INTO `students`(`id`, `firstname`, `lastname`, `gender`) "
                + "                   VALUES(?,?,?,?)";
        ps=conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, firstname);
        ps.setString(3, lastname);
        ps.setString(4, gender);
        output=ps.executeUpdate();
        if(output>0){
            System.out.println("User Successfully Added!!!!");
        }
        conn.close();
      }catch(SQLException e){
       e.printStackTrace();
      } 
      return output;
  } 
  
  public void getData(){
    try{
        Connector connect=new Connector();
        Connection conn=null;
        conn=connect.getConnection();
        PreparedStatement ps=null;
        ps=conn.prepareStatement("select id,firstname,lastname,gender from students");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
          int id=rs.getInt("id");
          String fn=rs.getString("firstname");
          String ln=rs.getString("lastname");
          String gender=rs.getString("gender");
          System.out.println("Id:"+id+"\tFirstname:"+fn+"\tLastname:"+ln+"\tGender:"+gender);
        }
    }catch(SQLException e){
     e.printStackTrace();
    }
    
  
  }
}
