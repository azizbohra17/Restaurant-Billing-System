//This class is used to store the details of the customer entered in the final bill in the Database
package my_mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class store_data 
{
	public void sdatabase(String name,String cn,int s)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\Database\\Restaurant.accdb");
			st = con.createStatement();
			st.executeUpdate("insert into  Details (accname,contact,total) values('"+name+"','"+cn+"','"+s+"')"); //updating database
			System.out.println("Database Updated");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
