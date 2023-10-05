
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

    private Connection connection;

    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver//localhost:1433;databasename=ConnectToJava;"
                    + "username=sa;password=Tra#11a12");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Them noi dung vao trong bang cua dataBase
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO Students(ID, name, dob, address, phone, email, mark) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getID());
            ps.setString(2, s.getName());
            ps.setDate(3, new Date(s.getDob().getTime()));
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getEmail());
            ps.setFloat(7, s.getMark());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
        
    }
    
    //Doc du lieu tu bang 
    public ArrayList<Student> getListStudent(){
        ArrayList<Student> list = new ArrayList<Student>();
        String sql = "SELECT * from Students";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Student s = new Student();
                s.setID(rs.getString("ID"));
                s.setName(rs.getString("name"));
                //[...];
                list.add(s); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        new DAO();
    }
}
