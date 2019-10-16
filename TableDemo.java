//This class is used to Display the menu in the form of table
//JTable is used 
package my_mini_project;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
public class TableDemo extends Frame
{
 public static void tabmenu()
		 {
	       String colna[] = {"Unique ID","Food Item","Rate"};
	       JFrame f = new JFrame("Menu");
	       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       f.setLayout(new BorderLayout());
	       DefaultTableModel model = new DefaultTableModel();
	       model.setColumnIdentifiers(colna);
	       JPanel panelbill=new JPanel();
			panelbill.setLayout(new FlowLayout());
	        Label code = new Label("Code of the Food Item");
	        TextField foodcode=new TextField(4);
	        JButton ad=new JButton("Add");
			JButton finalbill=new JButton("Final Bill");
	       JTable table = new JTable();
	       table.setModel(model);
	       table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	       table.setFillsViewportHeight(true);
	       JScrollPane scroll = new JScrollPane(table);
	       scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	       scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	       
	        Connection con = null;
	        Statement statement = null;
	        ResultSet result = null;	      
	        String ui="",fd="";int rate;
	        try
	        {
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            con = DriverManager.getConnection("jdbc:ucanaccess://D:\\\\java\\\\Database\\\\Restaurant.accdb");
	            statement = con.createStatement();
	            result = statement.executeQuery("SELECT * FROM Menu");
	            while(result.next())
	            {	              
	              ui = result.getString("Unique_Id");
	              fd = result.getString("Food_Item");
	              rate = result.getInt("Price");
	              model.addRow(new Object[] {ui,fd,rate});	  // adding new rows of the menu in the table            
	            }
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	        f.add(panelbill);
			f.show();
			f.setVisible(true);
			f.toFront();
	        f.add(scroll);
	        f.setVisible(true);
	        f.setSize(1080,1080);
		 }
}
