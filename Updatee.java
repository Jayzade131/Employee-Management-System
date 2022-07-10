import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updatee {

	static int updateData(int roll1,String name1,String city1) throws ClassNotFoundException, SQLException{
	
		Connection con=Connnect.BuildConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE Schooldb.info set name=? , city=? where rollno=? ");
		ps.setString(1,name1);
		ps.setString(2, city1);
		ps.setInt(3, roll1);
		int a=ps.executeUpdate();
		con.close();
		return a;
		
		
	}
}
