//Final Bill frame 
package my_mini_project;
import java.awt.*;
import java.applet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.*;
import javax.swing.*;
public class display_bill extends Frame 
{
	JFrame fbill=new JFrame("Final Bill");
	JPanel jp=new JPanel();
	
	public void label_display(int n,String f1[],int s,int p[])
	{
		fbill.setSize(800,800);
		jp.setLayout(new FlowLayout());
		int n1=n;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String af1[]=new String[n];
		af1 = f1;
		int sum=s;
		int p1[]=new int[n];
		p1=p;
		String ui="";
		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\Database\\Restaurant.accdb");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Menu");			
			int v=60;
			while(rs.next())
			{
				for(int i=0;i<n1;i++)
				{
					ui=rs.getString("Unique_Id");
					if(ui.equals(f1[i]))           //comparing the unique id of the food item entered and displaying corresponding name and price of the item in the Frame
						{
							Label l=new Label(rs.getString("Food_Item")+" "+rs.getInt("Price")+"\n"); // using JLabel and JPanel to display it on GUI
							JPanel j1=new JPanel();
							j1.add(l);
							jp.add(j1);
						}
				}
		    }
			Label total=new Label("Total = "+sum);
			Label l1=new Label("Name");
			Label l2=new Label("Contact");
			TextField name=new TextField(20);
			TextField contact=new TextField(10);
			JPanel j3=new JPanel();
			JButton ok=new JButton("OK");
			jp.add(total);
			j3.add(l1);j3.add(name);
			j3.add(l2);j3.add(contact);
			jp.add(j3);
			jp.add(ok);
			fbill.add(jp);
			fbill.show();
			
			ok.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					String na=name.getText();
					String cno=contact.getText();
					store_data sd=new store_data(); //Calling store_data class for storing the details in the database
					sd.sdatabase(na, cno,sum);
					fbill.dispose();
				}
				
			});
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}


}
