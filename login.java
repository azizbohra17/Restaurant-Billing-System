import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class login extends Frame implements ActionListener, MouseListener
{
	TextField usrn,pword;
	Label l1,l2;
	JFrame log=new JFrame("Login Page");
	public void lg()
	{	
		log.setSize(500, 300);
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout());
		l1=new Label("Username");
		l2=new Label("Password");
		usrn=new TextField(15);
		pword=new TextField(20);
		pword.setEchoChar('$');
		panel.add(l1);panel.add(usrn);
		panel.add(l2);panel.add(pword);
		JButton b=new JButton("Login");
		panel.add(b);
		b.setBounds(220,270, 200, 225);
		log.add(panel);
		log.show();
		b.addActionListener(this);	
	}
	public void actionPerformed(ActionEvent e)
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
		Bill ob=new Bill();
		ob.confirm_bill();
	}
}
