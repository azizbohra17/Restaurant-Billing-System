//This class is used to add food items through unique code of the same food item
package my_mini_project;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test 
{
	String fd[] = new String[100];
	int i =0;
	public  void confirm_bill()
	{	JFrame conbill=new JFrame("Confirmation");
		test cb=new test();
		add ob = new add();
		conbill.setSize(500,300);
		conbill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelbill=new JPanel();
		panelbill.setLayout(new FlowLayout());
        Label code = new Label("Code of the Food Item");
        TextField foodcode=new TextField(4);
        JButton ad=new JButton("Add");
		JButton finalbill=new JButton("Final Bill");
		//finalbill.setBounds(220,270, 200, 225);
		//finalbill.setVisible(true);
		panelbill.add(code);panelbill.add(foodcode);
		panelbill.add(ad);
		panelbill.add(finalbill);
		
//		JButton edit =new JButton("Edit");
//		//edit.setVisible(true);
//		panelbill.add(edit);
		conbill.add(panelbill);
		conbill.show();
		conbill.setVisible(true);
		conbill.toFront();
		ad.addActionListener(new ActionListener()      //when two or more buttons are there use this method to specify the next task for the particular button
				{ //first button
					public void actionPerformed(ActionEvent e)
					{
						String a = foodcode.getText(); //textfield_object.getText() gives you the string entered by the user in that textfield
											
							fd[i]=a;      //storing the unique code of food items in the array
							i++;
							confirm_bill();
							conbill.dispose();
						
					}
				});
		
	    finalbill.addActionListener(new ActionListener()  
	    {//second button
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		ob.addfood(fd);     //calling the add class for the total amount
	    		conbill.dispose();
	    	}
	    });
		
	    
	}
//	public void actionPerformed(ActionEvent e) 
//	{
//		// TODO Auto-generated method stub
//		
//	}

//@Override
//public void actionPerformed(ActionEvent e) {
//	// TODO Auto-generated method stub
//	
//}

}
