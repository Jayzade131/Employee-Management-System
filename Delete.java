import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
      static int deleteData(int roll) throws ClassNotFoundException, SQLException
      {
    	  Connection con=Connnect.BuildConnection();
    	  PreparedStatement ps=con.prepareStatement("delete from Schooldb.info where rollno=?");
    	  ps.setInt(1,roll);
    	  int f=ps.executeUpdate();
    	  con.close();
		return f ;
    	  
      }
}
