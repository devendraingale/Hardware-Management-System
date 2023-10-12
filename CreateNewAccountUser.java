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


import java.awt.event.ActionListener;



public class CreateNewAccountUser extends JFrame implements ActionListener,MouseMotionListener,MouseListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;

	JTextField t1,t2,t3,t4,t5,t6,t7,td1,td2,td3,td4,td5;
	JButton b1,b2;
	Connection cn;
	Statement st;
	ResultSet rs;
	JLabel ll1,ll2,ll3,ll4;
	public CreateNewAccountUser()
	{
		setLayout(null);


//**************Quick Links**********************************


				ll1=new JLabel("Login");
				ll2=new JLabel("Create New Account");
				ll3=new JLabel("Forgot Password");
				ll4=new JLabel("Exit");

				ll1.setBounds(30,120,170,50);
				ll2.setBounds(30,180,170,50);
				ll3.setBounds(30,240,170,50);
				ll4.setBounds(30,300,100,50);

				ll1.setFont(new Font("times new roman", Font.BOLD, 18));
				ll2.setFont(new Font("times new roman", Font.BOLD, 18));
				ll3.setFont(new Font("times new roman", Font.BOLD, 18));
				ll4.setFont(new Font("times new roman", Font.BOLD, 20));

				add(ll1);
				add(ll2);
				add(ll3);
				add(ll4);
//***********************************************************************
		l1=new JLabel("Name");
		l2=new JLabel("Date Of Birth");
		l3=new JLabel("Contact");
		l4=new JLabel("E-mail");
		l5=new JLabel("Passward");
		l6=new JLabel("Confirm Password");
		l7=new JLabel("DD/MM/YYYY");
		l8=new JLabel("Already Exist");
		l9=new JLabel("password Does Not Match");
		l10=new JLabel("Create New Account");
		l10.setFont(new Font("times new roman", Font.BOLD, 30));

		td5=new JTextField();
		l11=new JLabel("Quick Links");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		td1=new JTextField();
		td2=new JTextField();
		td3=new JTextField();
		td4=new JTextField();



		b1=new JButton("Submit");
		b2=new JButton("Clear");


		l1.setBounds(500,150,150,30);
		l2.setBounds(500,200,150,30);
		l3.setBounds(500,250,150,30);
		l4.setBounds(500,300,150,30);
		l5.setBounds(500,350,150,30);
		l6.setBounds(500,400,150,30);
		t1.setBounds(620,150,200,30);
		t2.setBounds(620,200,200,30);
		t3.setBounds(620,250,200,30);
		t4.setBounds(620,300,200,30);
		t5.setBounds(620,350,200,30);
		t6.setBounds(620,400,200,30);
		l7.setBounds(680,200,50,30);
		l8.setBounds(650,300,100,30);
		l9.setBounds(680,400,100,30);
		l10.setBounds(550,50,300,30);
		b1.setBounds(540,480,100,30);
		b2.setBounds(700,480,100,30);
		td1.setBounds(0,80,1500,1);
		td2.setBounds(0,660,1500,1);
		td3.setBounds(200,80,1,580);
		td4.setBounds(1150,80,1,580);



		td1.setBackground(Color.BLACK);
		td2.setBackground(Color.BLACK);
		td3.setBackground(Color.BLACK);
		td4.setBackground(Color.BLACK);

		td5.setBounds(0,118,200,1);
		l11.setBounds(30,80,150,30);

		td5.setBackground(Color.BLACK);
		l11.setFont(new Font("times new roman", Font.BOLD, 20));
		l11.setForeground(Color.BLUE);
		add(td5);
		add(l11);

		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(b1);
		add(b2);

		add(td1);
		add(td2);
		add(td3);
		add(td4);




		setVisible(true);
		setSize(3000,3000);
		b1.addActionListener(this);
		b2.addActionListener(this);
		ll1.addMouseMotionListener(this);
		ll1.addMouseListener(this);
		ll2.addMouseMotionListener(this);
		ll2.addMouseListener(this);
		ll3.addMouseMotionListener(this);
		ll3.addMouseListener(this);
		ll4.addMouseMotionListener(this);
		ll4.addMouseListener(this);



		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:MDII");
			st=cn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}



	}
