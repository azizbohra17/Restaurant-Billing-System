import java.sql.*;
public class MyConnection
{
	Connection con;
	public MyConnection()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\Database\\Restaurant.accdb");
		}
			catch(Exception e)
			{
				System.out.println(e);
			}   
	}
	public Connection returnConnection()
	{
		return con;
	}
}
