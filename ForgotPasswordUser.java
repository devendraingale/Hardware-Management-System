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



public class ForgotPasswordUser extends JFrame implements ActionListener,MouseMotionListener,MouseListener
{
	JLabel l1,l2,l3,l4,limg,l10,l11;
	JButton b1,b2;
	JTextField t1,t2,t3,td1,td2,td3,td4,td5;
	Connection cn;
	Statement st;
	ResultSet rs;

	JLabel ll1,ll2,ll3,ll4;
	ImageIcon img=new ImageIcon("ForgotPassword.png");

	public ForgotPasswordUser()
	{
		setLayout(null);
		//***********************************************************************

				//**************Quick Links**********************************

								limg=new JLabel(img);
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
		l3=new JLabel("E-mail");
		l4=new JLabel("Forgot Password");
		l10=new JLabel("DD/MM/YYYY");

		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		td1=new JTextField();
		td2=new JTextField();
		td3=new JTextField();
		td4=new JTextField();
		td5=new JTextField();
		l11=new JLabel("Quick Links");
		b1=new JButton("Submint");
		b2=new JButton("Reset");
		l1.setBounds(520,250,100,30);
		l2.setBounds(520,300,100,30);
		l3.setBounds(520,350,100,30);
		l4.setBounds(560,40,250,30);
		l4.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 30));
		t1.setBounds(630,250,150,30);
		t2.setBounds(630,300,150,30);
		t3.setBounds(630,350,150,30);
		b1.setBounds(660,450,90,30);
		b2.setBounds(540,450,90,30);
		td1.setBounds(0,80,1500,1);
		td2.setBounds(0,660,1500,1);
		td3.setBounds(200,80,1,580);
		td4.setBounds(1050,80,1,580);
		td5.setBackground(Color.BLACK);

		td5.setBounds(0,118,200,1);
		l11.setBounds(30,80,150,30);
		l11.setFont(new Font("times new roman", Font.BOLD, 20));
		l11.setForeground(Color.BLUE);
		add(td5);
		add(l11);

		limg.setBounds(965,70,500,200);
		l10.setBounds(792,300,200,30);
		add(l10);


		td1.setBackground(Color.BLACK);
		td2.setBackground(Color.BLACK);
		td3.setBackground(Color.BLACK);
		td4.setBackground(Color.BLACK);



		add(td1);
		add(td2);
		add(td3);
		add(td4);
		add(b1);
		add(b2);
		add(t1);
		add(t2);
		add(t3);
		add(l2);
		add(l3);
		add(l1);
		add(l4);
		add(limg);
		setVisible(true);
		setSize(3000,3000);

		b1.addActionListener(this);
		b1.addActionListener(this);

		ll1.addMouseMotionListener(this);
		ll1.addMouseListener(this);
		ll2.addMouseMotionListener(this);
		ll2.addMouseListener(this);
		ll3.addMouseMotionListener(this);
		ll3.addMouseListener(this);
		ll4.addMouseMotionListener(this);
		ll4.addMouseListener(this);




}
	public void actionPerformed(ActionEvent ae)
	{
			JButton b=(JButton)ae.getSource();
			if(b==b1)
			{
					try
					{
						int c=0;
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection cn=DriverManager.getConnection("jdbc:odbc:MDII");
						Statement st=cn.createStatement();


						//validation for Name
						String cnaname=t1.getText();
						int cnanamel=cnaname.length();
						for(int i=0;i<cnanamel;i++)
						{
							char ch=cnaname.charAt(i);
       						if(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
			    			{

						    }
						    else
							{
								 JOptionPane.showMessageDialog(null,"Enter Correct Value");
								 c++;
	             		         break;

					    	}
					    	cn.close();
						}
                 		//End validation for Name

						//validation for DOB
						String cnadob=t2.getText();
						int cnadobl=cnadob.length();
						for(int i=0;i<cnadobl;i++)
							{
								char ch=cnadob.charAt(i);
								if(ch>='0' && ch<='9'||ch=='/')
				    			{

							    }
							    else
								{
										 JOptionPane.showMessageDialog(null,"Enter Correct Value");
									 c++;
		            	             break;

							    }
							    cn.close();
							}
							//End validation for DOB
							//validation for Email
							String email=t3.getText();
							int cnaemail=email.length();
							for(int i=0;i<cnaemail;i++)
							{
									char ch=email.charAt(i);
										if(ch>='A' && ch<='Z' || ch>='a' && ch<='z'||ch>='0' && ch<='9'||ch=='@'||ch=='.')
							 		{

								    }
								    else
									{
										 JOptionPane.showMessageDialog(null,"Enter Correct Value");
										 c++;
							             break;

								    }
								    cn.close();
							}
							//End validation 8for Email

//**********************Show Password*************************************************

							String name,dob,email1;
							name=t1.getText();
							dob=t2.getText();
							email1=t3.getText();
                            try
                              {
								  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								  Connection cn10=DriverManager.getConnection("jdbc:odbc:MDII");
								  Statement st10=cn10.createStatement();
								  String h="Select * from CreatenewaccountUser where Email='"+email1+"'and Date='"+dob+"' and Name='"+name+"'";

						          ResultSet rs2=st10.executeQuery(h);
							      rs2.next();
							      String q=rs2.getString(5);
							      JOptionPane.showMessageDialog(null,"Your Password Is  "+q);
							       t1.setText("");
								   t2.setText("");
								   t3.setText("");

						     }
						     catch(Exception o)
						        {
									System.out.println(o);
							}


					}
					catch(Exception x)
					{
						System.out.println(x);
					}
			}
//*********************************Reset Password**********************************
		if(b==b2)
		{
			try
			{
				 String name2,dob2,email2;
				 name2=t1.getText();
				 dob2=t2.getText();
				 email2=t3.getText();
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 cn=DriverManager.getConnection("jdbc:odbc:MDII");
				 st=cn.createStatement();
				 String temp="Select * from CreatenewaccountAdmin where Email='"+email2+"'and Date='"+dob2+"' and Name='"+name2+"'";
				 ResultSet rs=st.executeQuery(temp);
				 rs.next();
				 System.out.println(rs.getString(1));

				String Pswd=JOptionPane.showInputDialog("Enter Youer Password");
				String cPswd=JOptionPane.showInputDialog("Enter Youer Confirm Password");
				if(Pswd.equals(cPswd))
				{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						cn=DriverManager.getConnection("jdbc:odbc:MDII");
				 		st=cn.createStatement();
				 		int x=st.executeUpdate("Update CreatenewaccountUser set Password='"+Pswd+"' where Email='"+t3.getText()+"'");
				 		if(x>0)
				 		{
							 JOptionPane.showMessageDialog(null,"Your Password Is Changed");
							 t1.setText("");
							 t2.setText("");
							 t3.setText("");
						}

				}

		}
		catch(Exception o)
		{
					  				System.out.println(o);
		}
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

	public static void main(String args[]) throws Exception
	{
		new ForgotPasswordUser();

	}
}