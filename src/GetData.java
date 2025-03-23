
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class GetData {
    

    public String retrieveStudentData() throws SQLException {
        Connection conn = null;
        Connector connector = new Connector();
        conn = connector.getConnection();
        PreparedStatement ps = null;

        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM students";
        ResultSet rs = stmt.executeQuery(sql);

        try {
            while(rs.next()){
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String gender = rs.getString(4);
                
//                GUI gui = new GUI();
//                gui.addDataTable(id, firstName, lastName, gender);
                System.out.println("\nID: "+id+"\nFirst name: "+firstName +"\nLastname: "+lastName+"\nGender: "+gender);
//                
//                System.out.println("Data: "+ rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        GetData get = new GetData();
        get.retrieveStudentData();
    }
}
