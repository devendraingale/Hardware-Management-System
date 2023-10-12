import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class LoginUser extends JFrame implements ActionListener,MouseMotionListener,MouseListener
{
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,limg,l11;
	JTextField t1,td1,td2,td3,td4,td5;
	TextField t2;
	Connection cn;
	Statement st;
	ResultSet rs;
	String str;
	JLabel ll1,ll2,ll3,ll4;
	ImageIcon img=new ImageIcon("Login.png");
	public LoginUser()
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
		limg=new JLabel(img);
		l1=new JLabel("Username");
		l2=new JLabel("Passward");
		l3=new JLabel("User Login");
		td1=new JTextField();
		td2=new JTextField();
		td3=new JTextField();
		td4=new JTextField();
		td5=new JTextField();
		l11=new JLabel("Quick Links");


		l3.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 30));



		t1=new JTextField();
		t2=new TextField();
		b1=new JButton("Login");
		b2=new JButton("Cancel");
		l4=new JLabel("Create New Account");
		l5=new JLabel("Forgot Password");
		l4.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
		l5.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));

		l4.setForeground(Color.BLUE);
		l5.setForeground(Color.BLUE);

		limg.setBounds(965,70,500,200);
		l1.setBounds(550,250,100,30);
		l2.setBounds(550,320,100,30);
		l3.setBounds(600,15,200,30);
		t1.setBounds(650,250,150,30);
		t2.setBounds(650,320,150,30);
		b1.setBounds(550,400,100,30);
		b2.setBounds(700,400,100,30);
		l4.setBounds(590,450,250,50);
		l5.setBounds(600,500,250,50);
		td1.setBounds(0,80,1500,1);
		td2.setBounds(0,660,1500,1);
		td3.setBounds(200,80,1,580);
		td4.setBounds(1050,80,1,580);


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


		add(td1);
		add(td2);
		add(td3);
		add(td4);
		t2.setEchoChar('*');
		setVisible(true);
		setSize(3000,3000);




		add(limg);
		add(l1);
		add(l2);
		add(l3);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		add(l4);
		add(l5);
		b1.addActionListener(this);
		l4.addMouseMotionListener(this);
		l4.addMouseListener(this);
		l5.addMouseMotionListener(this);
		l5.addMouseListener(this);
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
					Class.forName("sun.jdbc.odbc.JdbcOdbcriver");
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
	if(b==b1)
	{
			int c=0;
			//validation for DOB
			String cnadob=t1.getText();
			int cnadobl=cnadob.length();
			for(int i=0;i<cnadobl;i++)
			{
					char ch=cnadob.charAt(i);
					if(ch>='A' && ch<='Z' || ch>='a' && ch<='z'||ch>='0' && ch<='9'|| ch=='@'|| ch=='.')
					{

					}
					else
					{
								JOptionPane.showMessageDialog(null,"Enter Username");
								c++;
								break;

					}

				}



				if(c==0)
				{
						try
						{

											String username=t1.getText();
											String pswd=t2.getText();
											Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
											cn=DriverManager.getConnection("jdbc:odbc:MDII");
											st=cn.createStatement();

											String pqr="Select * from CreatenewaccountUser where Email='"+username+"'";

											ResultSet rs=st.executeQuery(pqr);

											System.out.println(rs);


											while(rs.next())
											{
												str=rs.getString(5);

											}
											if(str.equals(pswd))
											{

														JOptionPane.showMessageDialog(null,"Login Sucessfully");
														new MDIuser();

											}
											else
											{
													JOptionPane.showMessageDialog(null,"Enter Currect Username And Password");
											}
										cn.close();
						}
						catch(Exception m)
						{
											System.out.println(m);
						}

			}
		}
	}

	public void mouseClicked(MouseEvent e)
		{

			JLabel L = (JLabel)e.getSource();
			if (l4 == L)
			{
				new CreateNewAccountUser();
			}
			if (l5 == L)
			{
						new ForgotPasswordUser();
			}
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


	public static void main(String args[])
	{
		new LoginUser();
	}
}