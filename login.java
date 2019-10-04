package my_mini_project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class login extends Frame implements ActionListener, MouseListener
{
	TextField usrn,pword;                                      //objects created for TextField
	Label l1,l2;											//objects created for Label
	JFrame log=new JFrame("Login Page");						//main frame and object created
	public void lg()
	{	
		log.setSize(500, 300);
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when clicked on cross all the frames will be closed
		JPanel panel=new JPanel();								//panel created where textfields and labels will be added
		panel.setLayout(new FlowLayout());                   //declared layout
		l1=new Label("Username");
		l2=new Label("Password");
		usrn=new TextField(15);
		pword=new TextField(20);
		pword.setEchoChar('$');                   //echo character displays the particular character instead of the string typed by the user
		panel.add(l1);panel.add(usrn);     // label and textfield added to the panel
		panel.add(l2);panel.add(pword);
		JButton b=new JButton("Login");    //button created
		panel.add(b);
		b.setBounds(220,270, 200, 225);
		log.add(panel);                    //panel added to the frame
		log.show();
		b.addActionListener(this);	    //action listener is used when user hits the button you have created
	}
	public void actionPerformed(ActionEvent e) //in actionperformed you need to write the program for what should happen when user hits the button 
	{	
		String user=usrn.getText();
		String pw=pword.getText();
		display_menu disp=new display_menu();
		disp.search(user,pw);	
		
	}
	public void mouseReleased(MouseEvent e)   
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseExited(MouseEvent e)
	{
		
	}
	public void mousePressed(MouseEvent e)
	{

	}
}

