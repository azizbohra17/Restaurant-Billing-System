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
	
	public void label_display(int n,String f1[])
	{
		jp.setLayout(new GridLayout());
		int n1=n;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String af1[]=new String[n];
		af1 = f1;
		String ui="";
		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\Database\\Restaurant.accdb");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Menu");			
			while(rs.next())
			{
				for(int i=0;i<n1;i++)
				{
					ui=rs.getString("Unique_Id");
					if(ui.equals(f1[i]))
						{
							Label l=new Label(rs.getString("Food_Item")+rs.getInt("Price"));
							jp.add(l);
						}
				}
		    }
			Label l1=new Label("Name");
			Label l2=new Label("Contact");
			TextField name=new TextField(15);
			TextField contact=new TextField(20);
			JButton edit=new JButton("Edit");
			JButton ok=new JButton("OK");
			fbill.add(jp);
			fbill.show();
			edit.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					
				}
			});
			ok.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					String na=name.getText();
					int n2=Integer.parseInt(contact.getText());
				}
				
			});
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}


}
