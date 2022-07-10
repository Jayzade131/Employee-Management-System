import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connnect {
	static Connection BuildConnection() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver resistered");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Schooldb","root","abc123");
		System.out.println("connected");
		return con;	
	}	
	}

