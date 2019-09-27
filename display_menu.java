import java.sql.*;
public class display_menu 
{
	public static void disp_menu()
	{
		Connection con= null;
		Statement statement =null;
		ResultSet result=null;
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\Database\\Restaurant.accdb");
			statement = con.createStatement();
			result = statement.executeQuery("SELECT * FROM Menu");
			while (result.next())
			{
				System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getInt(3));
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
}
