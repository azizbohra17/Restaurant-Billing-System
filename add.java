package my_mini_project;
import java.sql.*;
import java.util.Vector;
public class add
{
	
	int i=0,sum=0;
	public void addfood(String af[])
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int n = af.length;
		int price[] = new int[n];
		String af1[]=new String[n];
		af1 = af;
		String ui="";
		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\Database\\Restaurant.accdb");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Menu");			
			while(rs.next())
			{
				for(int i=0;i<af.length;i++)
				{
				ui=rs.getString("Unique_Id");
				if(ui.equals(af[i]))     // comparing the unique id of the food items and storing the corresponding price of the same in an array
				{
	              price[i]=rs.getInt("Price");
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			sum=sum+price[i]; //Calculating total amount
		}
		System.out.println(sum);
		display_bill db=new display_bill();  //calling the display_bill class 
		db.label_display(n,af1,sum,price);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
