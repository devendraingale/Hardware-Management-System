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




public class CustomerUser extends JFrame implements ActionListener,MouseMotionListener,MouseListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,limg,l9,l11;
	JTextField t1,t2,t4,t5,t6,td1,td2,td3,td4,td5;
	JTextArea t3;
	JButton b2,b3,b7,b8;
	int w;
	String a;
	Connection cn;
	Statement st;
	ResultSet rs;
	JLabel ll1,ll2,ll3,ll4,ll5,ll6;

	CheckboxGroup Gender = new CheckboxGroup();

	Checkbox op1 = new Checkbox("Male", Gender, true);
    Checkbox op2 = new Checkbox("Female", Gender, false);
    ImageIcon img=new ImageIcon("Customer.jpg");


	public CustomerUser()
	{
		setLayout(null);

		//**************Quick Links**********************************

				ll1=new JLabel("Customer");
				ll2=new JLabel("Employee");
				ll3=new JLabel("Product");
				ll4=new JLabel("Supplier");
				ll5=new JLabel("Sales Order");
				ll6=new JLabel("Exit");
				l9=new JLabel("DD/MM/YYYY");
				limg=new JLabel(img);

				ll1.setBounds(30,120,100,50);
				ll2.setBounds(30,180,100,50);
				ll3.setBounds(30,240,100,50);
				ll4.setBounds(30,300,100,50);
				ll5.setBounds(30,360,150,50);
				ll6.setBounds(30,420,150,50);

				ll1.setFont(new Font("times new roman", Font.BOLD, 20));
				ll2.setFont(new Font("times new roman", Font.BOLD, 20));
				ll3.setFont(new Font("times new roman", Font.BOLD, 20));
				ll4.setFont(new Font("times new roman", Font.BOLD, 20));
				ll5.setFont(new Font("times new roman", Font.BOLD, 20));
				ll6.setFont(new Font("times new roman", Font.BOLD, 20));

				add(ll1);
				add(ll2);
				add(ll3);
				add(ll4);
				add(ll5);
				add(ll6);
//***********************************************************************
		l1=new JLabel("Customer ID");
		l2=new JLabel("Name");
		l3=new JLabel("Address");
		l4=new JLabel("E-mail");
		l5=new JLabel("Contact");
		l6=new JLabel("Gender");
		l7=new JLabel("Date Of Birth");
		l8=new JLabel("Customer");
		l11=new JLabel("Quick Links");
		td5=new JTextField();


		l8.setFont(new Font("times new roman", Font.BOLD, 30));


		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextArea();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		td1=new JTextField();
		td2=new JTextField();
		td3=new JTextField();
		td4=new JTextField();




		b2=new JButton("Save");
		b3=new JButton("Search");

		b7=new JButton("Clear");
		b8=new JButton("Exit");




		limg.setBounds(965,70,500,200);
		l1.setBounds(500,120,150,30);
		l2.setBounds(500,170,150,30);
		l3.setBounds(500,225,150,30);
		l6.setBounds(500,300,150,30);
		l4.setBounds(500,350,100,30);
		l5.setBounds(500,400,150,30);
		l7.setBounds(500,450,150,30);
		l8.setBounds(580,20,200,30);
		l9.setBounds(828,450,200,30);

		t1.setBounds(620,120,200,30);
		t2.setBounds(620,170,200,30);
		t3.setBounds(620,220,200,60);
		t4.setBounds(620,350,200,30);
		t5.setBounds(620,400,200,30);
		t6.setBounds(620,450,200,30);

		td1.setBounds(0,60,1500,1);
		td2.setBounds(0,660,1500,1);
		td3.setBounds(200,60,1,600);
		td4.setBounds(1050,60,1,600);
		td5.setBounds(0,108,200,1);
		td5.setBackground(Color.BLACK);
		l11.setBounds(30,70,150,30);
		add(l11);
		l11.setFont(new Font("times new roman", Font.BOLD, 20));
		l11.setForeground(Color.BLUE);





		td1.setBackground(Color.BLACK);
		td2.setBackground(Color.BLACK);
		td3.setBackground(Color.BLACK);
		td4.setBackground(Color.BLACK);


		op1.setBounds(650,300,100,30);
		op2.setBounds(750,300,100,30);


		b2.setBounds(550,510,100,30);
		b3.setBounds(675,510,100,30);

		b7.setBounds(550,580,100,30);
		b8.setBounds(675,580,100,30);

		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(td1);
		add(td2);
		add(td3);
		add(td4);
		add(limg);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(td5);
		add(l11);


		add(b2);
		add(b3);

		add(b7);
		add(b8);

		add(op1);
		add(op2);

		setVisible(true);
		setSize(3000,3000);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);

		ll1.addMouseMotionListener(this);
		ll1.addMouseListener(this);
		ll2.addMouseMotionListener(this);
		ll2.addMouseListener(this);
		ll3.addMouseMotionListener(this);
		ll3.addMouseListener(this);
		ll4.addMouseMotionListener(this);
		ll4.addMouseListener(this);
		ll5.addMouseMotionListener(this);
		ll5.addMouseListener(this);
		ll6.addMouseMotionListener(this);
		ll6.addMouseListener(this);
		t1.setEnabled(false);

		try
		{
	//******************************************Auto increment BillId Code*****************************************
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				cn=DriverManager.getConnection("jdbc:odbc:MDII.mdb");
				st=cn.createStatement();
				ResultSet rs=st.executeQuery("Select * From Customer");
				while (rs.next())
				{
					 a=rs.getString(1);
					System.out.println(a);


				}
				w=Integer.parseInt(a);
				System.out.println(w);
				w=w+1;

				t1.setText(""+w);

		}
		catch(Exception p)
		{
				System.out.println(p);
		}



	}
	public void actionPerformed(ActionEvent ae)
	{
				JButton b=(JButton)ae.getSource();
//**********************inset Button Code*******************************************
		if(b==b2)
		{
			try
					{

						int c=0;
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						cn=DriverManager.getConnection("jdbc:odbc:MDII.mdb");
						st=cn.createStatement();

						boolean k=op1.getState();
						String Gender;
						if(k==true)
								Gender="Male";
						else
								Gender="Female";


 								/*Validation Code For Customer Name*/

                                 String cname=t2.getText();
                                 int cnamel=cname.length();
                                 for(int i=0;i<cnamel;i++)
                                    {
										 char ch=cname.charAt(i);
										if(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
										{
									    }
									    else
									       {
											   JOptionPane.showMessageDialog(null,"Enter Correct Name");
											   											     c++;
											       break;
										   }

									}

							String cadd=t3.getText();   ///Address Validation
							     int caddl=cadd.length();
							     for(int i=0;i<caddl;i++)
							     {
										 char ch=cadd.charAt(i);
										 if(ch>='A' && ch<='Z' || ch>='a' && ch<='z'||ch>='0' && ch<='9')
										 {
									     }

										else
										{
											 JOptionPane.showMessageDialog(null,"Enter Correct Address");
											 c++;
											 break;
									    }
								 }

	//************************************Validation Contact************************************************************
								 String contact=t5.getText();  // Validation Contact
							     int contactl=contact.length();
								 for(int i=0;i<contactl;i++)
								 {
								 			 char ch=contact.charAt(i);
								 			 if(ch>='0' && ch<='9')
								 			 {
												  if(contactl>10)
												  {
												 				JOptionPane.showMessageDialog(null,"Enter Correct Value To Correct contact");
												 				c++;
												 				break;

												  }
												  else
												  {

												  }
								 			 }

								 			else
								 			{
								 						 JOptionPane.showMessageDialog(null,"Enter Correct Value To Contact Text Box");
								 						 c++;
								 						 break;
								 			 }

							 	}


//********************************Email Validation********************************************************************
							 	String cemail=t4.getText();   ///E-mail Validation
							   int cemaill=cemail.length();
							   for(int i=0;i<cemaill;i++)
							 	{
									char ch=cemail.charAt(i);
									if(ch>='A' && ch<='Z' || ch>='a' && ch<='z'||ch>='0' && ch<='9'||ch=='@' || ch=='.')
									{
									}

									else
									{
											 JOptionPane.showMessageDialog(null,"Enter Correct Value to E-mail");
											 c++;
											 break;
								    }
								 }

//********************************Date Validation********************************************************************
								String t44;
							  String cdate=t6.getText();   ///
							   int cdatel=cdate.length();
							   t44=t6.getText();
							   for(int i=0;i<cdatel;i++)
							 	{
									char ch=cdate.charAt(i);
								 	    if(ch>='0' && ch<='9' || ch=='/')
											{

												String h="2017";
												String x="2015";
												if(t44.endsWith(h));
												{

													JOptionPane.showMessageDialog(null,"Enter Correct Value to Date box");
													c++;
														break;
												}



									}

								 		else
								 		{
								 				JOptionPane.showMessageDialog(null,"Enter Correct Value to Date box");
								 				c++;
								 			    break;
								 	   }
								 }
							 if (t2.getText().equals("")) //name not null validation
							 {
									JOptionPane.showMessageDialog(null,"Fill Name Box");
									c++;
							 }

							 if (t3.getText().equals("")) //Address not null validation
							 							 {
							 									JOptionPane.showMessageDialog(null,"Fill Address Box");
							 									c++;
							 }
							 if (t4.getText().equals("")) //Email not null validation
							 							 {
							 									JOptionPane.showMessageDialog(null,"Fill E-mailBox");
							 									c++;
							 }
							 if (t5.getText().equals("")) //contact not null validation
							 							 {
							 									JOptionPane.showMessageDialog(null,"Fill Contact Box");
							 									c++;
							 }
							 if (t6.getText().equals("")) //DOB not null validation
							 							 {
							 									JOptionPane.showMessageDialog(null,"Fill Date OF Birth Box");
							 									c++;
							 }

							//End Of Validation code of Customer Name
                    if(c==0)
                    {




								         String str="insert into Customer values("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+Gender+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"')";

									      int sv= st.executeUpdate(str);

									      if(sv>0)
									       {
										     JOptionPane.showMessageDialog(null,"Recored inserted");
										    cn.close();
									   		}
				   								int s;
												s=Integer.parseInt(t1.getText());
												s++;

									   			t1.setText(""+s);
			   									t2.setText(" ");
			   									t3.setText(" ");
			   									t4.setText(" ");
				   							t5.setText(" ");
											t6.setText(" ");

					}
		}
					catch(Exception e)
					{
					System.out.println(e);
					}


		}

//************************** Search Button Code****************************
	if(b==b3)
	{
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				cn=DriverManager.getConnection("jdbc:odbc:MDII.mdb");
				st=cn.createStatement();
				ResultSet rs;
				int temp;
				temp=Integer.parseInt(JOptionPane.showInputDialog("Enter 0 for Employee Id And 1 For Employee Name "));

				if(temp==0)
				{
						int cid;
						cid=Integer.parseInt(JOptionPane.showInputDialog("Enter Id"));
						String str="select * from Customer where Customer_Id="+cid;
						rs= st.executeQuery(str);
						while(rs.next())
						{
								t1.setText(rs.getString(1));
								t2.setText(rs.getString(2));
								t3.setText(rs.getString(3));
								String s=rs.getString(4);
								System.out.println(s);
								if(s.equals("Male"))
									op1.setState(true);
								else
									op2.setState(true);
								t4.setText(rs.getString(5));
								t5.setText(rs.getString(6));
								t6.setText(rs.getString(7));


						}



				}
			else if(temp==1)
							{
										String cname;
										cname=JOptionPane.showInputDialog("Enter Name");
										String str="select * from Customer where Customer_Name='"+cname+"'";
										rs= st.executeQuery(str);
										while(rs.next())
										{
													t1.setText(rs.getString(1));
													t2.setText(rs.getString(2));
													t3.setText(rs.getString(3));
													String s=rs.getString(4);

													if(s.equals("Male"))
																		op1.setState(true);
													else
																		op2.setState(true);
													t4.setText(rs.getString(5));
													t5.setText(rs.getString(6));
													t6.setText(rs.getString(7));



							}
				}
			}
			catch(Exception z)
			{
					System.out.println(z);
			}


		}
//******Clear Buttton Code*****************************
			if(b==b7)
			{
				try
				{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						cn=DriverManager.getConnection("jdbc:odbc:MDII.mdb");
						st=cn.createStatement();

						t2.setText(" ");
						t3.setText(" ");
						t4.setText(" ");
						t5.setText(" ");
						t6.setText(" ");
				}
				catch(Exception z)
				{
					System.out.println(z);
				}
			}
			if(b==b8)
			{
				new MDIuser();
			}
}
public void mouseClicked(MouseEvent e)
{

		JLabel L = (JLabel)e.getSource();

		if (ll1 == L)
		{
			new CustomerUser();
		}

		if (ll2 == L)
		{
			new EmployeeUser();
		}
		if (ll3 == L)
		{
			new ProductUser();
		}
		if (ll4 == L)
		{
			new SupplierUser();
		}
		if (ll5 == L)
		{
			new Bill();
		}
		if (ll6 == L)
		{
			new MDIuser();
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



	public static void main(String args[])throws Exception
		{
			new CustomerUser();
	}
}