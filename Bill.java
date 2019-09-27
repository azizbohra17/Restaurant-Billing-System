import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bill extends Frame implements ActionListener
{
	
	public  void confirm_bill()
	{	JFrame conbill=new JFrame("Confirmation");
		Bill cb=new Bill();
		conbill.setSize(500,300);
		conbill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelbill=new JPanel();
		panelbill.setLayout(new FlowLayout());
        Label l1 = new Label("Test");
		JButton finalbill=new JButton("Final Bill");
		//finalbill.setBounds(220,270, 200, 225);
		//finalbill.setVisible(true);
		panelbill.add(l1);
		panelbill.add(finalbill);
		JButton edit =new JButton("Edit");
		//edit.setVisible(true);
		panelbill.add(edit);
		conbill.add(panelbill);
		conbill.show();
		conbill.setVisible(true);
		conbill.toFront();
//	    finalbill.addActionListener(this);
//	    b1.addActionlistener(this);
		//finalbill.addMouseListener(cb);
	}
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
//	public void mouseReleased(MouseEvent e)
//	{
//		
//	}
//	public void mouseEntered(MouseEvent e)
//	{
//		
//	}
//	public void mouseClicked(MouseEvent e)
//	{
//		
//	}
//	public void mouseExited(MouseEvent e)
//	{
//		
//	}
//	public void mousePressed(MouseEvent e)
//	{
//		
//	}
	
}
