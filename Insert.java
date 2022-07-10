import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
 static int insertdata(int roll,String name,String city) throws SQLException, ClassNotFoundException
 {  
	 Connection con=Connnect.BuildConnection();
	 PreparedStatement ps=con.prepareStatement("insert into Schooldb.info values (?,?,?)");
	 ps.setInt(1, roll);
	 ps.setString(2, name);
	 ps.setString(3, city);
	 int a=ps.executeUpdate();
	con.close();
	return a;
 }
}