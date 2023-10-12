import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Loginmain extends JFrame  implements MouseMotionListener,MouseListener
{
	JLabel l1,l2,l3;
	JTextField td1,td2,td3,td4;


	public Loginmain()
	{
		setLayout(null);
		//***********************************************************************


		l1=new JLabel("Admin Login");
		l2=new JLabel("User Login");
		l3=new JLabel("Hardware Management System");

		td1=new JTextField();
		td2=new JTextField();
		td3=new JTextField();
		td4=new JTextField();

		l1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 15));
		l2.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 15));
		l3.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 30));


		l1.setForeground(Color.BLUE);
		l2.setForeground(Color.BLUE);

		l1.setBounds(650,300,100,30);
		l2.setBounds(660,350,100,30);
		l3.setBounds(500,20,500,30);
		td1.setBounds(0,60,1500,1);
		td2.setBounds(0,660,1500,1);
		td3.setBounds(200,60,1,600);
		td4.setBounds(1150,60,1,600);


		td1.setBackground(Color.BLACK);
		td2.setBackground(Color.BLACK);
		td3.setBackground(Color.BLACK);
		td4.setBackground(Color.BLACK);


		add(td1);
		add(td2);
		add(td3);
		add(td4);

		add(l1);
		add(l2);
		add(l3);

		setVisible(true);
		setSize(3000,3000);
		l1.addMouseMotionListener(this);
		l1.addMouseListener(this);
		l2.addMouseMotionListener(this);
		l2.addMouseListener(this);





	}
public void mouseClicked(MouseEvent e)
	{

		JLabel L = (JLabel)e.getSource();
		if (l1 == L)
		{
			new LoginAdmin();
		}

		if (l2 == L)
		{
			new LoginUser();
		}

}



	public void mouseDragged(MouseEvent e)
	{
		//t1.setText(e.getX()+e.getY());
	}

	public void mouseMoved(MouseEvent e)
	{
		//t1.setText(e.getX()+e.getY());
	}

	public void mouseEntered(MouseEvent e)
	{
		//t1.setText(e.getX()+e.getY());
	}

	public void mouseExited(MouseEvent e)
	{
		//t1.setText(e.getX()+e.getY());
	}

	public void mousePressed(MouseEvent e)
	{
		//t1.setText(e.getX()+e.getY());
	}

	public void mouseReleased(MouseEvent e)
	{
		//t1.setText(e.getX()+e.getY());
	}








	public static void main(String args[]) throws Exception
	{
		new Loginmain();
	}

}