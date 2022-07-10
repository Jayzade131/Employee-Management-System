import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
private String name1;
private String city1;

   public void setName(String name2)
   {
	   name1=name2;
   }
   public String getName()
   {
	  return name1; 
   }
   public void setCity(String city2)
   {
	   city1=city2;
   }
   public String getCity()
   {
	return city1;
   }
   

   static Search searchData(int roll) throws ClassNotFoundException, SQLException
   {
	   Connection con=Connnect.BuildConnection();
	   PreparedStatement ps=con.prepareStatement("SELECT * FROM Schooldb.info WHERE rollno=?");
	   ps.setInt(1, roll);
	   ResultSet rs=ps.executeQuery();
	   Search se=new Search();
	   while(rs.next())
	   {
		   se.setName(rs.getString(2));
		   se.setCity(rs.getString(3));
	   } 
	   return se;
   }
}