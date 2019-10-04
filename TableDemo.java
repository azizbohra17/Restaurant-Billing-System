import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
public class TableDemo extends javax.swing.JFrame
{
	public static void main(String args[])
	{
		String col[] = {"Unique ID","Food Item","Rate"};
		JFrame f = new JFrame("Menu");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		JTable table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String id="",fd="",rate="";
		try
		{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\Database\\Restaurant.accdb");
		System.out.println("driver done");
		st = con.createStatement();
		System.out.println("statement done");
		rs = st.executeQuery("SELECT * FROM Menu");
		System.out.println("done");
		while (rs.next())
		{
			id = rs.getString("Unique_Id");
			fd = rs.getString("Food_Item");
			rate = rs.getString("Price");
			model.addRow(new Object[] {id,fd,rate});			
		}
		}
	 catch(Exception e)
		{
		 System.out.println(e);
		}
	  f.add(scroll);
	  f.setVisible(true);
	  f.setSize(1920,1000);
	}
}
