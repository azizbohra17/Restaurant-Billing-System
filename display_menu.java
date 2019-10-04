package my_mini_project;
import java.awt.FlowLayout;
import java.awt.Label;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import java.util.*;
//import net.proteanit.sql.DbUtils;
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
			Vector mcard=new Vector();
			
			while (result.next())
			{
				System.out.println(result.getString(4)+"\t"+result.getString(1)+"\t"+result.getInt(2));
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	public void search(String u,String p)
	{   JFrame log=new JFrame();
		Connection con= null;
		Statement statement =null;
		ResultSet result=null;
		String checkusr="",checkpword="";
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\Database\\Restaurant.accdb");
			statement = con.createStatement();
			System.out.println("Driver and Database Connected");
			result = statement.executeQuery("SELECT * FROM User");
			System.out.println("Table Connected");
			while (result.next())
			{
				checkusr=result.getString("user_name");
				checkpword=result.getString("password");
				if(checkusr.equals(u)&&checkpword.equals(p))
				{
					login lo=new login();
					JDialog d1=new JDialog(log,"Validation",true); 
					d1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					d1.setLayout(new FlowLayout());
					Label l3=new Label("Successfully Logged in");
					d1.add(l3);
					d1.setSize(200, 300);
					JButton b1=new JButton("Next");
					b1.addMouseListener(lo);
					d1.add(b1);
					d1.setVisible(true);
					TableDemo tb=new TableDemo();
					tb.tabmenu();
					test ob=new test();
					ob.confirm_bill();
					break;
				}
				else
				{
					
					checkpword="NULL";
				}
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
}