public void actionPerformed(ActionEvent e)
{
	JButton b=(JButton)e.getSource();
//******************Submit Button Code***************************
	if(b==b1)
	{
//*******************************Validation for Name*****************************************
		int c=0;

			String ename=t1.getText();
			int enamel=ename.length();
			for(int i=0;i<enamel;i++)
			{
				char ch=ename.charAt(i);
				if(ch>='A' && ch<='Z' || ch>='a' && ch<='z' ||ch==' ')
				{

				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter Correct Value For Name Box");
				  c++;
					break;
				}
			}
//***********************************validation Of Contact*****************************************
			String econtact=t3.getText();
			int econtact1 =econtact.length();
			for(int i=0;i<econtact1;i++)
			{
				char ch=econtact.charAt(i);
				if(ch>='0' && ch<='9')
				{
					 if(econtact1==10)
					{


					}
					else
					{
							JOptionPane.showMessageDialog(null,"Enter Correct Value To Contact Box");
							c++;
							break;

					}

				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter Correct Value For Contact Box");
					c++;
					break;
				}
			}
//*********************************Validation E-MAIL*************************************************************************
										String t44;
										t44=t4.getText();
										if(t44.endsWith("@gmail.com"))
										{

										}
										else if(t44.endsWith("@yahoo.com"))
										{
										}
										else if(t44.endsWith("@rediff.com"))
										{
										}
										else
										{
											JOptionPane.showMessageDialog(null,"Worng Email");
											c++;


										}


//**************************************************************************************************************************

						String pswd=t5.getText();
						String cpswd=t6.getText();
						int pswd1=pswd.length();
						for(int i=0;i<pswd1;i++)
						{

							if(pswd.equals(cpswd))
							{

							}
							else
							{
								JOptionPane.showMessageDialog(null,"Enter Correct Confirm Password");
							  c++;
								break;
							}
						}
//******************************************Not Null Validation***********************************************************************
									if (t1.getText().equals("")) //name not null validation
									 {
											JOptionPane.showMessageDialog(null,"Fill Name Box");
											c++;
									 }

									 if (t2.getText().equals("")) //DOB not null validation
									 							 {
									 									JOptionPane.showMessageDialog(null,"Fill Date Of Birth Box");
									 									c++;
									 }
									 if (t4.getText().equals("")) //Email not null validation
									 							 {
									 									JOptionPane.showMessageDialog(null,"Fill E-mailBox");
									 									c++;
									 }
									 if (t3.getText().equals("")) //contact not null validation
									 							 {
									 									JOptionPane.showMessageDialog(null,"Fill Contact Box");
									 									c++;
									 }
									 if (t5.getText().equals("")) //Password not null validation
									 							 {
									 									JOptionPane.showMessageDialog(null,"Fill Password Box");
									 									c++;
							 			}
									 if (t6.getText().equals("")) // Confirm Password not null validation
										 							 {
										 								JOptionPane.showMessageDialog(null,"Fill  Confirm Password Box");
										 									c++;
							 			}





			if(c==0)
			{
				try
				{
					String inst="insert into CreatenewaccountAdmin values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"')";
					System.out.println(inst);
					int n=st.executeUpdate(inst);
					if(n>0)
					{
					JOptionPane.showMessageDialog(null,"Sucessfully Created Account");
					t1.setText(" ");
					t2.setText(" ");
					t3.setText(" ");
					t4.setText(" ");
					t5.setText(" ");
					t6.setText(" ");
					}
				}
				catch(Exception o)
				{
					System.out.println(o);
				}
			}
	 }
//**********Clear Button Code*****************************
	if(b==b2)
	{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
	}



}
public void mouseClicked(MouseEvent e)
{

		JLabel L = (JLabel)e.getSource();

		if (ll1 == L)
		{
			new LoginUser();
		}

		if (ll2 == L)
		{
			new CreateNewAccountUser();
		}
		if (ll3 == L)
		{
			new ForgotPasswordUser();
		}
		if (ll4 == L)
		{
			new Loginmain();
		}


}
public void mouseDragged(MouseEvent e)
{

}
public void mouseMoved(MouseEvent e)
{

}
public void mouseEntered(MouseEvent e)
{

}
public void mouseExited(MouseEvent e)
{

}

public void mousePressed(MouseEvent e)
{

}
public void mouseReleased(MouseEvent e)
{

}



	public static void main(String args[])
		{
			new CreateNewAccountUser();
	}
}